package michele.piazzolla.GestoreDiSpese.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import michele.piazzolla.GestoreDiSpese.Utility;
import michele.piazzolla.GestoreDiSpese.Entities.Movement;

@Component
public class MovementDTOConverter {
	
	
	public MovementDTO entityToDto (Movement movement) {
		
		MovementDTO dto = new MovementDTO();
		
		dto.setDatetimeMovement(movement.getDatetimeMovement().toLocalDate().toString());
		dto.setMovementAmount(movement.getMovementAmount());
		dto.setCausal(movement.getCausal());
		dto.setAccount(movement.getAccount());
		dto.setMovementCategory(movement.getMovementSubCategory());
		dto.setTypeOfMovement(movement.getTypeOfMovement());
		
		return dto;
		
	}
	
	
	public List<MovementDTO> entityToDto(List<Movement> movimenti) {
		
		
		return  movimenti
				.stream()
				.map(x -> entityToDto(x))
				.collect(Collectors.toList());
	}
	
	
	public Movement dtoToEntity(MovementDTO movimentoDTO) {
		
		Movement movement = new Movement();

		movement.setAccount(movimentoDTO.getAccount());
		movement.setMovementSubCategory(movimentoDTO.getMovementCategory());
		movement.setCausal(movimentoDTO.getCausal());
		movement.setDateMovement(Utility.stringToLocalDateTime(movimentoDTO.getDatetimeMovement()).toLocalDate());
		movement.setTypeOfMovement(movimentoDTO.getTypeOfMovement());
		movement.setDtInsert(LocalDateTime.now());
		movement.setDtModify(LocalDateTime.now());
		movement.setIdUserInsert(movimentoDTO.getIdUser());
		movement.setIdUserModify(movimentoDTO.getIdUser());
		movement.setDatetimeMovement(Utility.stringToLocalDateTime(movimentoDTO.getDatetimeMovement()));
		movement.setMovementAmount(movimentoDTO.getMovementAmount());


		return movement;
	}
	
	public List<Movement> dtoToEntity(List<MovementDTO> dto) {
		
		return dto.
				stream()
				.map(x -> dtoToEntity(x))
				.collect(Collectors.toList());
	}

}
