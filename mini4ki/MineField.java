import java.util.Random;

class MineField{

	private boolean[][] mines;
	private boolean[][]visible;
	private boolean boom;
	private final int rowMax = 5;
	private final int colMax = 10;
	Printer printer;
	Move move;
	
	MineField(){
		printer =new Printer();
		move =new Move();
		mines=new boolean[rowMax][colMax];
		visible=new boolean[rowMax][colMax];
		boom=false;
		
		createMineField();
		placeTheMines();
	}
	
	private void placeTheMines() {
		int leftToPlace=15;
		int randomRow;
		int randomCol;
		Random randomr=new Random();
		
		while(leftToPlace>0){
			
			randomRow=Math.abs(randomr.nextInt()%rowMax);
			randomCol=Math.abs(randomr.nextInt()%colMax);
			
			if(placeAMine(randomRow,randomCol )){
				leftToPlace--;
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
	void boom() {
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

    public int maksimumNumberOfRows( )
{
		return rowMax; 
		
	}
     
	public int maksimumNumberOfColumns() {
		
		return colMax;
	}

	boolean placeAMine(int randomRow, int randomCol) {
		boolean[][] mines;
		mines =mines();
		if(mines[randomRow][randomCol]){
			return false;
		}
		else{
			mines[randomRow][randomCol]=true;
			return true;
		}
	}
	
}
