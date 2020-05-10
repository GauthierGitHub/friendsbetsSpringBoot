package friendsbets.core.models;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "GroupFbs")
public class Group {
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = true)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> users = new LinkedHashSet<>(); // first user will be administrator.
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private Set<Bet> bets = new TreeSet<>();
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Message> messages;
	private String picturePath;

	public Group() {
		this(0L, null, null, null, null, null);
	}

	Group(long id, String name, Set<User> users, Set<Bet> bets, List<Message> messages, String picturePath) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.bets = bets;
		this.messages = messages;
		this.picturePath = picturePath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Bet> getBets() {
		return bets;
	}

	public void setBets(Set<Bet> bets) {
		this.bets = bets;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
