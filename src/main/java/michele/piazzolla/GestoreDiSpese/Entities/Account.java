package michele.piazzolla.GestoreDiSpese.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="conti")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private int idAccount;
	
	@Column(name = "label")
	private String label;
	
	@ManyToOne
	// @EqualsAndHashCode.Exclude
	@JoinColumn(name = "id_banca", referencedColumnName = "id")
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name = "id_utente", referencedColumnName = "id")
	private User owner;
	
	@Column(name ="user_insert")
	private int idUserInsert;
	
	@Column(name ="user_modify")
	private int idUserModify;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="dt_insert")
	private Date dtInsert;
	
	@Temporal(TemporalType.DATE)
	@Column(name ="dt_modify")
	private Date dtModify;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "account")
	@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Movement> movements = new HashSet<>();
	
}
