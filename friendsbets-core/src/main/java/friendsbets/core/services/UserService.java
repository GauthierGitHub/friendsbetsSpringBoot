package friendsbets.core.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;


	public User save(User u) {
		return ur.save(u);
	}

	public List<User> findAll() {
		return ur.findAll();
	}

	public User findById(long id) {
		return ur.findById(id).orElseThrow();
	}

	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}

	//@DeletePassword password needed by UserDetailsServiceImpl
	public User findByNickname(String nickname) {
		return ur.findByNickname(nickname);
	} 

	public User findByEmailAndPassword(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}

	public Set<User> findFriends(long id) {
		return ur.findFriends(id);
	}
	
	public void addFriends(long id, Set<User> friends) {
		friends.stream().forEach(x -> ur.addFriends(id, x));
	}

	public Set<User> findAllOthers(long id) {
		return ur.findAllOthers(id);
	}

	public Set<User> findByNicknameOrEmailLike(String pattern) {
		return ur.findByNicknameOrEmailLike(pattern);
	}


}
