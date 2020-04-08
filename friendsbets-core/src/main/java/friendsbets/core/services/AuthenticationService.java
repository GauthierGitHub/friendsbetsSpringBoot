package friendsbets.core.services;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static friendsbets.core.security.SecurityConstants.SECRET;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;

import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository ur;
	
	public User register(User u) {
		return ur.save(u);
	}

}
