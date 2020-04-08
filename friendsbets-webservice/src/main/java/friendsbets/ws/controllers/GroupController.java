package friendsbets.ws.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import friendsbets.core.models.Group;
import friendsbets.core.services.GroupService;

@RestController
@CrossOrigin
@RequestMapping(value="/group", produces="application/json")
public class GroupController {

	@Autowired
	GroupService gs;

	@GetMapping("")
	public List<Group> findAll() {
		return gs.findAll();
	}

	@GetMapping("/{id}")
	public Group findById(@PathVariable int id) {
		return gs.findById(id);
	}

	@PostMapping("")
	public void save(@RequestBody Group g) {
		gs.save(g);
	}
	
	@GetMapping("/mygroups/{id}")
	public Set<Group> findAllForOneUser(@PathVariable int id) {
		return gs.findAllForOneUser(id);
	}
}
