package friendsbets.core.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Friend;
import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;

@Service
public class FriendService {

	@Autowired
	UserRepository ur;

	private Set<Friend> usersToFriends(List<User> users) {
		return users.stream().map(User::toFriend).collect(Collectors.toSet());
	}

	private Set<Friend> usersToFriends(Set<User> users) {
		return users.stream().map(User::toFriend).collect(Collectors.toSet());
	}

	public Set<Friend> findAll() { // Set ?
		return usersToFriends(ur.findAll());
	}

	public Friend findById(long id) {
		return ur.findById(id).orElseThrow().toFriend();
	}

	// @DeletePassword password needed by UserDetailsServiceImpl
	public Friend findByNickname(String nickname) {
		return ur.findByNickname(nickname).toFriend();
	}

	public Friend findByEmailAndPassword(String email, String password) {
		return ur.findByEmailAndPassword(email, password).toFriend();
	}

	public Set<Friend> findFriends(long id) {
		return usersToFriends(ur.findFriends(id));
	}

	public void addFriends(long id, Set<Friend> friends) {
		friends.forEach(x -> ur.addFriends(id, x.toUser()));
	}

	public Set<Friend> findAllOthers(long id) {
		return usersToFriends(ur.findAllOthers(id));
	}

	public Set<Friend> findByNicknameOrEmailLike(String pattern) {
		return usersToFriends(ur.findByNicknameOrEmailLike(pattern));
	}

}
