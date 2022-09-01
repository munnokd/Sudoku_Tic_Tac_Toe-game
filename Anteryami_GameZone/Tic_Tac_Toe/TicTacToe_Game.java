
package Anteryami_GameZone.Tic_Tac_Toe;
/**TicTacToe_Game Class Extends the TicTacToe Class. Class Is Used for making User as well as Ui Choice in Board and also diced the winner.*/

public class TicTacToe_Game extends UIChoice{
	
	public TicTacToe_Game(String human, String ui) {
		super(human, ui);
	}
    
	/**HumanTern(i,j) function is used for Enter the humantern in board.*/
	public boolean HumanTern(int i,int j) {
		if(i>3 || j>3) return false;
		if(i<1 || j<1) return false;
		i=i-1;j=j-1;
		if(TicTacBoard[i][j]=="-") {
			TicTacBoard[i][j]=humanchoice;
			return true;
		}
		return false;
	}
	
	/**UITern Function is used for make UI tern by the difficulty level of game*/
	
	public boolean UITern(int D) {
		int a[]=UIchoice(D);
		int i=a[0],j=a[1]; 
		TicTacBoard[i][j]=uichoice;
		return true;
	}
	
    /**isWinner() function is used to find if the user win or UI win.*/
	public boolean isWinner() {
		int i=0;
		boolean f=false;
		for(i=0;i<n;i++) {
		if(TicTacBoard[i][0]==TicTacBoard[i][1]&&TicTacBoard[i][1]==TicTacBoard[i][2]) {
				Game_winner=TicTacBoard[i][0];
				f=true;
				break;
		}
			
		if(TicTacBoard[0][i]==TicTacBoard[1][i]&&TicTacBoard[1][i]==TicTacBoard[2][i]) {
			Game_winner=TicTacBoard[0][i];
			f=true;;
			break;
		  }
	    }
		if((TicTacBoard[0][0]==TicTacBoard[1][1])&&(TicTacBoard[1][1]==TicTacBoard[2][2])) {
			Game_winner=TicTacBoard[0][0];
			f=true;
		}
		
		if((TicTacBoard[0][2]==TicTacBoard[1][1])&&(TicTacBoard[1][1]==TicTacBoard[2][0])) {
			Game_winner=TicTacBoard[2][0];
			f=true;
		
		}
		if(Game_winner=="-") return false;
		if(f==false) return false;
		return true;
	}
	
	public boolean isfull() {
		int i=0,j=0;
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(TicTacBoard[i][j]=="-") return false;
			}
		}
		return true;
	}
	
	

}
