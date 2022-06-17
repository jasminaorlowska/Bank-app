import java.util.ArrayList;

public class User {

    private String username;
    private CheckingAccount account;
    private SavingsAccount savingsAccount;
    private ArrayList<Transaction> transactionHistory = new ArrayList<Transaction>();

    public User(String username, CheckingAccount account) {
        this.username = username;
        this.account = account;}


    public String getUsername() {
        return username;
    }

    public boolean haveSavingsAccount(){
        if (savingsAccount != null){return true;}
        else{
            return false;
        }
    }

    public void addSavingsAccount(SavingsAccount account){
        if(!haveSavingsAccount()){
        this.savingsAccount = account;}
        else {
            System.out.println("You already have a savings account.");
        }
    }

    public SavingsAccount getSavingsAccount(){
        if (haveSavingsAccount()){ return savingsAccount;}
        System.out.println("You don't have a saving account.");
        return savingsAccount;
    }
    public CheckingAccount getAccount(){
        return account;
    }

    public void writeDownTransaction(String type,  double amount, Account account){
        Transaction transaction = new Transaction(type, amount, account);
        transactionHistory.add(transaction);
    }

    public void showTransactions(){
        System.out.println("---------------------\nTransactions history\n---------------------");
        for(Transaction transaction : transactionHistory){
            System.out.println(transaction);
        }
    }



}
