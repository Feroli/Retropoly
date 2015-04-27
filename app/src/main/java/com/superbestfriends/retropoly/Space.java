package com.superbestfriends.retropoly;

import java.util.ArrayList;

public class Space {
    public String name;
    public int cost;
    private ArrayList<Player> landPlayers = new ArrayList<Player>();

    public Space(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void landPlayer(Player p) {
        landPlayers.add(p);
    }

    /**
     * returns true if player is successfully removed from ArrayList
     */
    public boolean movePlayer(Player p) {
        return landPlayers.remove(p);
    }
}
