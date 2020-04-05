package friendsbets.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import friendsbets.core.models.Message;
import friendsbets.core.repositories.MessageRepository;

/**
 * TODO Exceptions
 * 
 * All methods what return Messages or update Messages database
 * 
 * @author gauthier
 *
 */
@Service
public class MessageService {

	@Autowired
	MessageRepository mr;

	public void save(Message m) {
		mr.save(m);
	}

	public void delete(Message m) {
		mr.delete(m);
	}

	public void update(Message m) {
		mr.delete(m);
	}

	public List<Message> findAll() {
		return mr.findAll();
	}

	public List<Message> findTwenty(String id, int offset) {
		return mr.findTwenty(id, offset);
	}
}
