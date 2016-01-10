import java.util.Scanner;

/**
 * Turing machine that reads a series of one’s and makes a copy of those one’s to the same tape. 
 * @author Adithya Balasubramanian
 *
 */
public class Turing3 
{   
    public static void main( String args[]) 
    {
       Turing machine = new Turing(5); //number of states = 5 (excluding the Dead state)
       
       //Following are various transitional operations performed on the tape:
       Transition one = new Transition('0', Transition.RIGHT, 0);
       Transition two = new Transition('0', Transition.LEFT, 1);
       Transition three = new Transition('0', Transition.LEFT, 1);
       Transition four = new Transition('B', Transition.LEFT, 2);
       Transition five = new Transition('1', Transition.LEFT, 2);
       Transition six = new Transition('1', Transition.RIGHT, 3);
       Transition seven = new Transition('1', Transition.RIGHT, 3);
       Transition eight = new Transition('B', Transition.RIGHT, 0);
       Transition nine = new Transition('B', Transition.LEFT, 4);
       Transition ten = new Transition('1', Transition.LEFT, 4);
       Transition eleven = new Transition('B', Transition.RIGHT, 5);
       
       //Transitions applied to states of the finite state automata:
       machine.addTransition(0, '0', one);	
       machine.addTransition(0, '1', two);
       
       machine.addTransition(1, '0', three);
       machine.addTransition(1, 'B', four);
       
       machine.addTransition(2, '1', five);	
       machine.addTransition(2, 'B', six);
       machine.addTransition(3, '1', seven);	
       
       machine.addTransition(3, 'B',eight);
       machine.addTransition(0, 'B', nine);
       machine.addTransition(4, '0', ten);       
       machine.addTransition(4, 'B', eleven);    
       
      // String inTape = "111";
      // System.out.println(inTape);
       
       System.out.println("Please enter an input tape.");
       Scanner input = new Scanner(System.in);
       String inTape = input.nextLine();
       if(inTape!=null){
       String outTape = machine.execute(inTape);
       System.out.println("Output Tape:");
       System.out.println(outTape);
       }
    }
}
