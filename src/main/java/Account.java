import java.util.Random;

public class Account {

    private int number;
    private double balance;
    private Transaction[] history;

    public Account(double balance){
        this.balance = balance;
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        this.number = number;

    }

}
