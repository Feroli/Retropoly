package com.superbestfriends.retropoly;

import java.util.ArrayList;

public class Game {
    public static Player currentPlayer;
    public static ArrayList<Player> players = new ArrayList<Player>(6);
    public static int ctr;
    private static boolean start = true;
    boolean running;

    //return false if ArrayList is full
    public static boolean addPlayer(Player p) {
        return players.add(p);
    }

    public static void chooseFirstPlayerGame() {
        int x = (int) (Math.random() * players.size());
        currentPlayer = players.get(x);
    }

    public static void rollDice() {
        int moves = currentPlayer.rollDice();
        currentPlayer.setPosition(moves);//redundant? to ^
        Board.spaces[moves].landPlayer(currentPlayer);
    }

    public static void playerDoSomething() {
        if (currentPlayer.missATurn == true) {
            //do something
        } else {
            //
        }
    }

    public static boolean chooseNextPlayer() {
        if (start == false) {
            ctr++;
            if (ctr == 1) {
                return endGame();
            } else if (ctr == players.size()) {
                ctr = 0;
            }
        } else {
            chooseFirstPlayerGame();
        }
        return true;
    }

    public static boolean endGame() {
        if (ctr == 1) {
            return true;
        }
        return false;
    }

    public static void bankruptPlayer(Player p) {
        players.remove(p);
    }
}