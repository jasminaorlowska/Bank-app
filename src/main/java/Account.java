import java.util.Random;

abstract class Account {

    private int number;
    private double balance;
    private User owner;

    public Account(double balance){
        this.balance = balance;
        Random rnd = new Random();
        int number = rnd.nextInt(999,9999 );
        this.number = number;
    }

    protected void setOwner(User user){
      this.owner = user;
    }

    public int getNumber(){
        return number;
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw(double amount){
        if (amount>balance){
            System.out.println("You don't have enough cash");
        } else{
        balance = balance - amount;
        System.out.println("You have successfully withdrawn " + amount + "$.");
        System.out.println("You have " + getBalance() + " $ left on your account." );
        }
    };

    public void deposit(double amount){
        balance =+ balance+amount;
        System.out.println("You have successfully deposited " + amount + "$.");
        System.out.println("You have " + getBalance() + " $ left on your account." );
    };

    public void addMoney(double amount){
        balance = balance + amount;
    }
    public void takeMoney (double amount) {balance = balance - amount;}

    @Override
    public String toString() {
        return "Number: " + number +
                "\nBalance: " + balance;
    }

}
