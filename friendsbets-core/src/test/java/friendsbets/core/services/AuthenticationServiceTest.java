package friendsbets.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import friendsbets.core.models.User;
import friendsbets.core.testbase.ServiceUnitTestBase;

class AuthenticationServiceTest extends ServiceUnitTestBase {

	@Autowired
	AuthenticationService authenticationService;
	
	@Test
	void testRegister() {
		// data fixtures
		User u1 = new User(1, "nickname1", "email1", "password1");
		// configuring mock
		when(userRepository.save(u1)).thenReturn(u1);
		// state test
		assertEquals(u1, authenticationService.register(u1), "Saving a user should return it");
		// behavior test
		verify(userRepository, times(1)).save(u1);
		verifyNoMoreInteractions(userRepository);
	}
	
	@Test
	void findByEmail() {
		// data fixtures
		User u1 = new User(1, "nickname1", "email1", "password1");
		when(userRepository.findByEmail("email1")).thenReturn(u1);
		assertEquals(u1, authenticationService.findByEmail("email1"));
		verify(userRepository, times(1)).findByEmail("email1");
		verifyNoMoreInteractions(userRepository);
	}

}
