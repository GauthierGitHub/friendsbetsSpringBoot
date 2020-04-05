package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.models.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
