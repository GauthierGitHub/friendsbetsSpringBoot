package friendsbets.core.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import friendsbets.core.models.Friend;
import friendsbets.core.models.User;

public interface FriendRepository extends JpaRepository<Friend, Long>  {

	Friend findByNickname(String nickname);
	
	@Query("from User u where u.nickname like %?1% or u.email like %?1%")
	Set<Friend> findByNicknameOrEmailLike(String pattern);

	@Query(value="SELECT * FROM UserFbs "
				+ "WHERE id != ?1 AND id NOT IN ("
						+ "SELECT friends_id "
						+ "FROM UserFbs_friends "
						+ "WHERE UserFbs_friends.User_id = ?1)"
			, nativeQuery = true)
	Set<Friend> findAllOthers(long id); // or User u ?

	@Query(value=
			"SELECT * FROM UserFbs "
			+ "RIGHT JOIN UserFbs_friends ON UserFbs.id = UserFbs_friends.friends_id "
			+ "WHERE UserFbs_friends.User_id = ?1" // ?1.get(id) OR ?1.id ??????
			, nativeQuery = true)
	Set<Friend> findFriends(long id);


	@Modifying
	@Transactional
	@Query(value=
			"INSERT INTO UserFbs_friends(User_id, friends_id) "
			+ "VALUES (?1, ?2)",
			nativeQuery = true)
	void addFriends(long id, User friend);


}
