/*
 *	Author:
 *  Date:
 * 	Collaborator:
 */

import java.util.*;
import java.util.Scanner;

public class starter {
    public static void main(String[] args) {
        static Scanner sc = new Scanner(System.in);
        System.out.println("Choose rock, paper, or scissors.");
        int choose = sc.nextInt();
        int aiChoose = (int)(Math.random()*0)+3;
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
            
        }
    }
}
