package friendsbets.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import friendsbets.core.models.Friend;
import friendsbets.core.repositories.FriendRepository;

@SpringBootTest
class FriendServiceTest {

	@Mock
	FriendRepository fr;
	
	@InjectMocks
	FriendService fs;
	
	// data fixtures
	List<Friend> usersList;
	Set<Friend> friendsList;
	Set<Friend> others;
	Friend f1 = new Friend(1L, "nickname1");
	Friend f2 = new Friend(2L, "nickname2");
	Friend f3 = new Friend(3L, "nickname3");
	
	FriendServiceTest() {
		usersList = new ArrayList<Friend>();
		usersList.add(f1);
		usersList.add(f2);
		usersList.add(f3);
		friendsList = new HashSet<Friend>();
		friendsList.add(f2);
		others = new HashSet<Friend>();
		others.add(f3);
	}

	// reseting mocks after each use
	@AfterEach
	void resetMock() {
		reset(fr);
	}
	
	@Test
	void findAll() {
		when(fr.findAll()).thenReturn(usersList);
		assertEquals(usersList, fs.findAll(), "Searching all users should return a list of user");
		verify(fr, times(1)).findAll();
		verifyNoMoreInteractions(fr);
	}

	@Test
	void findFriends() {
		when(fr.findFriends(1)).thenReturn(friendsList);
		assertEquals(friendsList, fs.findFriends(1));
		verify(fr, times(1)).findFriends(1);
		verifyNoMoreInteractions(fr);
	}
	
	@Test
	void findAllOthers() {
		when(fr.findAllOthers(1)).thenReturn(others);
		assertEquals(others, fs.findAllOthers(1));
		verify(fr, times(1)).findAllOthers(1);
		verifyNoMoreInteractions(fr);
	}

}
