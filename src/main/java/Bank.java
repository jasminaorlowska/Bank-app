import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    protected HashMap<User, String> getLoginInfo(){
        return loginInfo;
    }

    public void addUser(User user, String password) throws FileNotFoundException {
        loginInfo.put(user, password);

        File csvDane = new File("dane.csv");
        PrintWriter out = new PrintWriter(csvDane);

        Iterator it = getLoginInfo().entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<User, String> m = (Map.Entry) it.next();
            out.println(m.getKey().getUsername() + " " + m.getValue());


        }


        out.close();



}}
