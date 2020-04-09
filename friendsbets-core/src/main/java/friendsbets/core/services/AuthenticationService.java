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

}
