import java.util.Scanner;

/**
 * Program that simulates a tuning machine that produces proper subtraction
 * Proper subtraction m – n is defined to be m – n for m >= n, and zero for m <
 * n. The TM
 * 
 * M = ( {q0,q1,...,q6}, {0,1}, {0,1,B}, delta, q0, B, {} ) defined below, if
 * started with 0m10n on its tape, halts with 0m-n on its tape. M repeatedly
 * replaces its leading 0 by blank, then searches right for a 1 followed by a 0
 * and changes the 0 to a 1. Next, M moves left until it encounters a blank and
 * then repeats the cycle.
 * 
 * @author Adithya Balasubramanian
 *
 */
public class Turing2 {
	public static void main(String args[]) {
	
		//Following are various transitional operations performed on the tape:
		Turing machine = new Turing(6); //number of states = 5 (excluding the Dead state)
		
		// Begin. Replace the leading 0 by B
		Transition one = new Transition('B', Transition.RIGHT, 1);

		// Search right looking for the first 1.
		Transition two = new Transition('0', Transition.RIGHT, 1);
		Transition three = new Transition('1', Transition.RIGHT, 2);

		// Search right past 1’s until encountering a 0. Change that 0 to 1.
		Transition four = new Transition('1', Transition.RIGHT, 2);
		Transition five = new Transition('1', Transition.LEFT, 3);

		// Move left to a blank. Enter state q0 to repeat the cycle.
		Transition six = new Transition('0', Transition.LEFT, 3);
		Transition seven = new Transition('1', Transition.LEFT, 3);
		Transition eight = new Transition('B', Transition.RIGHT, 0);

		// If in state q2 a B is encountered before a 0, we have situation i
		// described above. Enter state q4 and move left, changing all 1’s
		// to B’s until encountering a B. This B is changed back to a 0,
		// state q6 is entered and M halts.

		Transition nine = new Transition('B', Transition.LEFT, 4);
		Transition ten = new Transition('B', Transition.LEFT, 4);
		Transition eleven = new Transition('0', Transition.LEFT, 4);
		Transition twelve = new Transition('0', Transition.RIGHT, 6);

		// If in state q0 a 1 is encountered instead of a 0, the first block
		// of 0’s has been exhausted, as in situation (ii) above. M enters
		// state q5 to erase the rest of the tape, then enters q6 and halts.

		Transition thirteen = new Transition('B', Transition.RIGHT, 5);
		Transition fourteen = new Transition('B', Transition.RIGHT, 5);
		Transition fifteen = new Transition('B', Transition.RIGHT, 5);
		Transition sixteen = new Transition('B', Transition.RIGHT, 6);

		//Transitions applied to states of the finite state automata:
		machine.addTransition(0, '0', one);
		machine.addTransition(0, '1', thirteen);
		machine.addTransition(1, '0', two);
		machine.addTransition(1, '1', three);

		machine.addTransition(2, 'B', nine);
		machine.addTransition(2, '1', four);
		machine.addTransition(2, '0', five);

		machine.addTransition(3, '0', six);
		machine.addTransition(3, '1', seven);
		machine.addTransition(3, 'B', eight);

		machine.addTransition(4, '1', ten);
		machine.addTransition(4, '0', eleven);
		machine.addTransition(4, 'B', twelve);

		machine.addTransition(5, '0', fourteen);
		machine.addTransition(5, '1', fifteen);
		machine.addTransition(5, 'B', sixteen);

		//String inTape = "00000001000";
		//System.out.println(inTape);
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
