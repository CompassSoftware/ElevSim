/**
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Tests {
    
    /**
     * Author: ES
     */ 
    @Test
    public void testMoveDown() {
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
    public void testGetCurrentFloor() {
        int cur = 69;
        int dest = 420;
        int floors = 600;
        Elevator elevator = new Elevator(cur, dest, floors);
        int newCur = elevator.getCurrentFloor();
        assertEquals(cur, newCur);
    }
    
    /*
    * Author: Erik Burr
    * Test method for move up
    */
    
	@Test
	public void testMoveUp() {
	  Elevator elev = new Elevator(1,5,5);
		elev.moveUp();
		int newCurrent = elev.getCurrentFloor();
		assertEquals(1, newCurrent);
    }
}
