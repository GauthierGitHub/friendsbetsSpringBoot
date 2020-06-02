package friendsbets.core.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "UserFbs")
public class User {

	@Id
	@GeneratedValue
	private long id;
	@Column(unique = true, nullable = false)
	private String nickname;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false, columnDefinition = "BINARY (60)") // Better for BCryptPasswordEncoder
	private String password; // TODO: Password Object ?
	private String picturePath;
	@JsonIgnore
	@OneToMany(mappedBy = "betInitialUser", cascade = CascadeType.PERSIST)
	private Set<Bet> betsInitialized;
	@JsonIgnore
	@ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
	private Set<Bet> betsFollowed;
	@JsonIgnore
	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private Set<Group> groups;
	@JsonIgnore
	@ManyToMany
	private Set<User> friends;
	protected String token;
	protected LocalDateTime tokenLastUsed;

	public User() {
		this(0L, null, null, null, null, null, null, null, null, null, null);
	}
	
	public User(long id) {
		this(id, null, null, null, null, null, null, null, null, null, null);
	}
	
	public User(String nickname, String email, String password) {
		this(0L, nickname, email, password, null, null, null, null, null, null, null);
	}

	public User(long id, String nickname, String email, String password) {
		this(id, nickname, email, password, null, null, null, null, null, null, null);
	}

	User(long id, String nickname, String email, String password, String picturePath, Set<Bet> betsInitialized,
			Set<Bet> betsFollowed, Set<Group> groups, Set<User> friends, String token, LocalDateTime tokenLastUsed) {
		this.id = id;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.picturePath = picturePath;
		this.betsInitialized = betsInitialized;
		this.betsFollowed = betsFollowed;
		this.groups = groups;
		this.friends = friends;
		this.token = token;
		this.tokenLastUsed = tokenLastUsed;
	}
	
	public Friend toFriend() {
		return new Friend(this.id, this.nickname, this.picturePath);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Set<Bet> getBetsInitialized() {
		return betsInitialized;
	}

	public void setBetsInitialized(Set<Bet> betsInitialized) {
		this.betsInitialized = betsInitialized;
	}

	public Set<Bet> getBetsFollowed() {
		return betsFollowed;
	}

	public void setBetsFollowed(Set<Bet> betsFollowed) {
		this.betsFollowed = betsFollowed;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getTokenLastUsed() {
		return tokenLastUsed;
	}

	public void setTokenLastUsed(LocalDateTime tokenLastUsed) {
		this.tokenLastUsed = tokenLastUsed;
	}

}
