public class User {
    private String username;
    private String password;
    private CheckingAccount account;
    private SavingsAccount accountSaving;

    public void User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
