package friendsbets.ws.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.models.Friend;
import friendsbets.core.services.FriendService;

@RestController
@CrossOrigin // not needed, declared for all in Webappconfig
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	FriendService fs;

	@GetMapping("")
	public Set<Friend> findAll() {
		return fs.findAll();
	}

	@GetMapping("/{id}")
	public Friend findById(@PathVariable int id) {
		return fs.findById(id);
	}

//	@GetMapping({ "/search", "/search/{pattern}" })
//	public Set<Friend> findByAliasOrEmailLike(@PathVariable(name = "pattern", required = false) String pattern) {
////		Logger.getLogger(getClass()).info("//////////!!! search = " + pattern);
//		return fs.findByNicknameOrEmailLike(pattern == null ? "" : pattern);
//	}
	
	/**
	 * Find all user except the one who's searching
	 * @param id
	 * @return
	 */
	@GetMapping("/find/{id}")
	public Set<Friend> findAllOthers(@PathVariable int id) {
		return fs.findAllOthers(id);
	}
	
	/**
	 * Find all friends for one user
	 * @param id
	 * @return
	 */
	@GetMapping("/findfriends/{id}")
	public Set<Friend> findFriends(@PathVariable int id) {
		return fs.findFriends(id);
	}
	
	/**
	 * Add several friends to a user
	 */
	@PostMapping("/add/{id}")
	public void addFriends(@PathVariable long id, @RequestBody Set<Friend> friends) {
		fs.addFriends(id, friends);
	}
}
