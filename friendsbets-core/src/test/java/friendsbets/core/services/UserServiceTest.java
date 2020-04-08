package friendsbets.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import friendsbets.core.models.User;
import friendsbets.core.repositories.UserRepository;
import friendsbets.core.services.UserService;

@SpringBootTest
class UserServiceTest {
	
	// mock objects
	@Mock
	UserRepository ur;
	
	// object under test
	@InjectMocks
	UserService us;
	
	// data fixtures TODO: static final ? Given ?
	User u1 = new User(1, "nickname1", "email1", "password1");
			
	// reseting mocks after each use
	@AfterEach
	void resetMock() {
		reset(ur);
	}
	
	
	@Test
	void findById() {
		// configuring mock
		when(ur.findById(1L)).thenReturn(Optional.of(u1));
		when(ur.findById(5L)).thenReturn(Optional.empty());
		// state test
		assertEquals(u1, us.findById(1)
				, "Searching an existing user should return it.");
		assertThrows(NoSuchElementException.class, () -> us.findById(5)
				, "Searching a non-existing user should throw a NoSuchElementException exception");
		// behavior test
		verify(ur, times(1)).findById(1L);
		verify(ur, times(1)).findById(5L);
		verifyNoMoreInteractions(ur);
	}

}
