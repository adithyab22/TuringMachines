import java.util.Arrays;
import java.util.Scanner;

/**
 * Program that simulates a finite state machine such that, for a given machine
 * description and input, determines if the input is accepted by the machine.
 * 
 * @author Adithya Balasubramanian
 *
 */
public class DFSASimulator {
	private boolean[] finalStates;
	private char[][] delta;
	private int startState;
	private int currentState;
	private int totalStates;

	/**
	 * Initialize the total states, start state and a state transition matrix
	 * 
	 * @param n
	 *            total number of states
	 * @param start
	 *            start state of the machine
	 */
	public DFSASimulator(int n, int start) {
		totalStates = n;
		finalStates = new boolean[totalStates];
		delta = new char[totalStates][totalStates];
		startState = start;
	}

	/**
	 * checks if the current state is the final state
	 * 
	 * @return true if the current state is final
	 */
	private boolean isFinal() {
		return finalStates[currentState];
	}

	/**
	 * defines transition from a state to another on encountering an input character.
	 * 
	 * @param fromState
	 *            the state from which the input transitions from
	 * @param toState
	 *            the end state of transition
	 * @param letter
	 *            the encountered character due to which the transition takes place
	 */
	public void addTransition(int fromState, int toState, char letter) {
		delta[fromState][toState] = letter;
	}
	/**
	 * defines the final state of the turing machine
	 * @param q 
	 * 		index of the final state
	 */
	public void addFinalState(int q) {
		finalStates[q] = true;
	}
	/**
	 * indicates if the input string is accepted by the Turing machine. 
	 * @param s
	 * @return
	 */
	public boolean isAccepted(String s) {
		currentState = startState;
		readingSymbols: for (int i = 0; i < s.length(); i++) {
			//System.out.println(" current state: " + currentState);
			//System.out.println(" next symbol: " + s.charAt(i));
			for (int j = 0; j < totalStates; j++) {
				if (delta[currentState][j] == s.charAt(i)) {
					currentState = j;
					continue readingSymbols;
				}
			}
			System.out.println(" d(" + currentState + "," + s.charAt(i)
					+ ") is undefined");
			return false;
		}
		//System.out.println(" final state: " + currentState);
		return isFinal();
	}

	public static void main(String args[]) {

		System.out.println("Enter string");
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine().trim();
		//split the input string by 11 as it is the delimiter between the transitions definition and input tape
		String[] inputArray = inputString.split("11");
		//System.out.println("inputArray = " + Arrays.toString(inputArray));
		String stateTransition = inputArray[0];
		// ignore initial 1s
		String stateTransitionClean = stateTransition.substring(
				stateTransition.indexOf("0"), stateTransition.length());
		String transitionArray[] = stateTransitionClean.split("1");
		//System.out.println("TransitionArray= " + Arrays.toString(transitionArray));
		int numberofStates = transitionArray[0].length();
		//System.out.println("number of states= " + numberofStates);
		DFSASimulator a = new DFSASimulator(numberofStates, 0);
		int j = 1;
		for (int i = 1; i < transitionArray.length; i++) {
			for (j = 0; j < numberofStates; j++) {
				a.addTransition(j, transitionArray[i].length() - 1, '0');
				a.addTransition(j, transitionArray[++i].length() - 1, '1');
				i++;
			}
		}
		//System.out.println("final state = " + (transitionArray[1].length() - 1));
		a.addFinalState(transitionArray[1].length() - 1);

		String inputStringActual = inputString.substring(inputArray[0].length()
				+ transitionArray[1].length() + 2, inputString.length());
		if (a.isAccepted(inputStringActual)) {
			System.out.println("Accepted");
		} else {
			System.out.println("Rejected");
		}
	}
}