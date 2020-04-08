package friendsbets.core.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Friend;
import friendsbets.core.models.Group;
import friendsbets.core.repositories.GroupRepository;
import friendsbets.core.repositories.UserRepository;

@Service
public class GroupService {

	@Autowired
	GroupRepository gr;
	@Autowired
	UserRepository ur;

	public void save(Group g) {
		gr.save(g);
	}

	public void update(Group g) {
		gr.save(g);
	}

	public List<Group> findAll() {
		return gr.findAll();
	}

	public void addFriend(Group g, Friend f) {
		g.addFriend(f);
		update(g);
	}

	public Group findById(long id) {
		return gr.findById(id).orElseThrow();
	}

	public Set<Group> findAllForOneUser(long id){
		return gr.findAllForOneUser(id);
	}

}
