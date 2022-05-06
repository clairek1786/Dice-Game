//////////////////////////////////////////////////
//
// Claire Kayton
// CSC 160 Computer Science 1, Lab 9.0 Coffee Dispenser
// May 6th, 2022
// This code is the player object class, it has a player name, and a player score, there are getters and setters for every variable.
//
//////////////////////////////////////////////////

package edu.arapahoe.csc160;

public class Player {

    private String playerName;
    private int playerScore;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }
}
