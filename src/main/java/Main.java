import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {

        Bank bank = new Bank();

        Login login = new Login(bank);
        login.runlogin();

    }
}
