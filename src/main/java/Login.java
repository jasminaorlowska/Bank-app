import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
public class Login {

    Scanner keyboard = new Scanner(System.in);

    private Bank bank;
    public Login(Bank bank){

        this.bank = bank;
    }

    boolean exit;


    public void runLogin() throws IOException {
        printHeader();
        while(!exit){
            printLogin();
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

    private void printLogin() {
        System.out.println("Select");
        System.out.println("1) To log in");
        System.out.println("2) To register");
        System.out.println("0) To exit");
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


    private void performAction(int choice) throws IOException {
        switch (choice){
            case 0:
                System.out.println("Goodbye.");
                System.exit(0);
                break;
            case 1:
                login();

                break;
            case 2:
                createUser();
                break;
            default:
                System.out.println("Error. Pick  number from 0 to 2.");
        }
    }

    protected void createUser() {

        Scanner scanner = new Scanner(System.in);

        String username = null, password = null;
        Double balance = null;
        boolean valid = false;

        while(!valid){

            boolean validData=false;

            while (!validData) {
                System.out.println("Enter your username: ");
                username = scanner.nextLine();
                if (username.length() < 5) {
                    System.out.println("Username needs to be at least 5 characters long.");
                } else  {validData=true;}
            }

            validData=false;

            while (!validData) {
            System.out.println("Enter your password: ");
            password = scanner.nextLine();
            if(password.length()<8){
                System.out.println("Password needs to be at least 8 characters long.");
                } else {validData=true;}
            }

            validData = false;
            while (!validData) {
            System.out.println("Enter your initial balance: ");
            try {
                balance = (Double.parseDouble(scanner.nextLine()));
            }
            catch(NumberFormatException e){
                System.out.println("Initial balance must be a number.");
            }
            if(balance < 1000){
                System.out.println("Initial balance must be at least 1000");
            }
            else{
                validData=true;
                valid = true;
            }
            }
        }


        if(valid) {
            CheckingAccount account = new CheckingAccount(balance);
            User user = new User(username, account);
            try {
                bank.addUser(user, password);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //bank.getLoginInfo().put(user, password);

            System.out.println("Creating an account.");
        }

    }


        private void login() throws IOException {

            String username, password;
            boolean logged = false;
            bank.readFromFile();

        System.out.println("Enter your username:");
        username = keyboard.nextLine();

        System.out.println("Enter your password:");
        password = keyboard.nextLine();

//        while(!logged){
//            bank.getLoginInfo().
//                    for(User user : bank.getLoginInfo().keySet()){
//                        if(user.getUsername().equals(username)){
//                            if(user.)
//                        }
//                    }
//        }



            while(!logged) {

//                Iterator it = bank.getLoginInfo().entrySet().iterator();
//
//                while (it.hasNext()) {
//                    Map.Entry<User, String> m = (Map.Entry) it.next();
//                    if (m.getKey().getUsername().equals(username)) {
//                        if(m.getValue().equals(password)){
//                            System.out.println("You've successfully logged in!");
//                            logged = true;
//                            break;
//                        }
//                        else{
//                            System.out.println("Password is incorrect. Try again.");
//                        }
//                    }
//
//
//                }
//                break;

                Iterator it = bank.forLogin.entrySet().iterator();

                while (it.hasNext()) {
                    Map.Entry<String, String> m = (Map.Entry) it.next();
                    if (m.getKey().equals(username)) {
                        if(m.getValue().equals(password)){
                            System.out.println("You've successfully logged in!");
                            logged = true;
                            break;
                        }
                        else{
                            System.out.println("Password is incorrect. Try again.");
                        }
                    }
                }
                break;

            }

//
        }











    }




