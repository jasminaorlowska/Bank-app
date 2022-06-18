import jdk.jshell.EvalException;

import java.util.Scanner;

public class Menu {

    Scanner keyboard = new Scanner(System.in);
    boolean exit;

    private User user;

    private Bank bank;
    //Jak już monika zajmie się bankiem.
    public Menu(User user, Bank bank){
        this.user = user;
        this.bank = bank;
    }

    //do wyjebania potem zamiana z tym co na górze.
//        public Menu(User user){
//        this.user = user;
//    }

    public void runMenu(){
        while(!exit){
            printMenu();
            int choice = Login.getInput(keyboard, 8);
            performActionMenu(choice);
        }
    }

    private void printMenu(){

        System.out.println("Select:");
        System.out.println("1) Make Deposit  2) Make withdrawal  3) Send money  4) Show history");
        System.out.println("5) Display account info  6) Savings Account 7) Get a loan  0) Exit");

    }

    private void performActionMenu(int choice) {
        switch (choice){
            case 0:
                exitOrLogout();
                break;
            case 1:
                makeDeposit();
                break;
            case 2:
                makeWithdrawal();
                break;
            case 3:
//                sendMoneyTo();
                break;
            case 4:
                showTransactions();
                break;
            case 5:
                displayAccount();
                break;
            case 6:
                mySavingsAccount();
                break;
            case 7:
                askToTakeLoan();
                break;
            default:
                System.out.println("Error. Pick a number from 0 to 6.");
        }

    }


    //1
    private void makeDeposit() {
        Account pickedAccount = pickAccount();
        double amount = askForAmount();
        pickedAccount.deposit(amount);
        user.writeDownTransaction("deposit", amount,pickedAccount);
    }

    //2
    private Account pickAccount(){
        String account;
        Account pickedAccount = user.getAccount();
        boolean valid = false;
        if (user.hasSavingsAccount()){
            while(!valid){
                System.out.println("Pick an account: savings/checking:");
                account = keyboard.nextLine();
                if (account.equalsIgnoreCase("checking") || account.equalsIgnoreCase("savings")){
                    if (account.equalsIgnoreCase("savings")){
                        pickedAccount = user.getSavingsAccount();
                    }
                    valid=true;
                }
                else {System.out.println("Incorrect input.");}
            }
        } return pickedAccount;

    }
    private Double askForAmount() {

        boolean incorrectDouble = true;

        System.out.println("Enter the amount of money:");

        while (incorrectDouble) {
            try {
                double amount = new Scanner(System.in).nextDouble();
                if (amount<=0){
                    System.out.println("You can't type negative number. Type again.");continue;
                }
                incorrectDouble = false;
                return amount;
            } catch (Exception e) {
                System.out.println("Type a double. Use commas.");
            }
        }
        return 0.0;
    }
    private void makeWithdrawal(){
        Account pickedAccount = pickAccount();
        double amount = askForAmount();
        pickedAccount.withdraw(amount);
        user.writeDownTransaction("withdrawal", amount,pickedAccount);
    }

    //3
//    public void sendMoneyTo() {
//        boolean valid = false;
//        System.out.println("Would you like to send money using username or account number: [username/number]: ");
//        while (!valid) {
//            String answer = new Scanner(System.in).nextLine();
//            if (answer.equalsIgnoreCase("username")){
//                sendMoneyToByUsername();
//                valid = true;
//            } if (answer.equalsIgnoreCase("number")){
//                sendMoneyToByNumber();
//                valid = true;
//            }
//            else {
//                System.out.println("Incorrect input. Try again.");
//            }
//        }
//    }
//    private void sendMoneyToByNumber() {
//        User user = getUserByAccNumber();
//        if (user !=null) {
//            sendMoney(user);
//        }
//    }

//    public void sendMoney(User user) {
//
//        System.out.println("How much money would you like to sent?: ");
//        boolean valid=false;
//        while (!valid){
//        double amount = askForAmount();
//        if (amount > user.getAccount().getBalance()){
//            System.out.println("You don't have enough money. Type again.");
//        } else{
//            bank.getUser(user.getUsername()).getAccount().addMoney(amount);
//            user.getAccount().takeMoney(amount);
//            System.out.println("Money has been successfully sent.");
//            valid = true;}
//    }


//    }

//    private User getUserByAccNumber() {
//        User user = bank.getUserByAccountNum(typeAccNumber());
//        if (user != null){
//            return user;
//        } else {
//            System.out.println("No such account number in our database.");
//        }
//        return null;
//    }

