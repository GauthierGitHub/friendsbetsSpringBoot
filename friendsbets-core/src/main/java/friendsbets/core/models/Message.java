package friendsbets.core.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
// id generator for repeated objects
@JsonIdentityInfo(scope = Message.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "MessageFbs")
public class Message {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Friend author;
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIdentityReference(alwaysAsId = true) // only id in json
	private Group group;
	@Temporal(TemporalType.TIMESTAMP) // Provided by client side
	private Date date;
	@Column(nullable = false)
	private String content;

	public Message() {
	}

}
