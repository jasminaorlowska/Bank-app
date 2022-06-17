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

    public void addUser(User user, String password, CheckingAccount account){
//        loginInfo.put(user, password);
//        bankAccounts.add(account);
        }

    public void addAccount(Account account){
        bankAccounts.add(account);
    }

//    public int getAccount(int number){
//        for (Account account : bankAccounts){
//            if (account.getNumber() == number){
//                return 0;
//            }
//        }
//
//    }

}
