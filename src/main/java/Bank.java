import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.*;

public class Bank {

    HashMap<String, String> forLogin = new HashMap<>();

    public void addUser(User user, String password)  {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("dane.csv", true));
            bw.write(user.getUsername() + "," + password + "," + user.getAccount().getNumber() + ",");
            bw.newLine();
            bw.close();
        } catch(IOException ioe){
            System.out.println("Aborting. Soreczka.");
        }
        }



    public void readFromFile() throws IOException {

        Reader in = new FileReader("dane.csv");
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

        for (CSVRecord record : records){
            forLogin.put(record.get(0), record.get(1));

        }
        }

}
