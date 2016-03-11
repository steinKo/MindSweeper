import java.util.Scanner;


public class Minesweeper {

	private static Printer printer;
	private static MineField field;
	private static Ranking rank;	
	public static void main(String[] args) {
		rank=new Ranking();
		printer=new Printer();
		printer.startMessage();
		while(gameCountinue());
		printer.endMessage();
	}
	private static boolean gameCountinue()

	
	{
		field = new MineField();
		int result = 0;
		while (true) {

			field.show();
			printer.nameMessage();
			String input = command();

			if (input.equals("top")) {
				rank.show();
				continue;


			}
			if (input.equals("restart")) {
				rank.recordName(result);
				return true;
			}
			if (input.equals("exit")) {
				rank.recordName(result);
				return false;
			}
			if (field.legalMoveString(input)) {
				result++;
				if (result == 35) {
					return gameWon(result);
				}
				continue;
			}

			else if (field.getBoom()) {
				return printStepOnABomb(result);
			}

		}


		}
	private static String command() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		return input;
	}
	private static boolean printStepOnABomb(int result) {
		printer.stepOnABombMesssag(result);
		rank.recordName(result);
		return true;
	}
	private static boolean gameWon(int result) {
		printer.wonMessag();
		rank.recordName(result);
		return true;
			
		}
		
		
}
