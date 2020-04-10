package friendsbets.core.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "FriendFbs")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
@JsonIdentityInfo(scope = Friend.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonSubTypes(@JsonSubTypes.Type(value = User.class, name = "User"))
public class Friend {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true, nullable = false)
	private String nickname;
	private String picturePath;
	@JsonIgnore
	@ManyToMany(mappedBy = "friends", fetch = FetchType.EAGER)
	private Set<Group> groups;

	public Friend() {
		this(0L, null, null, null);
	}

	public Friend(long id, String nickname) {
		this(id, nickname, null, null);
	}
	
	Friend(long id, String nickname, String picturePath, Set<Group> groups) {
		this.id = id;
		this.nickname = nickname;
		this.picturePath = picturePath;
		this.groups = groups;
	}


	public void enterInGroup(Group g) {
		groups.add(g);
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	protected String getNickname() {
		return nickname;
	}
	

}
