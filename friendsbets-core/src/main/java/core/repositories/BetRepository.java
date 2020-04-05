package core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import core.models.Bet;

public interface BetRepository extends JpaRepository<Bet, Long>{

}
