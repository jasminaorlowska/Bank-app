import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private CheckingAccount account;
    private SavingsAccount savingsAccount;
    private List<Transaction> transactionHistory = new ArrayList<>();
    private int numberOfLoans = 0;

    public User(String username, CheckingAccount account) {
        this.username = username;
        this.account = account;
    }

    public void setNumberOfLoans(int numberOfLoans) {
        this.numberOfLoans = numberOfLoans;
    }

    public String getUsername() {
        return username;
    }

    public boolean hasSavingsAccount() {
        return savingsAccount != null;
    }
    public void addSavingsAccount(SavingsAccount account) {
        if (!hasSavingsAccount()) {
            this.savingsAccount = account;
        } else {
            System.out.println("You already have a savings account.");
        }
    }

    public SavingsAccount getSavingsAccount() {
        if (hasSavingsAccount()) {
            return savingsAccount;
        }
        System.out.println("You don't have a saving account.");
        return savingsAccount;
    }
    public CheckingAccount getAccount() {
        return account;
    }

    public int getNumberOfLoans() {
        return numberOfLoans;
    }
    public void takeLoan(double amount){
        numberOfLoans++;
        getAccount().addMoney(amount);
        writeDownTransaction("Loan", amount, getAccount());
    }

    public void writeDownTransaction(String type, double amount, Account account) {
        Transaction transaction = new Transaction(type, amount, account);
        transactionHistory.add(transaction);
    }
    public void showTransactions() {
        if (transactionHistory.isEmpty()) {
            System.out.println("You don't have any transactions.");
        } else {
            System.out.println("---------------------\nTransactions history\n---------------------");

            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }


    @Override
    public String toString() {

        if (hasSavingsAccount()) {

            return "----------Username:---------- \n" + username +
                    "\n----------Checking account:----------\n" + account +
                    "\n----------SavingsAccount:----------\n" + savingsAccount;
        } else {
            return "----------Username:----------\n" + username +
                    "\n----------Checking account:----------\n" + account +
                    "\n----------No savings account.----------";
        }
    }
}
