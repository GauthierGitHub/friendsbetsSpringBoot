package friendsbets.core.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository ur;
	
	public User register(User u) {
		u.setTokenLastUsed(LocalDateTime.now());
		u = ur.save(u);
		u.setPassword(null);
		return u;
	}
	
	public User login(String email, String password) {
		User u = ur.findByEmailAndPassword(email, password);
		return register(u);	
	}

	public void update(User u) {
		ur.save(u);
	}
	
	public void delete(User u) {
		ur.delete(u);
	}

	public User findById(long id) {
		return ur.findById(id).orElseThrow();
	}
	
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}

	public boolean logout(String email) {
		User u = ur.findByEmail(email);
		if (u == null)
			throw new UsernameNotFoundException("invalid email");
		u.setToken(null);
		u.setTokenLastUsed(null);
		return u == null;
	}

}
