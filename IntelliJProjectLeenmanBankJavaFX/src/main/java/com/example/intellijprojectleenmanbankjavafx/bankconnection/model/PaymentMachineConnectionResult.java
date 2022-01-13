package com.example.intellijprojectleenmanbankjavafx.bankconnection.model;

public class PaymentMachineConnectionResult {
    private boolean succeeded;
    private long id;

    public PaymentMachineConnectionResult(boolean succeeded, long id) {
        this.succeeded = succeeded;
        this.id = id;
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public long getId() {
        return id;
    }
}
