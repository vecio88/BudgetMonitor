package michele.piazzolla.GestoreDiSpese;

import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import michele.piazzolla.GestoreDiSpese.Entities.Movement;
import michele.piazzolla.GestoreDiSpese.Repositories.MovementRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MovementTest {
	
	@Autowired
	private MovementRepository movementRepo;

	@Test
	public void A_TestSelByIdMovement() {
		
		Movement movement = movementRepo.findByIdMovement(1);
		assertNotNull(movement);
		
	}

}
