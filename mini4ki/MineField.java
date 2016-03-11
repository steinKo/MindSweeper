import java.util.Random;

class MineField{

	private boolean[][] mines;
	private boolean[][]visible;
	private boolean boom;
	private final int rowMax = 5;
	private final int colMax = 10;
	Printer printer;
	
	MineField(){
		printer =new Printer();
		mines=new boolean[rowMax][colMax];
		visible=new boolean[rowMax][colMax];
		boom=false;
		
		createMineField();
		placeTheMines();
	}
	
	private void placeTheMines() {
		int counter2=15;
		int randomRow;
		int randomCol;
		Random RGenerator=new Random();
		
		while(counter2>0){
			
			randomRow=Math.abs(RGenerator.nextInt()%rowMax);
			randomCol=Math.abs(RGenerator.nextInt()%colMax);
			
			if(trymove(randomRow,randomCol)){
				counter2--;
			}
		}
	}
	private void createMineField() {
		for(int row=0;row<rowMax;row++){
			for(int col=0;col<colMax;col++){
				createMinfFildElement(row, col);
			}
		}
	}
	private void createMinfFildElement(int row, int col) {
		mines[row][col]=false;
		visible[row][col]=false;
	}	
	private boolean trymove(int randomRow, int randomCol) {
		if(mines[randomRow][randomCol]){
			return false;
		}
		else{
			mines[randomRow][randomCol]=true;
			return true;
		}
	}
	private void boom() {
		for(int row=0;row<rowMax;row++){
			for(int col=0;col<colMax;col++){
				makeVisible(row, col);
			}
		}
		boom=true;
		printer.show(this);
		
		
	}

	private void makeVisible(int row, int col) {
		if(mines[row][col]){
			visible[row][col]=true;
		}
	}


	int numberOfMinesinNeighborhood(int row, int col, int count) {
		for(int irow=row-1;irow<=row+1;irow++){
		   for(int icol=col-1;icol<=col+1;icol++){
			    count = countMines(count, irow, icol);
		}
}
		return count;
	}
	public boolean[][] mines() {
		return mines;
	}


	public boolean[][] visible() {
		return visible;
	}


	public void boom(boolean boom) {
		this.boom = boom;
	}

	private int countMines(int count, int irow, int icol) {
		if(icol>=0&&icol<colMax&&irow>=0&&irow<rowMax){
			if(mines[irow][icol])
				count++;
		}
		return count;
	}
	public boolean getBoom(){
		
		return boom;
	}

    public int maksimumNuberofRows( )
{
		return rowMax; 
		
	}
     
	public boolean legalMoveString(String input) {
		String[] separated=input.split(" ");
		int row;
		int col;
		try{
			
			
			row=Integer.parseInt(separated[0]);
			col=Integer.parseInt(separated[1]);
			if(row<0||col<0||row>=rowMax||col>=colMax){
				throw new java.io.IOException();
			}
		}
		catch(Exception e){
			printer.revealAreaMessage();
			return false;
		}
		
		if(legalMoveValue(row,col)){
			return true;
			
			
		}
		else{
			return false;
		}
	}
	private boolean legalMoveValue(int row, int col) {
		
		if(visible[row][col]){
			printer.revealeAreaMessage();
			return false;
		}
		else{
			visible[row][col]=true;
		}
		
		if(mines[row][col]){
			boom();
			return false;
		}
		
		return true;
	}
	public int maksimumNumberofColumns() {
		
		return colMax;
	}
	
}
