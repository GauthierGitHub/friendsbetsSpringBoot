package friendsbets.core.models;

import java.time.LocalDateTime;

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

@Entity
@JsonIdentityInfo(scope = Message.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "MessageFbs")
public class Message {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User author;
	@ManyToOne
	@JoinColumn(nullable = false)
	@JsonIdentityReference(alwaysAsId = true) // only id in JSON
	private Group group;
	private LocalDateTime date;
	@Column(nullable = false)
	private String content;

	public Message() {
	}

	public Message(User user, Group group, LocalDateTime date, String content) {
		this.author = user;
		this.group = group;
		this.date = date;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User user) {
		this.author = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
