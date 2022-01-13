package project.demo.model;

import java.util.*;

public class Account {
    //region ATTRIBUTES
    private final int TOP10 = 10;
    private Long id;
    private AbstractClient accountHolder;
    private AccountType type;
    private String accountNumber;
    private double balance;
    private final double DEFAULT_START_BALANCE = 0.0;
    private int pincode;
    private final int DEFAULT_PINCODE = 12345;
    private List<Transaction> transactionHistory;
    private Set<AbstractClient> authorizedClients;
    //endregion

    //region CONSTRUCTOR

    public Account(AbstractClient accountHolder, AccountType type) {
        this.accountHolder = accountHolder;
        this.pincode = DEFAULT_PINCODE;
        this.balance = DEFAULT_START_BALANCE;
        this.type = type;
        accountHolder.addAccount(this);
        this.transactionHistory = new ArrayList<>();
        this.authorizedClients = new HashSet<>();
    }
    //endregion

    //region METHODS
    public void addAuthorizedClient(AbstractClient client) {
        this.authorizedClients.add(client);
    }

    public void removeAuthorizedClient(AbstractClient client) {
        this.authorizedClients.remove(client);
    }


    // get/generate the 10 recent transaction from the transactionHistory
    // TODO does this need to be put in a Service? (not in model class)
    public List<Transaction> get10RecentTransaction() {
        List<Transaction> recent10Transaction;
        // if length of the list is smaller than 10
        if (this.transactionHistory.size() <= TOP10) {
            recent10Transaction = this.transactionHistory;
            return recent10Transaction;
        }
        // if transaction history length is bigger than 10
        else {
            int start = transactionHistory.size() - TOP10;
            recent10Transaction = this.transactionHistory.subList(start, (transactionHistory.size() + 1));
            return recent10Transaction;
        }
    }

    //endregion

    //region Helper Methods
    //
    // TODO: extract method, duplicate code with processCreditTransaction()
    // deposit money from account
    private void processCreditTransaction(Transaction transaction) {
        boolean amountCheck = transaction.checkTransactionAmountIsValid();
        if (amountCheck) {
            // Get current balance of credit account
            double balance = transaction.getCreditAccount().getBalance();
            // Add amount to account
            balance += transaction.getAmount();
            transaction.getCreditAccount().setBalance(balance);
            System.out.println("Your account balance is now € " + balance + ".");
        }
    }

    // withdraw money from account
    private void processDebitTransaction(Transaction transaction) {
        // Get current balance of debit account
        boolean amountCheck = transaction.checkTransactionAmountIsValid();
        if (amountCheck) {
            double balance = transaction.getDebitAccount().getBalance();
            // Check if balance has enough money in it
            if (transaction.getAmount() <= balance) {
                balance -= transaction.getAmount();
                transaction.getDebitAccount().setBalance(balance);
                System.out.println("Your account balance is now € " + balance + ".");
            } else {
                System.out.println("Insignificant balance! \n Withdraw canceled");
            }
        }
    }

    //endregion

    //region GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AbstractClient getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AbstractClient accountHolder) {
        this.accountHolder = accountHolder;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public Set<AbstractClient> getAuthorizedClients() {
        return authorizedClients;
    }

    public void setAuthorizedClients(Set<AbstractClient> authorizedClients) {
        this.authorizedClients = authorizedClients;
    }

    //endregion

    //region TOSTRING, HASH, EQUALS, COMPARE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", type=" + type +
                '}';
    }

    //endregion
}
