import static org.junit.Assert.*;
import org.junit.Test;

//brought in from TimerTest.java
interface TimerClient {
   public void timerCallback();
}

public class Tests implements TimerClient
{
   /**
    * Author: Elijah Smith
    * 
    */
   @Test
   public void testMoveDown() {
        Elevator elevator = new Elevator(5, 5);
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
        Elevator elev = new Elevator(1, 5);
        elev.moveUp();
        int newCurrent = elev.getCurrentFloor();
        assertEquals(2, newCurrent);
   }
   
  
    //simple values needed for Timer
    double numSeconds = 4.5;
    double pollDelay = 0.25;
    int numPolls = 0; 
    int numExpectedPolls = (int)(numSeconds / pollDelay) - 1; // last poll will work!
    boolean timerExpired = false;
    boolean state = false;
    //method needed for TimerClient
    public void timerCallback() {
          timerExpired = true;
   }   
    
    /**
     * Author: Elijah Smith
     */ 
    public void runPollTest() {
            pollDelay *= 1000;
            System.out.println("Testing using poll method:");
            System.out.println("\tTest will sleep for " 
                        + pollDelay + "ms then poll timer to see if expired.");
            System.out.println("\tEach poll will print a dot.");

            System.out.println("\tCreating " + numSeconds + " second timer...");        
            Timer t = new Timer((int)(numSeconds*1000));

            System.out.println("\tStarting timer...");
            System.out.print("\t");
            t.start();

            while(true)
            {
                try
                {
                    Thread.sleep((int)pollDelay);
                    
                }
                catch(Exception e)
                {
                }

                if(!t.expired())
                {
                    numPolls++;
                    System.out.print(".");
                }
                else
                {
                    break;
                }
            }
            System.out.println();
            System.out.println("\tNumber of polls was " + numPolls);    
            System.out.println("\tNumber of expected polls was " + numExpectedPolls);   
            if (numExpectedPolls == numPolls) {
                System.out.println("Poll Test PASSED!");
                assertEquals(numExpectedPolls, numPolls);
            }
            else if (numExpectedPolls-1 <= numPolls && numPolls <= numExpectedPolls+1) { 
                System.out.println("Poll Test PASSED! (small timing variance between threads is allowed)");
                state = true; 
                assertTrue(state);
            }
            else {   
                System.out.println("Poll Test FAILED!");
                assertTrue(state);
            }
        }
   
   /**
    * Author: Elijah Smith
    * test for getElevators() method
    */ 
   @Test
   public void testGetElevators() {
        Controller control = new DefaultController(10, 2);
        Elevator[] elevArray = control.getElevators();
        Elevator elev1 = elevArray[0]; 
        Elevator elev2 = elevArray[1];
        
        assertEquals(elev1, elev2);
   }
   
   
   /**
    * Author: Elijah Smith
    * pushUp() method test now in Controller
    */ 
    @Test
    public void testPushUp() {
        Controller control = new DefaultController(10, 2);
        control.pushUp(0);
        control.pushUp(2);
        control.pushUp(3);

        boolean[] pushedUpArray = control.getPushedUpArray();
        boolean pushedUp1 = pushedUpArray[0];
        boolean pushedUp2 = pushedUpArray[2];
        boolean pushedUp3 = pushedUpArray[3];

        assertEquals(true, pushedUp1);
        assertEquals(true, pushedUp2);
        assertEquals(true, pushedUp3);
    }

   /**
    * Author: Elijah Smith
    * pushDown() method test now in Controller
    */ 
    @Test
    public void testPushDown() {
        Controller control = new DefaultController(10, 2);
        control.pushDown(5);
        control.pushDown(7);
        control.pushDown(3);

        boolean[] pushedUpArray = control.getPushedUpArray();
        boolean pushedDown1 = pushedUpArray[5];
        boolean pushedDown2 = pushedUpArray[7];
        boolean pushedDown3 = pushedUpArray[3];

        assertEquals(true, pushedDown1);
        assertEquals(true, pushedDown2);
        assertEquals(true, pushedDown3);
    }
    
   /**
    * Author: Elijah Smith
    * 
    */
   @Test
   public void testCurrentFloor() {
        int currentFloor = 60;
        int totalFloors = 600;
        Elevator elevator = new Elevator(currentFloor, totalFloors);

        assertEquals(60, elevator.getCurrentFloor());
   }

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
        Elevator elev = new Elevator(2, 100);

        assertEquals(2, elev.getCurrentFloor());
        assertEquals(100, elev.getNumberOfFloors());

    }


/**
 * Author: Elijah Smith
 * New test for next() within Passenger
 */ 
 @Test
   public void testPassengerNext1()
   {
      Controller control = new DefaultController(10, 2); 
      
      Passenger pass = new Passenger(control, 7, 10);
      Passenger pass2 = new Passenger(control, 2, 1);   

      pass.next();
      pass.next();

      assertEquals(2, control.pushTrue());      
   } 

   @Test
   public void testHasDestFloor()
   {
      Elevator elev = new Elevator(1, 10);
      
      assertEquals(0, elev.hasDestFloors());
      
      elev.addDestinationFloor(7);
      
      assertEquals(1, elev.hasDestFloors());  
   }

   @Test
     public void testpushTrue()
   {
      Elevator[] elevators = new Elevator[2];
      DefaultController control = new DefaultController(10, 0);
      assertEquals(0, control.pushTrue());   
   }


   @Test
   public void testpushTrue1()
   {
      Controller control = new DefaultController(10,3);  
      control.pushUp(1);
      control.pushUp(3);
      control.pushDown(8);
      
      int count = control.pushTrue();
     
      assertEquals(3, count);   
   }
  
}
