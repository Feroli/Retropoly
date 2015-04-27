package com.superbestfriends.retropoly;

public class Payment {
    private String product;
    private int price;
    private int decrebit;//debit or credit

    public Payment(String product, int decrebit, int price) {
        this.product = product;
        this.decrebit = decrebit;
        this.price = price * decrebit;
    }

    public String toString() {
        if (decrebit == -1) {
            return product + ", debit, " + price;
        }
        return product + ", credit, " + price;
    }

    public int getPrice() {
        return price;
    }
}
