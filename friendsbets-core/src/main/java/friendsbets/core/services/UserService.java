package friendsbets.core.services;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Friend;
import friendsbets.core.models.User;
import friendsbets.core.repositories.FriendRepository;
import friendsbets.core.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	@Autowired
	FriendRepository fr;

	public User save(User u) {
		return ur.save(u);
	}
	
	/**
	 * Friendship as reciprocity
	 * @param id
	 * @param friends
	 */
	public void addFriends(long id, Set<Friend> friends) {
		User u = findById(id);
		Set<User> users = friends.stream()
				.map( f -> findById(f.getId()))
				.collect( Collectors.toSet());
		users.forEach(f -> f.friendship(u));
		u.friendship(friends);
		users.add(u);
		users.forEach(user -> fr.save(user));
	}
	
	public User findById(long id) {
		return ur.findById(id).orElseThrow();
	}

	/**
	 * Used by Spring Security
	 * @param nickname
	 * @return
	 */
	public User findByNickname(String nickname) {
		return ur.findByNickname(nickname);
	}

	/**
	 * Used by AuthenticationController
	 * @param email
	 * @return
	 */
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return ur.findByEmail(email);
	}




}
