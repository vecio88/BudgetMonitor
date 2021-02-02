package michele.piazzolla.GestoreDiSpese.Services;

import java.util.List;

import michele.piazzolla.GestoreDiSpese.Entities.Movement;

public interface MovementService {
	
	public void insertMovement(Movement m);
	
	public List<Movement> selectAllMovement();
	
	public Movement selectAnMovement(int id);
	
	// public Boolean deleteMovement(Movement m);

}
