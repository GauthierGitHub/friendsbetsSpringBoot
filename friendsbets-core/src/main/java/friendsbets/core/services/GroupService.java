package friendsbets.core.services;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Group;
import friendsbets.core.models.User;
import friendsbets.core.repositories.GroupRepository;
import friendsbets.core.repositories.UserRepository;

@Service
public class GroupService {

	@Autowired
	GroupRepository gr;
	@Autowired
	UserRepository ur;

	public void save(Group g) {
		g.getUserList().stream()
			.map(u -> u.getGrpList())
			.filter(Objects::nonNull)
			.forEach(gl -> gl.add(g)); // automatic dirty checking save them in db
	}

	public void delete(Group g) {
		gr.delete(g);
	}

	public void update(Group g) {
		gr.save(g);
	}

	public List<Group> findAll() {
		return gr.findAll();
	}

	public void addUserToGroup(Group g, User u) {
		g.getUserList().add(u);
		update(g);
	}

	public Group findById(long id) {
		return gr.findById(id).orElseThrow();
	}

	public Set<Group> findAllForOneUser(long id){
		return gr.findAllForOneUser(id);
	}

}
