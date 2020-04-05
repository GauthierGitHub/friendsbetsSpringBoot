package friendsbets.ws.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.models.User;
import friendsbets.core.services.UserService;

@RestController
@CrossOrigin // not needed, declared for all in Webappconfig
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;

	@GetMapping("")
	public List<User> findAll() {
		return us.findAll();
	}

	@GetMapping("/{id}")
	public User findById(@PathVariable int id) {
		return us.findById(id);
	}

	@GetMapping({ "/search", "/search/{pattern}" })
	public Set<User> findByAliasOrEmailLike(@PathVariable(name = "pattern", required = false) String pattern) {
//		Logger.getLogger(getClass()).info("//////////!!! search = " + pattern);
		return us.findByNicknameOrEmailLike(pattern == null ? "" : pattern);
	}
	
	/**
	 * Find all user except param id
	 * @param id
	 * @return
	 */
	@GetMapping("/find/{id}")
	public Set<User> findAllOthers(@PathVariable int id) {
		return us.findAllOthers(id);
	}
	
	/**
	 * Find all friends for a user
	 * @param id
	 * @return
	 */
	@GetMapping("/friends/{id}")
	public Set<User> findFriends(@PathVariable int id) {
		return us.findFriends(id);
	}
	
	/**
	 * Add several friends to a user
	 */
	@PostMapping("/friends/add/{id}")
	public void addFriends(@PathVariable int id, @RequestBody HashSet<User> friends) {
		us.addFriends(id, friends);
	}
}
