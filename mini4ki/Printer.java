
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

	void printColumnBoarder() {
		System.out.println("   ---------------------");
	}

	void printColumNumbers() {
		System.out.println("\n    0 1 2 3 4 5 6 7 8 9 ");
		
	}

	void revealAreaMessage() {
		System.out.println("\nInvalid Input!");
	}

	void revealeAreaMessage() {
		System.out.println("You stepped in allready revealed area!");
	}

	void mindFiledBoarderMessag() {
		System.out.println(" |");
	}

	void printRowNumber(int row) {
		System.out.print(row+" |");
	}

	
	
	void printMineRow(MineField mineField, int row) {
		for(int col=0;col<mineField.maksimumNumberofColumns();col++){
			System.out.print(" "+mineField.printer.drawChar(mineField, row,col));
			
		}
	}

	void maxLimitofPlayerMessage(int maksimumPlayers) {
		System.out.println("\nSorry you cannot enter top "+maksimumPlayers+" players");
	}

	void enterNameMessage() {
		System.out.print("\n Please enter your name -");
	}

	void resultHeaderMessage() {
		System.out.println("N Name\t\tresult");
	}

	void noResultMessage() {
		System.out.println("Still no results");
	}

	void resultMessage(int moves, String[] names, int[] records) {
		System.out.println((moves+1)+" "+names[moves]+"\t"+records[moves]);
	}

	void rowMessage(int masimumNumberOfRows, MineField mineField, int maksimumNumbersOfColumns) {
		for(int row=0;row<masimumNumberOfRows;row++){
			printRowNumber(row);
			printMineRow(mineField, row);
			mindFiledBoarderMessag();
		}
	}
	
	void rowMessage(MineField mineField) {
		for(int row=0;row< mineField.maksimumNuberofRows();row++){
			printRowNumber(row);
			printMineRow(mineField, row);
			mindFiledBoarderMessag();
		}
	}


	
	public void show(MineField mineField) {
		printColumNumbers();
		printColumnBoarder();
		rowMessage(mineField);
		printColumnBoarder();
	}

	char convertMinesInNegborhood(int minesInNeigborhood) {
		switch(minesInNeigborhood){
		case 0:return '0';
		case 1:return '1';
		case 2:return '2';
		case 3:return '3';
		case 4:return '4';
		case 5:return '5';
		case 6:return '6';
		case 7:return '7';
		case 8:return '8';
		
		
		default:return 'X';
		}
	}

	char drawChar(MineField mineField, int row, int col) {
		
		final boolean[][] mines;
		final boolean[][]visible;
		final boolean boom;
		
		int minesInNeigborhood=0;
		
		mines = mineField.mines();
		visible = mineField.visible();
		boom = mineField.getBoom();
		
		if(visible[row][col]){
			if(mines[row][col])
				return '*';
			    minesInNeigborhood = mineField.numberOfMinesinNeighborhood(row, col, minesInNeigborhood);
		}
		else{
			if(boom){
				return '-';
			}
			{
				
				
				return '?';
			}
		}
		return convertMinesInNegborhood(minesInNeigborhood);
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
