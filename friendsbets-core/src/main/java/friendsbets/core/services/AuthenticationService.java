package friendsbets.core.services;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static friendsbets.core.security.SecurityConstants.SECRET;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;

import friendsbets.core.aspects.deletepasswords.DeletePasswords;
import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository ur;
	
	@DeletePasswords
	public User register(User u) {
		u.setToken(JWT.create().sign(HMAC512(SECRET.getBytes())));
		System.out.println(u.getToken());
		u.setTokenLastUsed(LocalDateTime.now());
		return ur.save(u);
	}
	
	@DeletePasswords
	public User login(String email, String password) {
		User u = ur.findByEmail(email);
		u = passwordEncoder.matches(password, u.getPassword()) ? u : null; // TODO: return error.
		return u;
	}

	public void update(User u) {
		ur.save(u);
	}
	
	public void delete(User u) {
		ur.delete(u);
	}

}
