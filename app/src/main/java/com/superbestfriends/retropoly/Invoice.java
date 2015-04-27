package com.superbestfriends.retropoly;

import java.util.ArrayList;

public class Invoice {
    public String date;
    private String csv = "";
    private int total = 0;
    private ArrayList<Payment> payments = new ArrayList<Payment>();

    public void addPayment(Payment payment) {
        csv += payment.toString() + "\n";
        total += payment.getPrice();
        payments.add(payment);
    }

    public int getTotalCost() {
        return total;
    }

    public String getCSV() {
        return csv;
    }
}
