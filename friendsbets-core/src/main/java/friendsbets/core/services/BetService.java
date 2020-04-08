package friendsbets.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Bet;
import friendsbets.core.repositories.BetRepository;

@Service
public class BetService {

	@Autowired
	BetRepository br;

	public void save(Bet b) {
		br.save(b);
	}

	public void delete(Bet b) {
		br.delete(b);
	}

	public void update(Bet b) {
		br.save(b);
	}

	public List<Bet> findAll() {
		return br.findAll();
	}
}
