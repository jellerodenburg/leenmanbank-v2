package com.example.intellijprojectleenmanbankjavafx.bankconnection.model;

public class PaymentMachineConnectionData {

    private String account;
    private int connectionCode;

    public PaymentMachineConnectionData(String account, int connectionCode) {
        this.account = account;
        this.connectionCode = connectionCode;
    }

    public String getAccount() {
        return account;
    }

    public int getConnectionCode() {
        return connectionCode;
    }
}
