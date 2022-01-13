package com.example.intellijprojectleenmanbankjavafx.database;

import com.example.intellijprojectleenmanbankjavafx.Launcher;
import com.example.intellijprojectleenmanbankjavafx.database.model.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO extends AbstractDAO<Transaction> {

    public TransactionDAO() {
        super.dBaccess = Launcher.dbAccess;
    }

    public List<Transaction> getAll() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * from transactions";
        try {
            setupPreparedStatement(sql);
            ResultSet resultSet = executeSelectPreparedStatement();

            while (resultSet.next()) {
                long id = resultSet.getInt("id");
                String account = resultSet.getString("account");
                double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");
                String time = resultSet.getString("time");

                Transaction t = new Transaction(id, account, amount, date, time);
                transactions.add(t);
            }
            return transactions;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return transactions;
    }

    public void storeOne(Transaction transaction) {
        String sql = "INSERT INTO `pinmachinedb`.`transactions` (`id`, `account`, `amount`, `date`, `time`) VALUES (?, ?, ?, ?, ?);";

        try {
            getStatementWithKey(sql);
            long id = transaction.getId();
            String account = transaction.getAccountCustomer();
            double amount = transaction.getAmount();
            String date = transaction.getDate();
            String time = transaction.getTime();

            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, account);
            preparedStatement.setDouble(3, amount);
            preparedStatement.setString(4, date);
            preparedStatement.setString(5, time);

            executeInsertPreparedStatementWithKey();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
