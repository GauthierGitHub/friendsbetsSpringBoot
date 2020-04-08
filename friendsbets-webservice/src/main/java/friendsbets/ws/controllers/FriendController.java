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
import friendsbets.core.models.User;
import friendsbets.core.services.FriendService;
import friendsbets.core.services.UserService;

@RestController
@CrossOrigin // not needed, declared for all in Webappconfig
@RequestMapping("/friend")
public class FriendController {

	@Autowired
	FriendService fs;

	@Autowired
	UserService us;
	
	@GetMapping("/{id}")
	public Friend findById(@PathVariable int id) {
		return fs.findById(id);
	}
	
	/**
	 * Find all user except param id
	 * @param id
	 * @return
	 */
	@GetMapping("/find/{id}")
	public Set<Friend> findAllOthers(@PathVariable int id) {
		return fs.findAllOthers(id);
	}
	
	/**
	 * Find all friends for a user
	 * @param id
	 * @return
	 */
	@GetMapping("/myfriends/{id}")
	public Set<Friend> findFriends(@PathVariable int id) {
		return fs.findFriends(id);
	}
	
	/**
	 * Add several friends to a user
	 */
	@PostMapping("add/{id}")
	public void addFriends(@PathVariable long id, @RequestBody Set<Friend> friends) {
		us.addFriends(id, friends);
	}
}
