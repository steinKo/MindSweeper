import java.util.Scanner;

public class Ranking{

	private final int MAX_PEOPLE_LIMIT=5;
	private String[] name;
	private int[] record;
	private int last;
	private Printer printer;
	
	Ranking(){
		name=new String[MAX_PEOPLE_LIMIT];
		record=new int[MAX_PEOPLE_LIMIT];
		printer = new Printer();
		last=0;
		
	}


	public void recordName(int result) {
		printer.enterNameMessage();
		Scanner in=new Scanner(System.in);
		String newName=in.nextLine();
		if((last==MAX_PEOPLE_LIMIT)&&record[MAX_PEOPLE_LIMIT-1]>result){
			printer.maxLimitofPlayerMessage(MAX_PEOPLE_LIMIT);
			return;
		}
		else if(last==MAX_PEOPLE_LIMIT){
			name[MAX_PEOPLE_LIMIT-1]=newName;{
				record[MAX_PEOPLE_LIMIT-1]=result;
			}
		}
		else{
			name[last]=newName;{
				record[last]=result;{
					last++;
				}
			}
		}
		
		sort();
		show();
	}


	public void show() {
		if(last==0){
			printer.noResultMessage();
			return;
		}
		printer.resultHeaderMessage();
		for(int i=0;i<last;i++){
			printer.resultMessage(i, name, record);
		}
	}


	private void sort(){
		if(last<2)
			return;
		boolean unsorted=true;
		while(unsorted){
			unsorted=false;
			for(int i=0;i<(last-1);i++){
				unsorted = swap(unsorted, i);
			}
		}
	}


	private boolean swap(boolean unsorted, int i) {
		if(record[i+1]>record[i]){
			int swapR=record[i];{
				record[i]=record[i+1];{
					unsorted = swap(i, swapR);
				}
			}
		}
		return unsorted;
	}


	private boolean swap(int i, int swapR) {
		boolean unsorted;
		record[i+1]=swapR;
		String swapN=name[i];
		name[i]=name[i+1];
		name[i+1]=swapN;
		unsorted=true;
		return unsorted;
	}
}
