package michele.piazzolla.GestoreDiSpese.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import michele.piazzolla.GestoreDiSpese.Entities.Movement;
import michele.piazzolla.GestoreDiSpese.Repositories.MovementRepository;

@Service
public class MovementServiceImpl implements MovementService {
	
	@Autowired
	MovementRepository movementRepo;

	@Override
	public void insertMovement(Movement m) {
		movementRepo.save(m);
		
	}

	@Override
	public List<Movement> selectAllMovement() {
		return movementRepo.findAll();
	}

	@Override
	public Movement selectAnMovement(int id) {
		// passare l'ID
		return movementRepo.findByIdMovement(id);
	}

	// @Override
	/* public Boolean deleteMovement(Movement m) {
		try {
			movementRepo.delete(m);
			return true;
		} catch (Exception e) {
			System.out.println("Movement Delete in Error: " + e);
			return false;
		}
		
	} */

}
