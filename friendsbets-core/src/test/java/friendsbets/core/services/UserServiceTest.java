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
import org.springframework.beans.factory.annotation.Autowired;

import friendsbets.core.models.Friend;
import friendsbets.core.models.User;
import friendsbets.core.testbase.ServiceUnitTestBase;

class FriendServiceTest extends ServiceUnitTestBase {

	@Autowired
	FriendService friendService;

//	// data fixtures 
//	User u1 = new User(1, "nickname1", "email1", "password1");
//	User u2 = new User(2, "nickname2", "email2", "password2");
//	User u3 = new User(3, "nickname3", "email3", "password3");
//	User u4 = new User("nickname4", "email4", "password4");
//	List<User> lu = new ArrayList<User>();
//	Set<Friend> friends = new HashSet<>();
//	Set<User> others = new HashSet<User>();
//
//	public FriendServiceTest() {
//		lu.add(u1);
//		lu.add(u2);
//		lu.add(u3);
//		lu.add(u4);
//		friends.add(new Friend(u2));
//		friends.add(new Friend(u3));
//		others.add(u2);
//		others.add(u3);
//		others.add(u4);
//	}
//
//	// reseting mocks after each use
//	@AfterEach
//	void resetMock() {
//		reset(userRepository);
//	}
//
//
//	@Test
//	void findAll() {
//		when(userRepository.findAll()).thenReturn(lu);
//		assertEquals(lu, friendService.findAll(), "Searching all users should return a list of user");
//		verify(userRepository, times(1)).findAll();
//		verifyNoMoreInteractions(userRepository);
//	}
//
//	@Test
//	void findById() {
//		// configuring mock
//		when(userRepository.findById(1L)).thenReturn(Optional.of(u1));
//		when(userRepository.findById(5L)).thenReturn(Optional.empty());
//		// state test
//		assertEquals(u1, friendService.findById(1), "Searching an existing user should return it.");
//		assertThrows(NoSuchElementException.class, () -> friendService.findById(5),
//				"Searching a non-existing user should throw a NoSuchElementException exception");
//		// behavior test
//		verify(userRepository, times(1)).findById(1L);
//		verify(userRepository, times(1)).findById(5L);
//		verifyNoMoreInteractions(userRepository);
//	}
//
//	@Test
//	void findByEmailAndPassword() {
//		when(userRepository.findByEmailAndPassword("email1", "password1")).thenReturn(u1);
//		assertEquals(u1, friendService.findByEmailAndPassword("email1", "password1"));
//		verify(userRepository, times(1)).findByEmailAndPassword("email1", "password1");
//		verifyNoMoreInteractions(userRepository);
//	}
//
//	@Test
//	void findFriends() {
//		when(userRepository.findFriends(1)).thenReturn(others);
//		assertEquals(friends, friendService.findFriends(1));
//		verify(userRepository, times(1)).findFriends(1);
//		verifyNoMoreInteractions(userRepository);
//	}
//
//	@Test
//	void addFriends() {
//		friendService.addFriends(1L, friends); // the friends set is u2 u3
//		verify(userRepository, times(1)).addFriends(1L, u2.toFriend());
//		verify(userRepository, times(1)).addFriends(1L, u3.toFriend());
//		verifyNoMoreInteractions(userRepository);
//	}
//
//	@Test
//	void findAllOthers() {
//		when(userRepository.findAllOthers(1)).thenReturn(others);
//		assertEquals(others, friendService.findAllOthers(1));
//		verify(userRepository, times(1)).findAllOthers(1);
//		verifyNoMoreInteractions(userRepository);
//
//	}
	
}
