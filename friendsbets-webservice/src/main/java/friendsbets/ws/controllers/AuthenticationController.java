package friendsbets.ws.controllers;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static friendsbets.core.security.SecurityConstants.SECRET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;

import friendsbets.core.models.User;
import friendsbets.core.services.AuthenticationService;
import friendsbets.core.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	AuthenticationService as;
	
	@Autowired
	UserService us;
	
	private BCryptPasswordEncoder passwordEncoder;
	
	public AuthenticationController() {
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@PostMapping("/register")
	public User register(@RequestBody User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setToken(JWT.create().sign(HMAC512(SECRET.getBytes())));
		u.setTokenLastUsed();
		return as.register(u);
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String email, @RequestParam String password) throws RuntimeException {
		User u = us.findByEmail(email);
		u = passwordEncoder.matches(password, u.getPassword()) ? u : null;
		if (u != null) {
			u.setTokenLastUsed();
			us.save(u);
			u.setPassword(null);
			return u;
		} else
			throw new RuntimeException(); //TODO: error
		
	}

}
