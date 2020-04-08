package friendsbets.core.models;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import friendsbets.core.models.Bet;
import friendsbets.core.models.Group;
import friendsbets.core.models.User;

@SpringBootTest
class UserTest {

	User u;

	@Test
	void testGetSetId() {
		// Given
		long idConstructor = 1L;
		long idSetter = Long.MAX_VALUE;
		String nickname = null;
		String password = ""; // Can throw NullPointerException with class Password
		String email = null;
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> grpList = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(idConstructor, nickname, password, email, picturePath, betsInitialized, betsFollowed,
				grpList, friends, token, tokenLastUsed); // Test constructor too.
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
		String nicknameSetter= "a";
		String password = "";
		String email = null;
		String picturePath = null;
		Set<Bet> betsInitialized = null;
		Set<Bet> betsFollowed = null;
		Set<Group> grpList = null;
		Set<User> friends = null;
		String token = null;
		LocalDateTime tokenLastUsed = null;
		// When
		User user = new User(id, nicknameConstructor, password, email, picturePath, betsInitialized, betsFollowed,
				grpList, friends, token, tokenLastUsed); // Test constructor too.
		// Then
		assertEquals(nicknameConstructor, user.getNickname(), "getNickname() from constructor.");
		assertDoesNotThrow(() -> user.setNickname(nicknameSetter), "setNickname() after constructor.");
		assertEquals(nicknameSetter, user.getNickname(), "getNickname() from setter.");
	}
}
