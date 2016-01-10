//class Transition 
//{
//    public static int RIGHT = 1;
//    public static int LEFT = 0;
//    public char retChar;
//    public int retDir;
//    public int retState;
//    public int currentState;
//
//    Transition(char outputChar, int direction, int toState) 
//    {
//        retChar = outputChar;
//        retDir = direction;
//        retState = toState;
//    }   
	
	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */

	/**
	 *
	 * @author Ashwin
	 */
	public class Transition {
		static char LEFT = 'l';
		static char RIGHT = 'r';
		private char tapeChar;//tape character to write
		private char direction;//direction of movement
		private int nextState;//next state

		public Transition(char writeTapeChar, char direction, int nextState) {
			this.tapeChar = writeTapeChar;
			this.direction = direction;
			this.nextState = nextState;
		}
	        
	        public char getTransitionChar(){
	            return tapeChar;
	        }
	        
	        public char getDirection(){
	            return direction;
	        }
	        
	        public int getNextState(){
	            return nextState;
	        }
	}
//}
