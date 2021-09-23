package com.example.blueskycinema.Zaid;

public class bookingModel {
    Integer id;
    String n_tickets;
    String box_tickets;
    String date;
    String time;
    String amount;

    public bookingModel(Integer id, String n_tickets, String box_tickets, String date, String time, String amount) {
        this.id = id;
        this.n_tickets = n_tickets;
        this.box_tickets = box_tickets;
        this.date = date;
        this.time = time;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getN_tickets() {
        return n_tickets;
    }

    public void setN_tickets(String n_tickets) {
        this.n_tickets = n_tickets;
    }

    public String getBox_tickets() {
        return box_tickets;
    }

    public void setBox_tickets(String box_tickets) {
        this.box_tickets = box_tickets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
