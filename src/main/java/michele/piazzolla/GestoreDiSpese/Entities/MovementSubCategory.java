package michele.piazzolla.GestoreDiSpese.Entities;

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

import lombok.Data;

@Entity
@Table(name="sottocategorie")
@Data
public class MovementSubCategory {
	
	@Id
	@Column(name = "id")
	private int idMovementSubCategory;
	
	@ManyToOne
	@JoinColumn(name = "cat_padre", referencedColumnName = "id")
	private MovementCategory MovementFatherCategory;
	
	@Column(name = "descrizione")
	private String description;
	
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
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,  
	mappedBy = "movementCategory", orphanRemoval = true)
	@JsonBackReference
	private Set<Movement> movements = new HashSet<>();

}

