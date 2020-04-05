package friendsbets.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import friendsbets.core.aspects.deletepasswords.DeletePassword;
import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository ur;
	
	@DeletePassword
	public User register(User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return ur.save(u);
	}
	
	@DeletePassword
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
