import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

public class Bank {

    HashMap<User, String> loginInfo = new HashMap<User,String>();
    HashMap<String, String> forLogin = new HashMap<>();


    public Bank() throws IOException {
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

    File csvDane = new File("dane.csv");
    PrintWriter out;

    {
        try {
            out = new PrintWriter(csvDane);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user, String password) throws IOException {

        loginInfo.put(user, password);

        Iterator it = getLoginInfo().entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<User, String> m = (Map.Entry) it.next();
            out.println(m.getKey().getUsername() + "," + m.getValue() + "," + m.getKey().getAccount().getNumber());
        }

        out.close();

//        Reader in = new FileReader("dane.csv");
//        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
//
//        for (CSVRecord record : records){
//            System.out.println(record.get(0) +","+ record.get(1) +","+ record.get(2));
//            forLogin.put(record.get(0), record.get(1));
//
//        }
//        System.out.println(forLogin);

   }

//    public void addUser(User user, String password){
//        try {
//            BufferedWriter bw = new BufferedWriter(fw);
//            PrintWriter pw = new PrintWriter(bw);
//            pw.println( user.getUsername() + "," +password + "," + user.getAccount().getNumber() + ",");
//            pw.flush();
//            pw.close();
//        }
//        catch (Exception e){
//            System.out.println("Record not saved.");
//        }
//        //loginInfo.put(user, password);
//    }


    public void readFromFile() throws IOException {

        Reader in = new FileReader("dane.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

        for (CSVRecord record : records){
            forLogin.put(record.get(0), record.get(1));

        }
        }

}
