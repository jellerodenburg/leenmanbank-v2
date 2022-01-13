package com.example.intellijprojectleenmanbankjavafx.bankconnection.model;

public class PaymentResult {

    private boolean succeeded;
    private int statuscode;
    private long transactionId;

    public PaymentResult(boolean succeeded, int statuscode, long transactionId) {
        this.succeeded = succeeded;
        this.statuscode = statuscode;
        this.transactionId = transactionId;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public long getTransactionId() {
        return transactionId;
    }
}
