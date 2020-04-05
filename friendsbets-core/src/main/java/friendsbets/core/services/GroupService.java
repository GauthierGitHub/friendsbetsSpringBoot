package friendsbets.core.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Group;
import friendsbets.core.models.User;
import friendsbets.core.repositories.GroupRepository;
import friendsbets.core.repositories.UserRepository;

/**
 * TODO Exceptions
 * 
 * All methods what return Groups or update group database
 * 
 * @author gauthier
 *
 */
@Service
public class GroupService {

	@Autowired
	GroupRepository gr;
	@Autowired
	UserRepository ur;

	public void save(Group g) {
//		gr.save(g); // doesn't work with new constructor
//		g.getUserList().stream().forEach(user-> {
//			user.getGrpList().add(g); // automatic dirty checking save them in db
//		});
		g.getUserList().stream()
			.map(u -> u.getGrpList())
			.filter(l -> l != null)
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
	
	/**
	 * not needed cause eager fetchType in user ?????
	 */
//	public List<FriendsBetsGroup> findAllGroupForOneUser(FriendsBetsUser u) throws GroupNotFoudException {
//		return gr.findAllGroupForOneUser(u);
//	}
}