    private int typeAccNumber() {
            int accnumber=-1;
            boolean valid = false;
        do{
            try {
                accnumber = new Scanner(System.in).nextInt();
                valid = true;
                return accnumber;
            } catch (Exception e) {
                System.out.println("Type a number.");
                //new Scanner(System.in).nextInt();
            };
    } while (!valid);
        return accnumber;
    }

//    private void sendMoneyToByUsername() {
//        String username = new Scanner(System.in).nextLine();
//        User user = bank.getUser(username);
//        sendMoney(user);
//    }

    //4
    private void showTransactions() {
        user.showTransactions();
    }

    //5
    private void mySavingsAccount() {
        if(user.hasSavingsAccount()){
            System.out.println("You already have a saving account. Here are the details.");
            System.out.println(user.getSavingsAccount().toString());
        } else {
            System.out.println("You don't have a saving account. Do you want to create one? [yes/no]: ");
            boolean valid = false;
            while (!valid) {
                String answer = new Scanner(System.in).nextLine();
                if (answer.equalsIgnoreCase("yes")) {
                    createSavingsAccount();
                    valid = true;
                } if (answer.equalsIgnoreCase("no")){
                    valid = true;
                } else {
                    System.out.println("Incorrect input.");
                }
                }
            }
        }
    private void createSavingsAccount() {

    }

    //6
    private void displayAccount() {
        System.out.println(user.toString());
    }

    //7
    private void askToTakeLoan() {

        if (user.getNumberOfLoans() > 2) {
            System.out.println("You can't take a loan. You have a maximum number of loans.");
        } else {

            int maxLoan = checkLoan();

            System.out.println("Do you want to take a loan?: [yes/no]: ");
            boolean valid = false;

            while (!valid) {

                String answer = new Scanner(System.in).nextLine();

                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                    if (answer.equalsIgnoreCase("yes")){
                        takeLoan(maxLoan);
                    }
                        valid = true;
                }
                else {
                    System.out.println("Incorrect input.");
                }
            }
        }
    }
    private void takeLoan(int maxLoan){
        System.out.println("You're taking a loan.");

        while (true){

            double amount;
            amount = askForAmount();

            if (amount > maxLoan) {
                System.out.println("You can't take this loan. Your maximum loan is " + maxLoan + ". ");
                System.out.print("Type again.");
            }
            else {
                    user.takeLoan(amount);
                    System.out.println("You have just taken a loan. Current balance: " + user.getAccount().getBalance());
                    break;
            }
        }
    }
    private int checkLoan(){
        double balance = user.getAccount().getBalance();
        double percentage = 1;
        int availableLoan;
        if (user.getNumberOfLoans() ==1) {percentage = .75;}
        if(balance < 20000){
            if (balance < 10000){
                availableLoan = (int)(balance * percentage * 1.3);
                System.out.println("Available loan: " +availableLoan);return availableLoan;
            } else {availableLoan = (int)(balance * percentage * 1.5);
                System.out.println("Available loan: " +availableLoan);return availableLoan;}
        } if (balance> 2000){availableLoan = (int)(balance * percentage * 1.75);
            System.out.println("Available loan: " +availableLoan);return availableLoan;}
        return -1;
    }

    //0
    private void exitOrLogout() {
        System.out.println("Do you want to exit the system or log into a different account? (exit/logout): ");
        String answer = keyboard.nextLine();
        if (answer.equalsIgnoreCase("exit") || answer.equalsIgnoreCase("logout")) {
            if (answer.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye, " + user.getUsername());
            } else {
                System.out.println("Logging out");
            }
        } else {
            System.out.println("Wrong input");
        }
    }











}
