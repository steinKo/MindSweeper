
public class Printer {

	void startMessage(){
		System.out.println("Welcome to Minesweeper!");
		System.out.println("To play just input some coordinates and try not to step ont mine :)");
		System.out.println("Usefull commands:");
		System.out.println("restart- Starts a new game.");
		System.out.println("exit- Quits the game.");
		System.out.println("top- Reveals the top scoreboard.");
		System.out.println("Have Fun !");
	}

	void endMessage() {
		System.out.println("\nThank you for playing :) Have a nice day!");
	}

	static void stepOnABombMesssag(int result) {
		System.out.println("\nBooooooooooooooooooooooooooooom!You stepped on a mine!You survived " + result + " turns");
	}

	static void wonMessag() {
		System.out.println("Congratulations you WON the game!");
	}

	static void nameMessage() {
		System.out.print("\nPlease enter your move(row col): ");
	}
	
	
}
