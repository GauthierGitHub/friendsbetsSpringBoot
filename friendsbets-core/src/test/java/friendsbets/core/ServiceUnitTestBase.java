package friendsbets.core;

import org.springframework.boot.test.mock.mockito.MockBean;

import friendsbets.core.repositories.UserRepository;

public class ServiceUnitTestBase extends UnitTestBase {
	
	@MockBean
	protected UserRepository userRepository;

}
