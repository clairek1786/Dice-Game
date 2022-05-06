//////////////////////////////////////////////////
//
// Claire Kayton
// CSC 160 Computer Science 1, Final Project, Dice Game
// May 6th, 2022
// This code contains the dice object class, when it is created, it has no face value, so you have to roll the dice each time you want a new result. It also has getters and setters for each variable.
//
//////////////////////////////////////////////////

package edu.arapahoe.csc160;

import java.util.Random;

public class Dice {

    private int diceResult;

    public void rollDice() {
        Random RNG = new Random();
        this.diceResult = RNG.nextInt(6) + 1;
    }

    public int getDiceResult() {
        return diceResult;
    }

    public void setDiceResult(int diceResult) {
        this.diceResult = diceResult;
    }
}
