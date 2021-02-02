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
@Table(name="utenti")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable {
	
	private static final long serialVersionUID = 3356785768854212238L;

	@Id
	@Column(name = "id")
	private int idUser;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "psw")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "cognome")
	private String surname;
	
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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
	@JsonBackReference
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Account> accounts = new HashSet<>();

	
}
