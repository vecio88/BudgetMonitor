package michele.piazzolla.GestoreDiSpese.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;




@Entity
@Table(name="movimenti")
public class Movement implements Serializable {

	private static final long serialVersionUID = 471147169210679830L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty(access = Access.READ_ONLY)
	private int idMovement;
	
	// @Temporal(TemporalType.DATE)
	@Column(name = "date_movimento")
	private LocalDate dateMovement;
	
	// @Temporal(TemporalType.DATE)
	@Column(name = "datetime_movimento")
	private LocalDateTime datetimeMovement;
	
	@ManyToOne
	@JoinColumn(name = "id_conto", referencedColumnName = "id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "id_sottocategoria", referencedColumnName = "id")
	private MovementSubCategory movementSubCategory;
	
	@Column(name ="causale")
	private String causal;
	
	// E = expense (spese) I = Income (entrate)
	@Column(name ="tipologia")
	private String typeOfMovement;
	
	@Column(name ="ammontare")
	private Double movementAmount;
	
	@Column(name ="note")
	private String note;
	
	@Column(name ="user_insert")
	private int idUserInsert;
	
	@Column(name ="user_modify")
	private int idUserModify;
	
	@Column(name ="dt_insert")
	private LocalDateTime dtInsert;

	@Column(name ="dt_modify")
	private LocalDateTime dtModify;

	public int getIdMovement() {
		return idMovement;
	}

	public void setIdMovement(int idMovement) {
		this.idMovement = idMovement;
	}

	public LocalDate getDateMovement() {
		return dateMovement;
	}

	public void setDateMovement(LocalDate dateMovement) {
		this.dateMovement = dateMovement;
	}

	public LocalDateTime getDatetimeMovement() {
		return datetimeMovement;
	}

	public void setDatetimeMovement(LocalDateTime datetimeMovement) {
		this.datetimeMovement = datetimeMovement;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public MovementSubCategory getMovementSubCategory() {
		return movementSubCategory;
	}

	public void setMovementSubCategory(MovementSubCategory movementSubCategory) {
		this.movementSubCategory = movementSubCategory;
	}

	public String getCausal() {
		return causal;
	}

	public void setCausal(String causal) {
		this.causal = causal;
	}

	public String getTypeOfMovement() {
		return typeOfMovement;
	}

	public void setTypeOfMovement(String typeOfMovement) {
		this.typeOfMovement = typeOfMovement;
	}

	public Double getMovementAmount() {
		return movementAmount;
	}

	public void setMovementAmount(Double movementAmount) {
		this.movementAmount = movementAmount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getIdUserInsert() {
		return idUserInsert;
	}

	public void setIdUserInsert(int idUserInsert) {
		this.idUserInsert = idUserInsert;
	}

	public int getIdUserModify() {
		return idUserModify;
	}

	public void setIdUserModify(int idUserModify) {
		this.idUserModify = idUserModify;
	}

	public LocalDateTime getDtInsert() {
		return dtInsert;
	}

	public void setDtInsert(LocalDateTime dtInsert) {
		this.dtInsert = dtInsert;
	}

	public LocalDateTime getDtModify() {
		return dtModify;
	}

	public void setDtModify(LocalDateTime dtModify) {
		this.dtModify = dtModify;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
