import java.util.ArrayList; //do wyjebania później;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        //Bank bank = new Bank(); //tworzymy hashlist z uzytkownikami-haslem i liste z bankaccounts

        //Login login = new Login(bank);
        //login.runLogin();

        ArrayList<User> userList = new ArrayList<User>();

        User basicUser = new User("ProbnyUser",new CheckingAccount(555));
        basicUser.addSavingsAccount(new SavingsAccount(222.0));
        basicUser.getSavingsAccount().setOwner(basicUser);
        basicUser.getAccount().setOwner(basicUser);

        User secondBasicUser = new User("ProbnyUser2", new CheckingAccount(1000));
        secondBasicUser.getAccount().setOwner(secondBasicUser);


        userList.add(basicUser);
        userList.add(basicUser);

        Menu menu = new Menu(basicUser);




    }
}
