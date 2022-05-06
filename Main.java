//////////////////////////////////////////////////
//
// Claire Kayton
// CSC 160 Computer Science 1, Final Project, Dice Game
// May 6th, 2022
// This code will run the dice game. The players will be assigned a name through user input, then they will roll two dice per turn, and add varying totals to their score, the first player to get a score of exactly 30 wins, and if you go above 30, you lose and your score is set back to 0.
//
//////////////////////////////////////////////////


package edu.arapahoe.csc160;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to \"30 or Bust\"!\nThe goal of \"30 or Bust\" is to reach a score of exactly 30.\nYou roll two dice per turn, and you get to choose whether to add the first dice, the second dice, or both of the dice to your total score.\nIf you get stuck near the end and your score goes above 30, BAM! you have to completely restart with a score of 0!");

        // player objects are created using the names that were input

        System.out.println("Welcome Player 1!! What is your name?");
        String temp = input.nextLine();
        System.out.println("Welcome to the game " + temp + "!");
        Player playerOne = new Player(temp);

        System.out.println("Welcome Player 2!! What is your name?");
        temp = input.nextLine();
        System.out.println("Welcome to the game " + temp + "!");
        Player playerTwo = new Player(temp);

        System.out.println("Welcome to the game " + playerOne.getPlayerName() + " and " + playerTwo.getPlayerName() + "!");



        // if turn = 1, then it will do player 1's turn, then it will add 1
        // if turn = 2, then it will be player 2's turn, then it will subtract 1
        boolean keepPlaying = true;
        int turn = 1;


        // during the turns, it runs the method to do a turn, then it adds it to the score, then it checks for win or lose conditions
        // if they neither win or lose, the turn gets moved over to the second player
        while (keepPlaying) {
            if (turn == 1) {
                System.out.println("It is " + playerOne.getPlayerName() + "'s turn. Your score is " + playerOne.getPlayerScore() + ".");
                playerOne.setPlayerScore(doTurn() + playerOne.getPlayerScore());
                if (playerOne.getPlayerScore() > 30) {
                    System.out.println(playerOne.getPlayerName() + " has to restart!");
                    playerOne.setPlayerScore(0);
                }
                if (playerOne.getPlayerScore() == 30) {
                    System.out.println("You got a score of 30!!!");
                    System.out.println(playerOne.getPlayerName() + " wins!");
                    keepPlaying = false;
                    return;
                }
                turn += 1;
            }
            if (turn == 2) {
                System.out.println("It is " + playerTwo.getPlayerName() + "'s turn. Your score is " + playerTwo.getPlayerScore() + ".");
                playerTwo.setPlayerScore(doTurn() + playerTwo.getPlayerScore());
                if (playerTwo.getPlayerScore() > 30) {
                    System.out.println(playerTwo.getPlayerName() + " has to restart!");
                    playerTwo.setPlayerScore(0);
                }
                if (playerTwo.getPlayerScore() == 30) {
                    System.out.println("You got a score of 30!!!");
                    System.out.println(playerTwo.getPlayerName() + " wins!");
                    keepPlaying = false;
                    return;
                }
                turn -= 1;
            }
        }
    }

    // this method returns an int value so it can be added to the score of the player that is currently playing
    public static int doTurn() {
        Scanner input = new Scanner(System.in);

        // creates dice objects to be used
        Dice diceOne = new Dice();
        Dice diceTwo = new Dice();
        diceOne.rollDice();
        diceTwo.rollDice();

        System.out.println("Dice 1 Roll is: " + diceOne.getDiceResult());
        System.out.println("Dice 2 Roll is: " + diceTwo.getDiceResult());

        System.out.println("Would you like to (1), Keep just the first dice, (2), keep the second dice, or (3), keep both?");
        int choice = input.nextInt();
        return switch (choice) {
            case 1 -> diceOne.getDiceResult();
            case 2 -> diceTwo.getDiceResult();
            case 3 -> diceOne.getDiceResult() + diceTwo.getDiceResult();
            default -> 0;
        };
    }
}