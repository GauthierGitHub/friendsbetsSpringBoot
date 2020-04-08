package friendsbets.core.models;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "GroupFbs_id")
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany
	private Set<Friend> friends;
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private Set<Bet> betsList;
	@JsonIgnore
	@OneToMany(mappedBy = "group")
	private List<Message> groupMessages;
	private String picturePath;

	public Group() {
		this(0L, null, null, null, null, null);
	}

	public Group(long id, String name, Set<Friend> friends, Set<Bet> betList, List<Message> groupMessages,
			String picturePath) {
		super();
		this.id = id;
		this.name = name;
		this.friends = friends;
		this.betsList = betList;
		this.groupMessages = groupMessages;
		this.picturePath = picturePath;
		if(friends != null) notifyFriends();
	}

	public void notifyFriends() {
		friends.forEach(f -> f.enterInGroup(this));
	}

	public void addFriend(Friend f) {
		friends.add(f);
		notifyFriends();
	}

	public void addFriends(Collection<Friend> friends) {
		this.friends.addAll(friends);
		notifyFriends();
	}


}
