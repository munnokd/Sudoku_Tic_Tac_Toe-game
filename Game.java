

import java.util.Scanner;

import Anteryami_GameZone.Sudoku_Game.Sudoku;
import Anteryami_GameZone.Tic_Tac_Toe.TicTacToe_Game;

public class Game {
	// With the Help of TicTacToe_Game Class and Sudoku Class The Game Code  Make  In This Class.
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		
		System.out.println("--------Well-Come To World Anteryami_GameZone zone!--------");
		while(true) {
			System.out.println("\n1.Tik-Toc-Toe");
			System.out.println("2.Sudoku Master");
			System.out.println("3.Exit:");
			int choice=sc.nextInt();
			if(choice==1) {
 
				System.out.println("Well-Come to Game....Tik-Toc-Toe");
				System.out.println("Please Enter your Hero:");
				String human=Character.toString(sc.next().charAt(0));
				System.out.println("Please Enter your Enemy:");
				String bot=Character.toString(sc.next().charAt(0));
		        while(true) {
		        	
				TicTacToe_Game game=new TicTacToe_Game(human,bot);
				System.out.println("Hero = "+game.GetHumanChoice()+" Enemy = "+game.GetBotChoice());
				System.out.println("Let Started the Gme!!-->");
				game.display();
				System.out.println("Select the Mode Of Game");
				System.out.println("1.Easy");
				System.out.println("2.Medium");
				System.out.println("3.Hard");
				
				int level=sc.nextInt();
				boolean f=false;
				
				while(!game.isfull()) {
					while(true) {
					System.out.println("Your Tern Enter position 1 base indexing(Like (1,1)):");
					int i=sc.nextInt();
					int j=sc.nextInt();
				    if(game.HumanTern(i, j)) {
				    	break;
				    }
				    System.out.println("Enter Right position:");
					}
					game.display();
					if(game.isWinner()) {
						f=true;
						break;
					}
					if(game.isfull()) break;
					System.out.println("UI Tern:.........:");
					game.UITern(level);
					game.display();
					if(game.isWinner()) {
						f=true;
						break;
					}
				}
				
				if(f) {
					if(game.GetWinner()==human) {
						System.out.println("You Win,the Game. YEH");
					}
					else {
						System.out.println("Better Luck Next Time,You Loss the Game.");
					}
				}
				else {
					System.out.println("Math tie,OH You Play Well.");
				}
				System.out.println("Enter 2 for Play Again.(1 for break):");
				if(sc.nextInt()==1) break;
		        }
				
			} 
			
			else if(choice==2){
				
				while(true) {
				
				System.out.println("Well-Come to the Sudoku Game---->");
				System.out.println("Select the Mode Of Game");
				
				System.out.println("1.Easy");
				System.out.println("2.Medium");
				System.out.println("3.Hard");
				
				int level=sc.nextInt();
				
				Sudoku game=new Sudoku(level);
				
				game.Sudoku_Borad_Creater();

				boolean f=true;
				while(!game.isfull()) {

					if(f==true) game.show_Board(1);

					
					System.out.println("Your Tern Enter position 1 base indexing(Like (1,1)):");
					
					int i=sc.nextInt();
					int j=sc.nextInt();
					
					System.out.println("Enter the Number for position "+i+" and "+j);
					int v=sc.nextInt();
					
					if(!game.humanTern(i, j, v)) {
						System.out.println("Enter valid position(at the number 0 present) or number(must be 1 to 9):");
						f=false;
					}
					else{
						f=true;
					}
				}
				
				if(game.isWinner()) {
					game.show_Board(1);
					System.out.println("You Win,the Game. YEH");
				}
				else {
					System.out.println("Better Luck Next Time,You Loss the Game.");
					
					System.out.println("Enter yes if you Want to see ans or No for next game:");
					
					if(sc.next().equals("yes")) {
						System.out.println("Ans. of Sudoku is:");
						game.show_Board(2);
					}
				}
			System.out.println("Enter 2 for Play Again.(1 for break):");
			if(sc.nextInt()==1) break;
		    }
			}
			else {
				break;
		}
		}
		System.out.println("Thank You");
	}

}
