 package Anteryami_GameZone.Sudoku_Game;

import java.util.ArrayList;
import java.util.Random;

// SudokuBoardCreate class extends by  Sudoku class. Basically this class is Use for Creation of Sudoku Board Based on Difficulty level.

public class SudokuBoardCreate {

	protected int n=9,Choice=0,done=0,d=1;
	protected Integer Sudoku_Board[][]=new Integer[n][n];
	protected Integer[][] ans=new Integer[9][9];
	protected ArrayList<Integer[][]> All_Boards=new ArrayList<>();

	/**SudokuBoardCreate class is main class which extends by  Sudoku class.
	 * Level or D variable is refers to Level of Game*/

	public SudokuBoardCreate(int level) {
		this.d=level;
		fill(ans, 0);
	}

	/**Sudoku_Borad_Creater() Function Create the Sudoku bread as per user difficulty
	 *level. As we know that most of sudoku board are in 9X9. */

	public void Sudoku_Borad_Creater() {
		Random random=new Random();

		// fill(ans,0);

		ans[0][0]=random.nextInt(9)+1;


		Sudoku_All_Borad_Creater(ans,0,1);

		Choice=random.nextInt(All_Boards.size());

		Sudoku_Board=All_Boards.get(Choice);

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans[i][j]=Sudoku_Board[i][j];
			}
		}

		int level;

		if(d==1) level=5;
		else if(d==2) level=15;
		else level=20;

		int c=0;
		while(c!=level) {
			int i=random.nextInt(9);
			int j=random.nextInt(9);

			if(Sudoku_Board[i][j]!=0) {
				Sudoku_Board[i][j]=0;
				c++;
			}
		}
	}

	private void fill(Integer[][] ans, int v) {

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans[i][j]=v;
			}
		}

	}
	public void show_Board(int a) {
		Integer[][] arr;
		if(a==1) arr=Sudoku_Board;
		else arr=ans;
		System.out.println("Sudoku Anteryami_GameZone.Game Board.......");
		for(int i=0;i<n;i++) {
			if(i%3==0) System.out.println("----------------------------");
			for(int j=0;j<n;j++) {
				if(j!=0&&j%3==0) System.out.print("| "+arr[i][j]+" ");
				else System.out.print(" "+arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	/**
	 * Sudoku_All_Borad_Creater() function create 10 random 9x9 sudoku board.*/

	private void Sudoku_All_Borad_Creater(Integer[][] ans, int i, int j) {
		if(i>=n) {
			Integer arr[][]=new Integer[n][n];

			for(int a=0;a<n;a++) {
				for(int b=0;b<n;b++) {
					arr[a][b]=ans[a][b];
				}
			}
			done++;
			All_Boards.add(arr);
			return;
		}

		if(j>=n) {
			Sudoku_All_Borad_Creater(ans,i+1,0);
			return;
		}

		for(int k=1;k<=9;k++) {
			if(done!=10 && isok(ans,i,j,k)) {
                ans[i][j]=k;
				Sudoku_All_Borad_Creater(ans,i,j+1);
				ans[i][j]=0;
			}
		}
	}

	/**isok() is one of helping function of Sudoku_All_Borad_Creater() function.*/

	private boolean isok(Integer[][] ans, int i, int j, int k) {

		int index=0,index_2=0;
		for(index=0;index<n;index++) {
			if(k==ans[index][j]) return false;

			if(k==ans[i][index]) return false;
		}

		int index_row=i/3,index_cloumn=j/3;

		for(index=index_row*3;index<(index_row*3)+3;index++) {
			for(index_2=index_cloumn*3;index_2<(index_cloumn*3)+3;index_2++) {
				if(ans[index][index_2]==k) return false;
			}
		}
		return true;
	}

}
