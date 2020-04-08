package friendsbets.core.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.aspects.deletepasswords.DeletePasswords;
import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

/**
 * All methods what return Users or update user database Exception from dao are
 * caught here and encapsulate into one for code factorization encapsulator util
 * throw traits exception and throw more precise FriendsBetsExceptions TODO
 * others exceptions in service layer
 * 
 * @author gauthier
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository ur;

	// TODO: Validator
//	public static final transient Validator<User> VALIDATOR = new Validator<User>()
//			.addRule("alias", "Alias \"Pierre\" is not allowed !", 
//					me -> !me.getNickname().toLowerCase().equals("pierre"));

	@DeletePasswords
	public User save(User u) {
		return ur.save(u); // automatic dirty checking set u.id
	}

	@DeletePasswords
	public List<User> findAll() { // TODO: set not list
		return ur.findAll();
	}

	@DeletePasswords
	public User findById(long id) {
		return ur.findById(id).orElseThrow();
	}

	@DeletePasswords
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}

	//@DeletePassword password needed by UserDetailsServiceImpl
	public User findByNickname(String nickname) {
		return ur.findByNickname(nickname);
	} 

	@DeletePasswords
	public User findByEmailAndPassword(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}

	@DeletePasswords
	public Set<User> findFriends(long id) {
		return ur.findFriends(id); // TODO: with user ? see repository
	}
	
	public void addFriends(long id, HashSet<User> friends) {
		friends.stream().forEach(x -> ur.addFriends(id, x)); // TODO: Do with list ?
	}

	@DeletePasswords
	public Set<User> findAllOthers(long id) {
		return ur.findAllOthers(id);
	}

	@DeletePasswords
	public Set<User> findByNicknameOrEmailLike(String pattern) {
		return ur.findByNicknameOrEmailLike(pattern);
	}


}
