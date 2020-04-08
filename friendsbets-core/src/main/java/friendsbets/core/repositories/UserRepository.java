package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.models.Friend;
import friendsbets.core.models.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	User findByNickname(String nickname);


}
