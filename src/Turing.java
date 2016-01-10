import java.util.HashMap;

/**
 * Class that defines the states and transitions of Finite State Turing Machine.
 * @author Adithya Balasubramanian
 *
 */
public class Turing {
	char[] tape = new char[40]; // Tape of size 40
	int header = 19;// header of the tape starts at index 19
	int numberOfStates;
	int currentState = 0;
	HashMap<Character, Transition>[] transitionRuleList;

	/**
	 * Constructor to initialize the number of states, sets the current state to 0, and the tape
	 * header to 19(center of the array)
	 * @param n
	 *            number of states
	 */
	public Turing(int n) {
		this.header = 19; 
		this.currentState = 0;
		this.numberOfStates = n;
		
		this.transitionRuleList = new HashMap[n];
		for (int i = 0; i < n; i++) {
			this.transitionRuleList[i] = new HashMap<Character, Transition>();
		}
		//initialize array with Blanks
		for(int i=0; i< tape.length; i++){
			tape[i] = 'B';
		}
	}

	/**
	 * Method to update the transition list.
	 * 
	 * @param state
	 *            initial state
	 * @param symbol
	 *            character for initiating state change
	 * @param t
	 *            transition to be added
	 */
	public void addTransition(int state, char symbol, Transition t) {
		transitionRuleList[state].put(symbol, t);
	}

	/**
	 * Executing turing machine until it reads a blank(end of the input tape.
	 * Pre-Condition: Machine has been initialized with the number of states and
	 * the transition list. Input tape size less than 20 <br>
	 * Post Condition: The tape has been updated based on the transition list
	 * and the states
	 * 
	 * @param inputTape
	 *            String representation of the input tape
	 * @return the updated tape as a string
	 */
	public String execute(String inputTape) {
		// Reading the input tape
		int idxtapewriter = header;
		for (int i = 0; i < inputTape.length(); i++) {
			tape[idxtapewriter] = inputTape.charAt(i);
			idxtapewriter++;
		}

		while (currentState < numberOfStates) {
			char temp = tape[header];

			tape[header] = transitionRuleList[currentState].get(tape[header])
					.getTransitionChar();

			switch (transitionRuleList[currentState].get(temp).getDirection()) {
			case 'l':
				header--;
				break;
			case 'r':
				header++;
				break;
			}
			currentState = transitionRuleList[currentState].get(temp)
					.getNextState();
		}
		StringBuffer sb = new StringBuffer();
		sb.append(tape);
		return sb.toString();
	}

}