package friendsbets.ws.controllers;

import org.jboss.logging.Logger;
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
		System.out.println("save group :");
		System.out.println(g);
		g.getUsers().stream().forEach(x -> Logger.getLogger(x.getClass() + " " + x.toString()).info(x.getId()));
		gs.save(g);
	}

	@PostMapping("/{id}")
	public void update(@RequestBody Group g, @PathVariable int id) {
		g.setId(id);
		gs.save(g);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		gs.delete(gs.findById(id));
	}
	
	@GetMapping("/mygroups/{id}")
	public Set<Group> findAllForOneUser(@PathVariable int id) {
		return gs.findAllForOneUser(id);
	}
}
