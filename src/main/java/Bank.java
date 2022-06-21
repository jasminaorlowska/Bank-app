import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Bank {

    private List<CheckingAccount> bankAccounts;
    private List<SavingsAccount> savingAccounts;
    private HashMap<User, String> bankInfo;



    public Bank() {
       this.bankAccounts = readBankAccountsCSV();
       this.savingAccounts = readSavingsAccounts();
       this.bankInfo = readBankInfoCSV();
    }

//    public void updatingDane() throws IOException, CsvException {
//        CSVReader daneReader = new CSVReader(new FileReader(new File("dane.csv")));
//        List<String[]> bankInfoUpdated = daneReader.readAll();
//
//    }
//
//    public void updatingAccounts() throws IOException, CsvException {
//        CSVReader kontoBankoweReader = new CSVReader(new FileReader(new File("kontaBankowe.csv")));
//        List<String[]> bankAccountsUpdated = kontoBankoweReader.readAll();
//
//    }
//
//    public void updatingSavings() throws IOException, CsvException {
//        CSVReader kontoOszczednoscioweReader = new CSVReader(new FileReader(new File("kontaOszczednościowe.csv")));
//        List<String[]> savingAccountsUpdated = kontoOszczednoscioweReader.readAll();
//
//    }

//    public HashMap<User, String> getbankInfo() {
//        return bankInfo;
//    }

    public User getUser (String username){
        for (User user : bankInfo.keySet()){
            if (username.equals(user.getUsername())){
                return user;
            }
        } return null;
    }
    public List<SavingsAccount> getSavingAccounts(){return savingAccounts;}
    public void addUser(User user, String password)  {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("dane.csv", true));
            bw.write(user.getUsername() + "," + password + "," + user.getAccount().getNumber() + ",null,0" );
            bw.newLine();
            bw.close();
        } catch(IOException ioe){
            System.out.println("Aborting. Something went wrong while writing to a file.");
        }
        bankAccounts.add(user.getAccount());
        bankInfo.put(user,password);
        addAccount(user.getAccount());
        }
    public void addAccount (Account account){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("kontaBankowe.csv", true));
            bw.write(account.getNumber() + "," + account.getOwner() + "," + account.getBalance());
            bw.newLine();
            bw.close();
        } catch(IOException ioe){
            System.out.println("Aborting. Something went wrong while writing to a file.");
        }
    }

    //funkcja która tworzy konto na podstawie zczytywanego Stringa
    private CheckingAccount createAccount(String[] data){
        int number = Integer.parseInt(data[0]);
        String owner = data[1];
        double balance = Double.parseDouble(data[2]);
        CheckingAccount account = new CheckingAccount(balance);
        account.setOwner(owner);
        account.setNumber(number);
        return account;
    }
    private SavingsAccount createSavingAccount(String[] data){
        int number = Integer.parseInt(data[0]);
        double balance = Double.parseDouble(data[1]);
        SavingsAccount account = new SavingsAccount(balance);
        account.setNumber(number);
        return account;
    }

    //funkcja która tworzy usera na podstawie zczytywanego Stringa
    private User createUser(String[] data){
        String username = data[0];
        int numberBankAcc = Integer.parseInt(data[2]);
        int numberLoans = Integer.parseInt(data[4]);
        User user = new User(username, matchAccountWithUser(username, numberBankAcc));
        if (!data[3].equals("null")) {
            int numberSavingBankAcc = Integer.parseInt(data[3]);
            SavingsAccount usersSavingAcc = matchSavingsAccountWithUser(numberSavingBankAcc);
            user.addSavingsAccount(usersSavingAcc);
        }
        user.setNumberOfLoans(numberLoans);
        return user;
    }

    //funkcja która przypisuje userowi konta
    private CheckingAccount matchAccountWithUser(String username, int number){
        for (CheckingAccount account : bankAccounts){
            if (account.getOwner().equals(username)){
                if (account.getNumber() == number){
                    return account;}
            }
        } return new CheckingAccount(4000);
    }
    private SavingsAccount  matchSavingsAccountWithUser(int number){
        for (SavingsAccount account : savingAccounts){
            if (account.getNumber() == number){
                    return account;}
        } return null;
    }

    //dwie funkcje które tworzą listę i hashmapę na podstawie dwóch plików CSV
    private List<CheckingAccount> readBankAccountsCSV(){
        List<CheckingAccount> bankAccounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("kontaBankowe.csv")))
        {
            String line = br.readLine();
            while (line!=null){
                String[] data = line.split(",");
                CheckingAccount account = createAccount(data);
                bankAccounts.add(account);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    return bankAccounts;
    }
    private List<SavingsAccount> readSavingsAccounts(){
        List<SavingsAccount> savingsAccounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("kontaOszczednosciowe.csv"));)
        {
            String line = br.readLine();
            while (line!=null){
                String[] data = line.split(",");
                SavingsAccount account = createSavingAccount(data);
                savingsAccounts.add(account);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return savingsAccounts;
    }
    private HashMap<User, String> readBankInfoCSV(){

        HashMap<User, String> bankInfo = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("dane.csv")))
        {
            String line = br.readLine();
            while (line!=null){
                String[] data = line.split(",");
                User user = createUser(data);
                bankInfo.put(user, data[1]);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
        return bankInfo;
    }


    //function that compares the values in CSV data file.
    public boolean checkBank(int column, String infoToCheck) {
            try(
                    BufferedReader br = new BufferedReader(new FileReader("dane.csv"));
                    CSVParser parser = CSVFormat.DEFAULT.parse(br)
            ) {
                for(CSVRecord record : parser) {
                    if (record.get(column).equals(infoToCheck)) {return true;}
                }
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
            return false;
    }


}
