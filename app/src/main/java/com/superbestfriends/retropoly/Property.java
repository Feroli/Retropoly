package com.superbestfriends.retropoly;

public class Property extends Space {
    public String name;
    public int cost;
    public int positionOnBoard;
    public Player owner;
    public boolean inMortgage = false; //should add?
    public int houses = 0;
    public boolean hotel = false;

    public Property(String name, int cost) {
        super(name, cost);
    }

    public void setOwner(Player p) {
        owner = p;
    }

    public boolean buyHouse() {
        if (houses >= 0 && houses < 4) {
            houses++;
        } else {
            return false;
        }
        return true;
    }

    public boolean sellHouse() {
        if (houses == 0) {
            return false;
        } else {
            houses--;
        }
        return true;
    }

    public boolean buyHotel() {
        if (houses != 4) {
            return false;
        } else {
            hotel = true;
            return true;
        }
    }

    public int getRent() {
        //TODO something related to Bloomberg API
        return 1;//TODO change this
    }
}
