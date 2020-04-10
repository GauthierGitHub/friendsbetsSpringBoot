package friendsbets.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	UserRepository ur;
	
	public User register(User u) {
		return ur.save(u);
	}
	
	public User login(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}

	public void update(User u) {
		ur.save(u);
	}
	
	public void delete(User u) {
		ur.delete(u);
	}

}
