package friendsbets.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import friendsbets.core.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {


	@Query(value="SELECT * FROM MessageFbs "
				+ "WHERE group_id = ?1 "
				+ "ORDER BY date DESC "
				+ "LIMIT ?2, 20;"
			, nativeQuery = true)
//	@Query("from Message m where m.group = ?1")
	List<Message> findTwenty(String id, int offset);

}
