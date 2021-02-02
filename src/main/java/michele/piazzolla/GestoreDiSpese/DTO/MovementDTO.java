package michele.piazzolla.GestoreDiSpese.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;
import michele.piazzolla.GestoreDiSpese.Entities.Account;
import michele.piazzolla.GestoreDiSpese.Entities.MovementCategory;
import michele.piazzolla.GestoreDiSpese.Entities.MovementSubCategory;

@Data
public class MovementDTO {

	@NotNull(message = "{NotNull.MovementDTO.datetimeMovement.Validation}")
	@Pattern(regexp="^[0-3][0-9]/([0][0-9]|[1][0-2])/[0-9]{4} ([01][0-9]|2[0-4]):([0-5][0-9]):([0-5][0-9])$", 
		message = "{Pattern.MovementDTO.datetimeMovement.Validation}")
	private String datetimeMovement;
	
	@NotNull(message = "{NotNull.MovementDTO.account.Validation}")
	private Account account;
	
	@NotNull(message = "{NotNull.MovementDTO.movementCategory.Validation}")
	private MovementSubCategory movementCategory;
	
	@Size(min = 0, max = 1000, message = "{Size.MovementDTO.causal.Validation}")
	private String causal;
	
	@NotNull(message = "{NotNull.MovementDTO.typeOfMovement.Validation}")
	@Pattern(regexp="^[E,I]{1}$", message = "{Pattern.MovementDTO.typeOfMovement.Validation}")
	private String typeOfMovement;
	
	@NotNull(message = "{NotNull.MovementDTO.movementAmount.Validation}")
	@PositiveOrZero(message = "{PositiveOrZero.MovementDTO.movementAmount.Validation}")
	private Double movementAmount;
	
	@NotNull(message = "{NotNull.MovementDTO.idUser.Validation}")
	private int idUser;
	
}
