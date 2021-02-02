package michele.piazzolla.GestoreDiSpese.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@Table(name="banche")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bank implements Serializable{

	private static final long serialVersionUID = 2781965446983906005L;

	@Id
	@Column(name = "id")
	private int idBank;
	
	@Column(name = "nome_banca")
	private String bankName;
	
	@Column(name = "bic_code")
	private String bicCode;
	
	@Column(name ="user_insert")
	private int idUserInsert;
	
	@Column(name ="user_modify")
	private int idUserModify;
	
	@Column(name ="dt_insert")
	private LocalDateTime dtInsert;
	
	@Column(name ="dt_modify")
	private LocalDateTime dtModify;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Account> accounts = new HashSet<>();
	
}
