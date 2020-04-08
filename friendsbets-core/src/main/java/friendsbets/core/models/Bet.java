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
	private Friend betInitialUser;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Group group;
	@ManyToMany
	private Set<Friend> followers;
	private String gain;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private BetType betType;

	public enum BetType {
		WINNER, DRAW, SCORE
	}

	public Bet() {
	}
}
