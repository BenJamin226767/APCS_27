/*
 *	Author:
 *  Date:
 * 	Collaborator:
 */

import java.util.*;
import java.util.Scanner;

public class starter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose (1)rock, (2)paper, or (3)scissors.");
        int choose = sc.nextInt();
        int aiChoose = (int)(Math.random()*3)+1;
        String chooseWord = "";
        String aiChooseWord = "";
        if(choose == 1){
            chooseWord = "Rock";
        }
        else if(choose == 2){
            chooseWord = "Paper";
        }
        else{
            chooseWord = "Scissors";
        }
        if(aiChoose == 1){
            aiChooseWord = "Rock";
        }
        else if(aiChoose == 2){
            aiChooseWord = "Paper";
        }
        else{
            aiChooseWord = "Scissors";
        }

        if(choose == aiChoose){
            System.out.println("Draw! Your choice: " + chooseWord + " vs. AI's choice: " + aiChooseWord);
        }

        if (choose == 1 && aiChoose == 2 || choose == 2 && aiChoose == 3 || choose == 3 && aiChoose == 1){
            System.out.println("AI Won! Your choice: " + chooseWord + " vs. AI's choice: " + aiChooseWord);
        }
        else{
            System.out.println("You Won! Your choice: " + chooseWord + " vs. AI's choice: " + aiChooseWord);
        }
    }
}
