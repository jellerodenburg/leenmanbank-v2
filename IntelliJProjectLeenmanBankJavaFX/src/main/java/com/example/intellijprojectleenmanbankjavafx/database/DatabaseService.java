package com.example.intellijprojectleenmanbankjavafx.database;

import com.example.intellijprojectleenmanbankjavafx.database.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static DatabaseService dbService = new DatabaseService();
    TransactionDAO transactionDAO;
    List<Transaction> transactionsOfToday;

    private DatabaseService() {
        transactionDAO = new TransactionDAO();
        transactionsOfToday = new ArrayList<>();
    }

    public static DatabaseService getDbService() {
        return dbService;
    }

    public long giveIdPaymentMachine() {
        return 123456;
        //TODO: after connection functionality has been made get id from DB
    }

    public List<Transaction> getAllTransactions() {
        return this.transactionDAO.getAll();
    }

    public void saveTransaction(long id, String account, double amount) {
        transactionsOfToday.add(new Transaction(id, account, amount));
    }

    public void storeTodaysTransactions() {
        for (Transaction t : transactionsOfToday) {
            transactionDAO.storeOne(t);
        }
    }
}
