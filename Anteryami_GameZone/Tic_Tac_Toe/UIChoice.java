package Anteryami_GameZone.Tic_Tac_Toe;

import java.util.Random;


/**UIChoice Class Extends the TicTacToe Class. The Class Is Used for Making UIChoice in the Game based on the difficulty level.*/
public class UIChoice extends TicTacToe{
	

	UIChoice(String human, String ui) {
		super(human, ui);
	}
    
	protected int[] UIchoice(int d) {
		if(d==1) {
			return UI_Easy();
		}
		if(d==2) {
			return UI_Medium();
		}
		
		return UI_Hard();
	}
	
	/**UI_Hard() function make sure the user row and column all values are not same and the
	 * right to left diagonal value are not same.*/
    
	private int[] UI_Hard() {
		int ans[]=new int[2];
		int x=0;
		boolean f=false;
		for(int i=0;i<n;i++) {
			if(TicTacBoard[i][i]==humanchoice) {
				x++;
			}
			else if(TicTacBoard[i][i]=="-") {
				ans[0]=i;
				ans[1]=i;
				f=true;
			}
		}
		if(x==2 && f) return ans;
		return UI_Medium();
	}

	/**UI_Medium() function make sure the user row and column all values are not same.*/
	
	private int[] UI_Medium() {
		int ans[]=new int[2];
		for(int i=0;i<n;i++) {
			int x=0;
			boolean f=false;
			for(int j=0;j<n;j++) {
				if(TicTacBoard[i][j]==humanchoice) {
					x++;
				}
				else if(TicTacBoard[i][j]=="-") {
					ans[0]=i;
					ans[1]=j;
					f=true;
				}
			}
			if(x==2 && f) return ans;
			f=false;
			x=0;
			for(int j=0;j<n;j++) {
				if(TicTacBoard[j][i]==humanchoice) {
					x++;
				}
				else if(TicTacBoard[j][i]=="-") {
					ans[0]=j;
					ans[1]=i;
					f=true;
				}
			}
			if(x==2 && f) return ans;
		}
	    return UI_Easy();
	}

	/**This Function is used for making any valid position for UI and game.*/
	private int[] UI_Easy() {
		int ans[]=new int[2];
		int a,b;
		boolean f=false;
		Random random = new Random(); 
		while(!f) {
		    a=random.nextInt(3);
		    b=random.nextInt(3);
		    if(TicTacBoard[a][b]=="-") {
		    	ans[0]=a;ans[1]=b;
		    	f=true;
		    }
		}
		return ans;
	}

}
