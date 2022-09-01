package Anteryami_GameZone.Tic_Tac_Toe;
/**TicTacToe Class Use for Crating TicTacToe Game Board, and has Some UseFull Variable Like HumanChoice,UiChoice and Winner of Game.*/
public class TicTacToe{
    protected String humanchoice,uichoice,Game_winner;
    protected int n=3;
    protected String[][] TicTacBoard=new String[3][3];
    
    TicTacToe(String human,String ui){
        humanchoice=human;
        uichoice=ui;
        fill("-");
    }
    
    private void fill(String string) {
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                TicTacBoard[i][j]=string;
            }
        }
    }
    public void display() {
        System.out.println("\n Anteryami_GameZone Game Board");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(j==n-1) System.out.print(" "+TicTacBoard[i][j]);
                else System.out.print(" "+TicTacBoard[i][j]+" |");
            }
            if(i!=n-1)System.out.println("\n __________ ");
        }
        System.out.println();
    }

    public String GetHumanChoice() {
        return humanchoice;
    }
    
    public String GetBotChoice() {
        return uichoice;
    }
    public String GetWinner() {
        return Game_winner;
    }
}
