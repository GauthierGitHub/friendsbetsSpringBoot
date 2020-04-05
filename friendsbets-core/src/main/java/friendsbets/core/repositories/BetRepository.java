package friendsbets.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import friendsbets.core.models.Bet;

public interface BetRepository extends JpaRepository<Bet, Long>{

}
