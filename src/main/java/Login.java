import java.util.Scanner;
public class Login implements Run{

    Scanner keyboard = new Scanner(System.in);

    private Bank bank;
    public Login(Bank bank){

        this.bank = bank;
    }
    boolean exit;
    String username;


    public void run() {
        printHeader();
        while(!exit){
            print();
            int choice = getInput(keyboard, 4);
            performAction(choice);
        }
    }

    private void printHeader() {
        System.out.println("+---------------------------+");
        System.out.println("|      Welcome to Bank      |");
        System.out.println("|         Java App          |");
        System.out.println("+---------------------------+");
    }

    private void print() {
        System.out.println("\nSelect:\n");
        System.out.println("1) To log in");
        System.out.println("2) To register");
        System.out.println("0) To exit\n");
    }

    public static int getInput(Scanner keyboard, int options) {
        int choice = -1;
        do {
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only.");
            }
            if (choice < 0 || choice > options) {
                System.out.println("Invalid selection. No such number");
            }
        }
        while (choice>options||choice<0);
        return choice;
    }

    private void performAction(int choice) {
        switch (choice){
            case 0:
                System.out.println("Goodbye.");
                System.exit(0);
                break;
            case 1:
                this.username = login();
                break;
            case 2:
                createUser();
                break;
            default:
                System.out.println("Error. Pick  number from 0 to 2.");
        }
    }

    private void createUser() {

        Scanner scanner = new Scanner(System.in);

        String username = null, password = null;
        Double balance = null;
        boolean valid = false;

        while (!valid) {

            boolean validData = false;

            while (!validData) {

                System.out.println("Enter your username: ");
                username = scanner.nextLine();
                if (username.length() < 5  || bank.checkBank(0, username)) {
                    if (username.length() < 5){
                    System.out.println("Username needs to be at least 7 characters long.");
                    }
                    else{
                        System.out.println("User already exists.");
                    }
                }
                else {
                    validData = true;
                }
            }

            validData = false;

            while (!validData) {
                System.out.println("Enter your password: ");
                password = scanner.nextLine();
                if (password.length() < 7) {
                    System.out.println("Password needs to be at least 7 characters long.");
                } else {
                    validData = true;
                }
            }

                validData = false;

                while (!validData) {
                System.out.println("Enter your initial balance: ");
                try {
                    balance = (Double.parseDouble(scanner.nextLine()));
                } catch (NumberFormatException e) {
                    System.out.println("Initial balance must be a number.");
                }
                if (balance < 1000) {
                    System.out.println("Initial balance must be at least 1000");
                } else {
                    validData = true;
                    }
                }
            valid = true;
            }

                CheckingAccount account = new CheckingAccount(balance);
                User user = new User(username, account);
                account.setOwner(user.getUsername());
                bank.addUser(user, password);
                System.out.println("Registration successful.");
    }

    private String login (){

        String username, password;
        boolean logged = false;

        while (!logged) {

            System.out.println("Enter your username:");
            username = keyboard.nextLine();
            if (username.equalsIgnoreCase("exit")){break;}
            System.out.println("Enter your password:");
            password = keyboard.nextLine();
            if (password.equalsIgnoreCase("exit")){break;}

            if (bank.checkBank(0, username)){
                if (bank.checkBank(1, password)){
                    System.out.println("You've successfully logged in!");
                    Menu menu = new Menu(bank.getUser(username), bank);
                    menu.run();
                    logged=true;
                } else {
                    System.out.println("Incorrect password. Try again. To exit type 'exit'.");
                }
            }
            else {System.out.println("Incorrect username. Try again. To exit type 'exit'.");}
        }
        return null;
    }

    }





