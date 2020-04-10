package friendsbets.core.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Friend;
import friendsbets.core.models.User;
import friendsbets.core.repositories.FriendRepository;

@Service
public class FriendService {

	@Autowired
	FriendRepository fr;


	public List<Friend> findAll() {
		return fr.findAll();
	}

	public Friend findById(long id) {
		return fr.findById(id).orElseThrow();
	}

	public Friend findByNickname(String nickname) {
		return fr.findByNickname(nickname);
	} 

	public Set<Friend> findFriends(long id) {
//		return fr.findAll().stream().distinct().collect(Collectors.toSet());
		
		return fr.findFriends(id);
	}
	
	public Set<Friend> findAllOthers(long id) {
		return fr.findAllOthers(id);
	}

	public Set<Friend> findByNicknameOrEmailLike(String pattern) {
		return fr.findByNicknameOrEmailLike(pattern);
	}


}
