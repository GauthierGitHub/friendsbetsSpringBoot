package friendsbets.core.models;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import friendsbets.core.customserializers.CustomUserDeserializer;


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
	@JsonProperty(access = Access.READ_ONLY)
	@JsonIdentityReference(alwaysAsId=true) 
    @JsonDeserialize(using = CustomUserDeserializer.class)
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> users;
	@Transient
	private Set<Friend> friends;
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private Set<Bet> bets;
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Message> messages;
	private String picturePath;

	public Group() {
		this(0L, null, null, null, null, null);
	}

	public Group(long id) {
		this(id, null, null, null, null, null);
	}
	
	Group(long id, String name, Set<User> users, Set<Bet> bets, List<Message> messages, String picturePath) {
		super();
		this.id = id;
		this.name = name;
		this.users = users == null ?  new LinkedHashSet<>() : users; // first user will be administrator.
		this.friends = users == null ?  new LinkedHashSet<>() : users.stream().map(User::toFriend).collect(Collectors.toSet());
		this.bets = bets == null ?  new TreeSet<>() : bets;
		this.messages = messages == null ? new ArrayList<>() : messages;
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

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
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

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + "]";
	}

}
