package com.example.intellijprojectleenmanbankjavafx.bankconnection.model;

public class PaymentData {

    private String account;
    private int pin;
    private double amount;
    private long idPaymentMachine;

    public PaymentData(String account, int pin, double amount, long idPaymentMachine) {
        this.account = account;
        this.pin = pin;
        this.amount = amount;
        this.idPaymentMachine = idPaymentMachine;
    }

    public String getAccount() {
        return account;
    }

    public int getPin() {
        return pin;
    }

    public double getAmount() {
        return amount;
    }

    public long getIdPaymentMachine() {
        return idPaymentMachine;
    }

}
