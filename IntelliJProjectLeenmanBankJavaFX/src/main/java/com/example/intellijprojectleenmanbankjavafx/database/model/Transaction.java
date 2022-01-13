package com.example.intellijprojectleenmanbankjavafx.database.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private long id;
    private String accountCustomer;
    private double amount;
    private String date;
    private String time;

    public Transaction(long id, String accountCustomer, double amount, String date, String time) {
        if (id <= 0) throw new IllegalArgumentException("Id cannot be below or equals to 0");
        if (amount <= 0) throw new IllegalArgumentException("amount cannot be below or equals to 0");
        if (accountCustomer == null) throw new IllegalArgumentException("account cannot be null");

        this.id = id;
        this.accountCustomer = accountCustomer;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }

    /**
     * @param id
     * @param accountCustomer
     * @param amount
     * @should have current date set on creation
     * @should have current time set at creation
     * @should ThrowIllegalArgumentExceptionWithIdBelow0
     * @should ThrowIllegalArgumentExceptionWithAmountBelow0
     * @should ThrowIllegalArgumentExceptionForNullValues
     */

    public Transaction(long id, String accountCustomer, double amount) {
        this(id, accountCustomer, amount, null, null);
        this.date = giveCurrentDateAsString();
        this.time = giveCurrentTimeAsString();
    }

    private String giveCurrentTimeAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentDate = new Date(System.currentTimeMillis());
        return formatter.format(currentDate);
    }

    private String giveCurrentDateAsString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(System.currentTimeMillis());
        return formatter.format(currentDate);
    }

    public long getId() {
        return id;
    }

    public String getAccountCustomer() {
        return accountCustomer;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("id: %d, account: %s, amount: %.2f date: %s, %s", id, accountCustomer, amount, date, time);
    }
}
