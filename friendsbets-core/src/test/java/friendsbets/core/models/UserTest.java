package friendsbets.core.models;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("unit-test")
class UserTest {

	User u;

	@Test
	void testGetSetId() {
		// Given
		long idConstructor = 1L;
		long idSetter = Long.MAX_VALUE;
		String nickname = null;
		String email = null;
		String password = ""; // Can throw NullPointerException with class Password
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(idConstructor, nickname, email, password, picturePath, betsInitialized, betsFollowed,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(idConstructor, user.getId(), "getId() from constructor.");
		assertDoesNotThrow(() -> user.setId(idSetter), "setId() after constructor.");
		assertEquals(idSetter, user.getId(), "getId() from setter.");
	}

	@Test
	void testGetSetNickname() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nicknameConstructor = "a";
		String nicknameSetter = "b";
		String email = null;
		String password = "";
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nicknameConstructor, email, password, picturePath, betsInitialized, betsFollowed,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(nicknameConstructor, user.getNickname(), "getNickname() from constructor.");
		assertDoesNotThrow(() -> user.setNickname(nicknameSetter), "setNickname() after constructor.");
		assertEquals(nicknameSetter, user.getNickname(), "getNickname() from setter.");
	}

	@Test
	void testGetSetEmail() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String emailSetter = "a";
		String emailConstructor = "b";
		String password = "";
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, emailConstructor, password, picturePath, betsInitialized, betsFollowed,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(emailConstructor, user.getEmail(), "getEmail() from constructor.");
		assertDoesNotThrow(() -> user.setEmail(emailSetter), "setEmail() after constructor.");
		assertEquals(emailSetter, user.getEmail(), "getEmail() from setter.");
	}

	@Test
	void testGetSetPassword() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String passwordSetter = "a";
		String passwordConstructor = "b";
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, passwordConstructor, picturePath, betsInitialized, betsFollowed,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(passwordConstructor, user.getPassword(), "getPassword() from constructor.");
		assertDoesNotThrow(() -> user.setPassword(passwordSetter), "setPassword() after constructor.");
		assertEquals(passwordSetter, user.getPassword(), "getPassword() from setter.");
	}

	@Test
	void testGetSetPicturePath() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = null;
		String picturePathSetter = "a";
		String picturePathConstructor = "b";
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, password, picturePathConstructor, betsInitialized, betsFollowed,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(picturePathConstructor, user.getPicturePath(), "getPicturePath() from constructor.");
		assertDoesNotThrow(() -> user.setPicturePath(picturePathSetter), "setPicturePath() after constructor.");
		assertEquals(picturePathSetter, user.getPicturePath(), "getPicturePath() from setter.");
	}

	@Test
	void testGetSetBetsInitialized() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = null;
		String picturePath = null;
		Set<Bet> betsInitializedSetter = new HashSet<>(Arrays.asList(new Bet(), new Bet()));
		Set<Bet> betsInitializedConstructor = new HashSet<>(Arrays.asList(new Bet(), new Bet()));
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, password, picturePath, betsInitializedConstructor, betsFollowed,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(betsInitializedConstructor, user.getBetsInitialized(), "getBetsInitialized() from constructor.");
		assertDoesNotThrow(() -> user.setBetsInitialized(betsInitializedSetter),
				"setBetsInitialized() after constructor.");
		assertEquals(betsInitializedSetter, user.getBetsInitialized(), "getBetsInitialized() from setter.");
	}

	@Test
	void testGetSetBetsFollowed() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = null;
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowedSetter = new HashSet<>(Arrays.asList(new Bet(), new Bet()));
		Set<Bet> betsFollowedConstructor = new HashSet<>(Arrays.asList(new Bet(), new Bet()));
		Set<Group> groups = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, password, picturePath, betsInitialized, betsFollowedConstructor,
				groups, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(betsFollowedConstructor, user.getBetsFollowed(), "getBetsFollowed() from constructor.");
		assertDoesNotThrow(() -> user.setBetsFollowed(betsFollowedSetter), "setBetsFollowed() after constructor.");
		assertEquals(betsFollowedSetter, user.getBetsFollowed(), "getBetsFollowed() from setter.");
	}

	@Test
	void testGetSetGroups() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = ""; // Can throw NullPointerException with class Password
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groupsSetter = new HashSet<>(Arrays.asList(new Group(1L)));
		Set<Group> groupsConstructor = new HashSet<>(Arrays.asList(new Group(2L)));;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, password, picturePath, betsInitialized, betsFollowed,
				groupsConstructor, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(groupsConstructor, user.getGroups(), "getGroups() from constructor.");
		assertDoesNotThrow(() -> user.setGroups(groupsSetter), "setGroups() after constructor.");
		assertEquals(groupsSetter, user.getGroups(), "getGroups() from setter.");
	}

	@Test
	void testGetSetFriends() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = ""; // Can throw NullPointerException with class Password
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friendsSetter = new HashSet<>(Arrays.asList(new User(1L), new User(2L)));
		Set<User> friendsConstructor = new HashSet<>(Arrays.asList(new User(3), new User(4)));
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, password, picturePath, betsInitialized, betsFollowed,
				groups, friendsConstructor, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(friendsConstructor, user.getFriends(), "getFriends() from constructor.");
		assertDoesNotThrow(() -> user.setFriends(friendsSetter), "setFriends() after constructor.");
		assertEquals(friendsSetter, user.getFriends(), "getFriends() from setter.");
	}
	
	@Test
	void testGetSetToken() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = ""; // Can throw NullPointerException with class Password
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String tokensetter = "a";
		String tokenConstructor = "b";
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nickname, email, password, picturePath, betsInitialized, betsFollowed,
				groups, friends, tokenConstructor, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(tokenConstructor, user.getToken(), "getToken() from constructor.");
		assertDoesNotThrow(() -> user.setToken(tokensetter), "setToken() after constructor.");
		assertEquals(tokensetter, user.getToken(), "getToken() from setter.");
	}
	
	@Test
	void testGetSetTokenLastUsed() {
		// Given
		long id = 0L; // Value used by no args constructor.
		String nickname = null;
		String email = null;
		String password = ""; // Can throw NullPointerException with class Password
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> groups = null;
		Set<User> friends = null;
		String token =null;
		LocalDateTime tokenLastSetter = LocalDateTime.now();
		LocalDateTime tokenLastUsedConstructor = LocalDateTime.now().plusDays(1L);
		// When
		User user = new User(id, nickname, email, password, picturePath, betsInitialized, betsFollowed,
				groups, friends, token, tokenLastUsedConstructor); // Test constructor too.
		// Then
		assertEquals(tokenLastUsedConstructor, user.getTokenLastUsed(), "getTokenLastUsed() from constructor.");
		assertDoesNotThrow(() -> user.setTokenLastUsed(tokenLastSetter), "setTokenLastUsed() after constructor.");
		assertEquals(tokenLastSetter, user.getTokenLastUsed(), "getTokenLastUsed() from setter.");
	}
}
