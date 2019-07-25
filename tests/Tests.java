import static org.junit.Assert.*;
import org.junit.Test;

public class Tests
{
   /**
    * Author: Elijah Smith
    * 
    */
   @Test
   public void testMoveDown() {
        Elevator elevator = new Elevator(5, 4, 5);
        elevator.moveDown();
        int newCurrent = elevator.getCurrentFloor();
        assertEquals(4, newCurrent);      
   }
   
   /**
    * Author: Erik Burr
    *
    */
   @Test
   public void testMoveUp() {
        Elevator elev = new Elevator(1, 2, 5);
        elev.moveUp();
        int newCurrent = elev.getCurrentFloor();
        assertEquals(2, newCurrent);
   }
   
      /**
    * Author: Erik Burr
    *
    */
   @Test
   public void testPushUp() {
        Elevator elev = new Elevator(1, 5, 5);   
        int newCurrent = elev.getCurrentFloor();
        elev.pushUp(newCurrent);
        assertEquals(1, newCurrent);   
   }

   /**
    * Author: Erik Burr
    *
    */
   @Test
   public void testPushDown() {
        Elevator elev = new Elevator(1, 5, 5);   
        int newCurrent = elev.getCurrentFloor();
        elev.pushDown(newCurrent);
        assertEquals(1, newCurrent);  
   }  

   
   /**
    * Author: Elijah Smith
    * 
    */
   @Test
   public void testCurrentFloor() {
        int currentFloor = 60;
        int destinationFloor = 420;
        int totalFloors = 600;
        Elevator elevator = new Elevator(currentFloor, destinationFloor, totalFloors);
   }

    /**
    * Author: Elijah Smith
    */ 
    @Test
    public void testElevatorConstructor1() {
        Elevator elev = new Elevator(100);

        assertEquals(1, elev.getCurrentFloor());
        assertEquals(100, elev.getNumberOfFloors());
    }

    /**
     * Author: Elijah Smith
     */ 
    @Test
    public void testElevatorConstructor2() {
        Elevator elev = new Elevator(2, 99, 100);

        assertEquals(2, elev.getCurrentFloor());
        assertEquals(99, elev.getDestinationFloor());
        assertEquals(100, elev.getNumberOfFloors());
    }

   @Test
   public void testPushTrue1()
   {
      Elevator elev = new Elevator(1, 5, 10);

      assertEquals(false, elev.pushTrue());
   }

   @Test 
   public void testPushTrue2()
   {
      Elevator elev = new Elevator(1, 5, 10);
      elev.pushUp(4);

      assertEquals(true, elev.pushTrue());

   }

   @Test
   public void testPassengerConstructor1()
   {
      Passenger pass = new Passenger(3, 10);
 
      assertEquals(3, pass.getStartFloor());
      assertEquals(10, pass.getDestinationFloor());
   }

   @Test
   public void testPassengerConstructor2()
   {
      Passenger pass = new Passenger(50);

      assertEquals(1, pass.getStartFloor());
      assertEquals(50, pass.getDestinationFloor());
   }
}
