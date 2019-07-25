/**
 * Author: Elijah Smith
 * version: Mon Jul 15, 2019
 * Issue #2
 */
import java.util.Scanner; 
   
public class ElevSim {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int elevCurrent = 1;
        int passCurrent = 1;
        char decision = 'u';
        int maxFloors = 100;
        //Elevator elev = new Elevator(maxFloors);
        //Controller control = new Controller(elev);

        while(Character.toLowerCase(decision) != 's') {
            System.out.print("Which direction would you like to go? "/* + elev.setCurrentFloor()*/);
            decision = kb.next().charAt(0);
            switch(Character.toLowerCase(decision)) {
                case 'u':
                    System.out.println("Going up...");
                    //elev.pushUp();
                    break;
                case 'd':
                    System.out.println("Going down...");
                    //elev.pushDown();
                    break;
                default:
                    decision = 's';
                    System.out.println("Exiting simulation...");
                    break;
            }
            
            /* cycle for next passenger
            passManager.next();
            control.next();
            status.display();
            */

            /*if(display.getStatus() == 's')
                decision = "s";
            */
            char decision2 = 'y';
            while(Character.toLowerCase(decision2) != 'n' && decision != 's') {
                System.out.print("Are there new passengers? ");
                decision2 = kb.next().charAt(0);
                switch(Character.toLowerCase(decision2)) {
                    case 'y':
                        //passManager.newPassenger(//whatever this entails);
                        System.out.print("New passenger added to list!\n");
                        break;
                    case 'n':
                        decision2 = 'n';
                        System.out.print("There are no new passengers, continuing simulation...\n"); 
                        break;
                    case 's':
                        decision = 's';
                        System.out.print("Exiting simulation...\n");
                        break;
                    default:
                        decision2 = 'n';
                        break;
                }
                
            }
        }
    }
}
