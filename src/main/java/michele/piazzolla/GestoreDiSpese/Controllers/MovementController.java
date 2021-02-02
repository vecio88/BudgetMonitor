package michele.piazzolla.GestoreDiSpese.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import michele.piazzolla.GestoreDiSpese.DTO.MovementDTO;
import michele.piazzolla.GestoreDiSpese.DTO.MovementDTOConverter;
import michele.piazzolla.GestoreDiSpese.Entities.Movement;
import michele.piazzolla.GestoreDiSpese.Services.MovementService;

@RestController
@RequestMapping("/api/movement")
public class MovementController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovementController.class);
	
	@Autowired
	MovementDTOConverter dtoConverter;
	
	@Autowired
	MovementService movementService;
	
	@Autowired
	private ResourceBundleMessageSource errMessage;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> insertMovement(@Valid @RequestBody MovementDTO m, BindingResult bindingResult) throws Exception {
		
		logger.info("Inserimento di un nuovo movimento");
		
		String response = "OK";
		
		if (bindingResult.hasErrors()) {
			String MsgErr = errMessage.getMessage(bindingResult.getFieldError(), LocaleContextHolder.getLocale());
			logger.warn("Errore nella validazione in fase di inserimento: " + errMessage);
			throw new Exception(MsgErr);
		} else {
			
			Movement newMovement = dtoConverter.dtoToEntity(m);
			
			try {
				movementService.insertMovement(newMovement);
			} catch (Exception e) {
				response = "KO: " + e;
			}
			
		}
		
		return new ResponseEntity<String>(response, HttpStatus.OK);
		
	}
	
	// public Movement modifyMovimento(Movement m) {return null;}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MovementDTO>> selectAllMovement() {
	
		List<Movement> movementList = movementService.selectAllMovement();
		
		List<MovementDTO> movDTOList = dtoConverter.entityToDto(movementList);
		
		return new ResponseEntity<List<MovementDTO>>(movDTOList, HttpStatus.OK);
	
	}
	
	// public Movement selectAnMovement() {return null;}
	
	// public Boolean deleteMovement() {return true;}

}
