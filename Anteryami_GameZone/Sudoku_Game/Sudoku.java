package Anteryami_GameZone.Sudoku_Game;


// Sudoku class is main class for Sudoku Game. Which Use for Sudoku Board create with help of SudokuBoardCreate class, Make User Move on Board and Check if User Win or not.

public class Sudoku extends SudokuBoardCreate{
	
	public Sudoku(int level){
		super(level);
	}
	
	
	/**humanTern() function is used for make the humantern in the game. if position
	 * Enter by user if ok than function put humchoice in the borad at ith and jth
	 * position. */
	
	public boolean humanTern(int i,int j,int v) {
		i=i-1;j=j-1;
		if(v>9 || v<1) return false;
		if(Sudoku_Board[i][j]==0) {
			Sudoku_Board[i][j]=v;
			return true;
		}
		return false;
	}
	
	
	public boolean isfull() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(Sudoku_Board[i][j]==0) return false;
			}
		}
		return true;
	}
	
	
	/**isWinner() Function is used to find is User Enter All the Valid number in Sudoku Board
	 * in place of 0.*/
	
	public boolean isWinner() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(Sudoku_Board[i][j]!=ans[i][j]) return false;
			}
		}
		return true;
	}
	
	public Integer[][] Get_WinnerBorad(){
		return ans;
	}
	
	
	

}
