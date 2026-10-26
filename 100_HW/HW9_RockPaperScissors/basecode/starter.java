/*
 *	Author:
 *  Date:
 *	Collaborator(s):
*/

import java.util.Scanner;

public class Bot {
    Scanner sc = new Scanner(System.in);
    int AIpick;
    String playerPick;
    int AIWins;
    int playerWins;
    boolean play;

    public play(int choose){
        AIpick = (int)(Math.random()*3)+1;
        playerPick = "";
        AIWins = AIWins;
        playerWins = playerWins;
        play = false;
    }
    public play(int choose, String playerHand, boolean shouldPlay){
        AIpick = (int)(Math.random()*3)+1;
        playerPick = sc.nextLine();
        AIWins = AIWins;
        playerWins = playerWins;
        play = true;
    }

    public void playerWin(){
		playerWins++;
		return playerWins;
	}
    public void aiWin(){
		AIWins++;
		return AIWins;
	}

    public void printDetails(){
		System.out.println("Your wins: " + playerWins);
		System.out.println("AI wins: " + AIWins);
        if(play){
            if(playerPick.equalsIgnoreCase("Rock")||playerPick.equalsIgnoreCase("Paper")||playerPick.equalsIgnoreCase("Scissors")){
                if(playerPick.equalsIgnoreCase("Rock") && AIPick == 1||playerPick.equalsIgnoreCase("Paper") && AIPick == 2||playerPick.equalsIgnoreCase("Scissors") && AIPick == 3){
                    System.out.println("Draw!");
                }
                else if(playerPick.equalsIgnoreCase("Rock") && AIPick == 3||playerPick.equalsIgnoreCase("Paper") && AIPick == 1||playerPick.equalsIgnoreCase("Scissors") && AIPick == 2){
                    System.out.println("Player win!");
                    playerWin();
                }
                else{
                    System.out.println("AI win!");
                    aiWin();
                }
            }
            else{
                System.out.println("");
            }
        }
        else{
            System.out.println("Bye");
        }
		return;
	}
}
