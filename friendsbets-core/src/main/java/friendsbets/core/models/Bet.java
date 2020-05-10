package friendsbets.core.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @Entity
 * @author Gauthier Barbet
 *
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name="BetFbs")
public class Bet {

	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Match match;
	@ManyToOne
	@JoinColumn(nullable = false)
	private User betInitialUser;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Group group;
	@ManyToMany
	private Set<User> followers;
	// TODO bet selection WINNER DRAW SCORE
	// private int[] score = new int[2]; // tinyblob in database
	private String gain;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING) // TODO String or int ?
	private BetType betType;

	public static enum BetType {
		WINNER, DRAW, SCORE
	}

	public Bet() {
	}

	public Bet(Match match, User betInitialUser, Group group,
			Set<User> followers, String gain, BetType betType) {
		super();
		this.match = match;
		this.betInitialUser = betInitialUser;
		this.group = group;
		this.followers = followers;
		this.gain = gain;
		this.betType = betType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public User getBetInitialUser() {
		return betInitialUser;
	}

	public void setBetInitialUser(User betInitialUser) {
		this.betInitialUser = betInitialUser;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	public String getGain() {
		return gain;
	}

	public void setGain(String gain) {
		this.gain = gain;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

//	@Override JAMAIS DE TOUT TOSTRING AVEC HIBERNATE
//	public String toString() {
//		return "FriendsBetsBet [id=" + id + ", match=" + match + ", betInitialUser=" + betInitialUser + ", group="
//				+ group + ", followers=" + followers + ", gain=" + gain + ", betType=" + betType + "]";
//	}

}
