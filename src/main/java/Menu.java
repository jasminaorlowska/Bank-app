import java.util.Scanner;

public class Menu {

    Scanner keyboard = new Scanner(System.in);
    boolean exit;

    private User user;

    //private Bank bank;
    //Jak już monika zajmie się bankiem.
//    public Menu(User user, Bank bank){
//        this.user = user;
//        this.bank = bank;
//    }

    //do wyjebania potem zamiana z tym co na górze.
        public Menu(User user){
        this.user = user;
    }

    public void runMenu(){
        while(!exit){
            printMenu();
            int choice = Login.getInput(keyboard, 7);
            performActionMenu(choice);
        }
    }

    private void performActionMenu(int choice) {
        switch (choice){
            case 0:
                System.out.println("Do you want to exit the system or log into a different account? (exit/logout): ");
                String answer = keyboard.nextLine();
                if (answer.equalsIgnoreCase("exit") || answer.equalsIgnoreCase("logout")){
                    if (answer.equalsIgnoreCase("exit")){System.out.println("Goodbye, " + user.getUsername());}
                    else {
                        System.out.println("Logging out");
                    }
                } else {
                    System.out.println("Wrong input");
                }
                break;
            case 1:
                makeDeposit();
                break;
            case 2:
                makeWithdrawal();
                break;
            case 3:
                //sendMoneyTo();
                break;
            case 4:
                showTransactions();
                break;
            case 5:
                //displayAccount();
                break;
            case 6:
                //mySavingsAccount();
                break;
            default:
                System.out.println("Error. Pick a number from 0 to 6.");
        }

    }

    private void sendMoneyTo(int accNumber) {
//            double amount = askForAmount();
//            receiver = getReceiver();

    }

    public void showTransactions() {
            user.showTransactions();
    }

    private Account pickAccount(){
        String account;
        Account pickedAccount = user.getAccount();
        boolean valid = false;
        if (user.haveSavingsAccount()){
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
                incorrectDouble = false;
                return amount;
            } catch (Exception e) {
                System.out.println("Type a double. Use commas.");
            }
        }
        return 0.0;
    }


    public void makeDeposit() {
        Account pickedAccount = pickAccount();
        double amount = askForAmount();
        pickedAccount.deposit(amount);
        user.writeDownTransaction("deposit", amount,pickedAccount);
    }

    public void makeWithdrawal(){
        Account pickedAccount = pickAccount();
        double amount = askForAmount();
        pickedAccount.withdraw(amount);
        user.writeDownTransaction("withdrawal", amount,pickedAccount);
    }


    public void printMenu(){

        System.out.println("Select");
        System.out.println("1) Make Deposit");
        System.out.println("2) Make withdrawal");
        System.out.println("3) Send money");
        System.out.println("4) Show history");
        System.out.println("5) Display account info");
        System.out.println("6) My Saving Account");
        System.out.println("0) Exit");

    }


}
