/**
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ElevatorTest {
    
    /**
     * Author: ES
     */ 
    @Test
    public void testEvaluate() {
        Elevator elevator = new Elevator(5, 1, 5);
        elevator.moveDown();
        int newCurrent = elevator.getCurrentFloor();
        assertEquals(1, newCurrent);
    }
    
    /**
     * Author: Elijah Smith
     *
     */ 
    @Test
    public void testEvaluate2() {
        int cur = 69;
        int dest = 420;
        int floors = 600;
        Elevator elevator = new Elevator(cur, dest, floors);
        int newCur = elevator.getCurrentFloor();
        assertEquals(69, newCur);
    }
    
    /*
    * Author: Erik Burr
    * Test method for move up
    */
    
	@Test
	public void testEvaluate3() {
	  Elevator elev = new Elevator(1,5,5);
		elev.moveUp();
		int newCurrent = elev.getCurrentFloor();
		assertEquals(1, newCurrent);	}
}
