package com.superbestfriends.retropoly;

import java.util.ArrayList;

public class Player {
    private String name;
    private static int number = 0;
    private int cash;
    private int position;
    private ArrayList<Property> properties;
    private boolean inJail = false;
    private boolean turn;
    private int imageId;
    public boolean missATurn;
    private boolean loose = false;
    private Invoice invoice;

    public Player(String name, int color) {
        number++;
        this.name = name;
        cash = 500;
        properties = new ArrayList<Property>();
        invoice = new Invoice();
    }

    public String getName() {
        return name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean buy(Property p) {
        invoice.addPayment(new Payment("Bought: " + p.name, -1, p.cost));
        return false;
    }

    public boolean sell(Property p) {
        invoice.addPayment(new Payment("Sold: " + p.name, +1, p.cost));
        return false;
    }

    /**
     * @return position on board
     */
    public void setPosition(int diceRoll) {
        position = position + diceRoll;
        if (position > Board.spaces.length) {
            int extra = Board.spaces.length - position;
            position = extra;
        }
    }

    public int getPosition() {
        return position;
    }

    public void putInJail() {
        inJail = true;
    }

    public void getOutOfJail() {
        inJail = false;
    }

    public void pay(String product, int cost) {
        cash = cash - cost;
        invoice.addPayment(new Payment(product, -1, cost));
        if (cash < 0) {
            goBankrupt();
        }
    }

    public void earn(String product, int cost) {
        cash = cash + cost;
        invoice.addPayment(new Payment(product, +1, cost));
    }

    public int rollDice() {
        int moves = (int) (Math.random() * 12);
        return moves;
    }

    public void goBankrupt() {
        loose = true;
        Game.bankruptPlayer(this);
    }
}
