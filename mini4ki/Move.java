
public class Move {

	public boolean legalMoveString(MineField mineField, String input) {
		String[] separated=input.split(" ");
		int row;
		int col;
		try{
			
			
			row=Integer.parseInt(separated[0]);
			col=Integer.parseInt(separated[1]);
			if(row<0||col<0||row>=mineField.maksimumNumberOfRows()||col>=mineField.maksimumNumberOfColumns()){
				throw new java.io.IOException();
			}
		}
		catch(Exception e){
			mineField.printer.revealAreaMessage();
			return false;
		}
		
		if(mineField.move.legalMoveValue(mineField, row,col,mineField)){
			return true;
			
			
		}
		else{
			return false;
		}
	}

	boolean legalMoveValue(MineField mineField, int row, int col, MineField minefiled) {
		boolean[][] mines;
		boolean[][]visible;
		mines=minefiled.mines( );
		visible=minefiled.visible( );
		if(visible[row][col]){
			mineField.printer.revealeAreaMessage();
			return false;
		}
		else{
			visible[row][col]=true;
		}
		
		if(mines[row][col]){
			mineField.boom();
			return false;
		}
		
		return true;
	}

	boolean trymove(int randomRow, int randomCol, MineField mineField) {
		boolean[][] mines;
		mines =mineField.mines();
		if(mines[randomRow][randomCol]){
			return false;
		}
		else{
			mines[randomRow][randomCol]=true;
			return true;
		}
	}

}
