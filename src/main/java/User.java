public class User {

    private String username;
    private String password;
    private CheckingAccount account;
    private SavingsAccount accountSaving;

    public User(String username, CheckingAccount account) {
        this.username = username;
        this.account = account;
    }

}
