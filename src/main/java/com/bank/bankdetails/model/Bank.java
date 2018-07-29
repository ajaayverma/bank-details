package com.bank.bankdetails.model;

/**
 * Created by Ajay on 7/27/2018.
 */
public class Bank {
    private String name;
    private String postBank;
    private String euroCity;
    private String commerzBank;
    private String raiffeisenBank;

    public String getName() {
        return name;
    }

    public String getPostBank() {
        return postBank;
    }

    public String getEuroCity() {
        return euroCity;
    }

    public String getCommerzBank() {
        return commerzBank;
    }

    public String getRaiffeisenBank() {
        return raiffeisenBank;
    }

    public Bank(String name, String postBank, String euroCity, String commerzBank, String raiffeisenBank) {
        this.name = name;
        this.postBank = postBank;
        this.euroCity = euroCity;
        this.commerzBank = commerzBank;
        this.raiffeisenBank = raiffeisenBank;
    }
}
