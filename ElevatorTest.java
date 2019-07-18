/**
 *
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class  ElevatorTest {
    /**
     * Author :
     */ 
    @Test
    public void testEvaluate() {
        Elevator elevator = new Elevator(5, 1, 5);
        elevator.moveDown();
        int newCurrent = elevator.getCurrentFloor();
        assertEquals(1, newCurrent);
    }
 
    @Test
    public void testEvaluate2() {
        int cur = 69;
        int dest = 420;
        int floors = 600;
        Elevator elevator = new Elevator(cur, dest, floors);
        int newCur = elevator.getCurrentFloor();
        assertEquals(69, newCur);
    }
}
