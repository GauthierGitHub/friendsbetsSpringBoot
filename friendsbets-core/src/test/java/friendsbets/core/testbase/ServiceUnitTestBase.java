package friendsbets.core.testbase;

import org.springframework.boot.test.mock.mockito.MockBean;

import friendsbets.core.repositories.GroupRepository;
import friendsbets.core.repositories.UserRepository;

/**
 * 
 * @author Gauthier Barbet <a href="https://gitlab.com/gauthiergitlab"> @gauthiergitlab </a>
 *
 */
public class ServiceUnitTestBase extends UnitTestBase {
	
	@MockBean
	protected UserRepository userRepository;

	@MockBean
	protected GroupRepository groupRepository;

}
