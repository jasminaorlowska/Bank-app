public class User {

    private String username;
//    protected String password;
    private CheckingAccount account;
    private SavingsAccount savingsAccount;
    private Transaction[] history;

    public User(String username, CheckingAccount account) {
        this.username = username;
        this.account = account;
    }

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
        this.savingsAccount = account;
    }

    public SavingsAccount getSavingsAccount(){
        return savingsAccount;
    }

    public CheckingAccount getAccount(){
        return account;
    }

//    public int getAccNumber(){
//        return 0;
//    }



}
