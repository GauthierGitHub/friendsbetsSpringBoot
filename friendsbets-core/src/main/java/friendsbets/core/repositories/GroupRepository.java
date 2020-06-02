package friendsbets.core.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import friendsbets.core.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

	@Query(value =
			"SELECT * FROM GroupFbs "
			+ "INNER JOIN GroupFbs_users ON GroupFbs.id = GroupFbs_users.groups_id "
			+ "WHERE users_id = ?1"
			, nativeQuery = true)
	Set<Group> findAllForOneUser(long id);



}
