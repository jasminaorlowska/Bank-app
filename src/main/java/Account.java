import java.util.Random;

abstract class Account {

    private int number;
    private double balance;

    public Account(double balance){
        this.balance = balance;
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        this.number = number;
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
        balance =- balance - amount;}
    };

    public void deposit(double amount){
        balance =+ balance+amount;
    };

//    public void sendMoneyTo(int accountNumber, double amount){
//        for (Account account : bankAccounts){
//
//        }
//    };

}
