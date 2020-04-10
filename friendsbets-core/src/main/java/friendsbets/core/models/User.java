package friendsbets.core.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@PrimaryKeyJoinColumn(name="ID")
@Table(name = "UserFbs")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "jsonType")
@JsonIdentityInfo(scope = User.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User extends Friend {

	@Column(nullable = false, columnDefinition = "BINARY (60)") // Better for BCryptPasswordEncoder
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	@JsonIgnore
	@OneToMany(mappedBy = "betInitialUser", cascade = CascadeType.PERSIST)
	private Set<Bet> betsInitialized;
	@JsonIgnore
	@ManyToMany(mappedBy = "followers", fetch = FetchType.LAZY)
	private Set<Bet> betsFollowed;
	@JsonIgnore
	@ManyToMany
	private Set<Friend> friends;
	protected String token;
	protected LocalDateTime tokenLastUsed;

	public User() {
		this(0L, null, null, null, null, null, null, null, null, null, null);
	}

	public User(long id, String nickname, String email, String password) {
		this(id, nickname, email, password, null, null, null, null, null, null, null);
	}
	
	User(long id, String nickname, String email, String password, String picturePath, Set<Bet> betsInitialized,
			Set<Bet> betsFollowed, Set<Group> grpList, Set<Friend> friends, String token, LocalDateTime tokenLastUsed) {
		super(id, nickname, picturePath, grpList);
		this.email = email;
		this.password = password;
		this.betsInitialized = betsInitialized;
		this.betsFollowed = betsFollowed;
		this.friends = friends;
		this.token = token;
		this.tokenLastUsed = tokenLastUsed;
	}


	public void friendship(Friend f) {
		friends.add(f);
	}
	
	public void friendship(Set<Friend> friends) {
		this.friends.addAll(friends);
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setTokenLastUsed() {
		this.tokenLastUsed = LocalDateTime.now();
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getNickname() {
		return super.getNickname();
	}

	public String getEmail() {
		return email;
	}



	

}
