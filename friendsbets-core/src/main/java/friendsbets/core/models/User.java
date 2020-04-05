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

/**
 * @Entity
 * @author Gauthier Barbet TODO see serializable id FOR save personnal config
 *         TODO CASCADE.TYPE
 */
//@Table(name="MyUser") // for change name of table
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
//@JsonSubTypes({ // for polymorphisme only ?
//@XmlRootElement for XML restApp
//    @JsonSubTypes.Type(value = FbsUser.class, name = "User"),
//    @JsonSubTypes.Type(value = Administrator.class, name = "Administrator")
//})

@Entity
// @JsonTypeInfo needed for add class name on JSON, needed for unserialiaze them on angular
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "UserFbs")
public class User {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	private long id;
	@Column(unique = true, nullable = false)
	private String nickname;
	@Column(nullable = false, columnDefinition = "BINARY (60)") // Better for BCryptPasswordEncoder
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	private String picturePath;
	// TODO: remove me !
	@JsonIgnore
	@OneToMany(mappedBy = "betInitialUser", cascade = CascadeType.PERSIST) // TODO cascadeType ?
	private Set<Bet> betsInitialized;
	@JsonIgnore
	@ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
	private Set<Bet> betsFollowed;
	@JsonIgnore
	@ManyToMany(mappedBy = "userList", fetch = FetchType.EAGER)
	private Set<Group> grpList;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<User> friends;
	protected String token;
	protected LocalDateTime tokenLastUsed;

	public User() {
		// this() == super()
		this(0L, null, null, null, null, null, null, null, null, null, null);
	}

	public User(String nickname, String email, String password) {
		this(-1, nickname, email, password, null, null, null, null, null, null, null);
	}

	public User(long id, String nickname, String email, String password) {
		this(id, nickname, email, password, null, null, null, null, null, null, null);
	}

	/**
	 * "Package private"scope : public inside package, private outside. Default package.
	 * TODO: Initialize collections ?
	 * scope.
	 */
	User(long id, String nickname, String email, String password, String picturePath, Set<Bet> betsInitialized,
			Set<Bet> betsFollowed, Set<Group> grpList, Set<User> friends, String token, LocalDateTime tokenLastUsed) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.picturePath = picturePath;
		this.betsInitialized = betsInitialized;
		this.betsFollowed = betsFollowed;
		this.grpList = grpList;
		this.friends = friends;
		this.token = token;
		this.tokenLastUsed = tokenLastUsed;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Group> getGrpList() {
		return grpList;
	}

	public void setGrpList(Set<Group> grpList) {
		this.grpList = grpList;
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

	@Override
	public String toString() {
		return "FriendsBetsUser [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email;
	}

}
