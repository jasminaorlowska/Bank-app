import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    HashMap<User, String> loginInfo = new HashMap<User,String>();

    Bank(){
        CheckingAccount account = new CheckingAccount(253526);
        CheckingAccount account2 = new CheckingAccount(25526);
        CheckingAccount account3 = new CheckingAccount(2526);
        loginInfo.put(new User("user1", account), "haslo1");
        loginInfo.put(new User("user2", account2), "haslo2");
        loginInfo.put(new User("user3", account3), "haslo3");

    }
    protected HashMap <User, String> getLoginInfo(){
        return loginInfo;
    }

    public void addUser(User user, String password){
        loginInfo.put(user, password);
    }



}
