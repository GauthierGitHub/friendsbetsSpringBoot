package friendsbets.core.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import friendsbets.core.models.Group;

@SpringBootTest
@Transactional // get the default rollback behaviour for each test method. 
class GroupRepositoryIT {

	@Autowired
	GroupRepository gr;
	
	@Autowired
	UserRepository ur;
	
	/**
	 * Check if findAllForOneUser return right groups.
	 * User with id 1 is engaged with group 17 and 22.
	 * Equals method for group verify only id.
	 */
	@Test
	void testFindAllForOneUser() { 
		Group g1 = new Group();
		g1.setId(17);
		Group g2 = new Group();
		g2.setId(22);
		Set<Group> hs = new HashSet<>();
		hs.add(g1);
		hs.add(g2);
		assertEquals(hs, gr.findAllForOneUser(1), "Searching all groups for user 1 should return group 17 and 22");
		// verifyNoMoreInteractions(gr.findAllForOneUser(1)); // only mock
		// reset h2 database ?
	}
	


}
