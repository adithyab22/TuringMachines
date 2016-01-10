/**
 * Program to simulate a Finite State Machine that reads the tape from left to right
 * and replaces any 1’s with 0’s and any 0’s with 1’s. 
 * 
 * @author Adithya Balasubramanian
 *
 */
public class Turing1 
{   
    public static void main( String args[]) 
    {
       Turing machine = new Turing(1);
       //Following are various transitional operations performed on the tape:
       Transition one =   new Transition('0',Transition.RIGHT, 0);
       Transition two =   new Transition('1',Transition.RIGHT, 0);
       Transition three = new Transition('B', Transition.LEFT,1);
       
       //Transitions applied to states of the finite state automata:
       machine.addTransition(0, '0', two);
       machine.addTransition(0, '1', one);
       machine.addTransition(0, 'B', three);

       String inTape = "11111100010101";

       System.out.println(inTape);
       
       String outTape = machine.execute(inTape);
       System.out.println(outTape);
    }
}
