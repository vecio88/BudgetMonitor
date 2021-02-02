package michele.piazzolla.GestoreDiSpese.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import michele.piazzolla.GestoreDiSpese.Entities.Movement;

public interface MovementRepository extends JpaRepository<Movement, Integer> {
	
	public List<Movement> findAll();
	
	public Movement findByIdMovement(int id);
	
	// public Boolean deleteMovement(Movement m);

}
