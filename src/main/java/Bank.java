import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    HashMap<User, String> loginInfo = new HashMap<User,String>();
    ArrayList<Account> bankAccounts = new ArrayList<Account>();

    Bank(){

        //loginInfo.put(new User("user1", "User1Password");
    }
    protected HashMap <User, String> getLoginInfo(){
        return loginInfo;
    }

    protected ArrayList <Account> getAccounts(){
        return bankAccounts;
    }

}
