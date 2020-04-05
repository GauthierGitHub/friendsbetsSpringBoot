package core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import core.models.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
