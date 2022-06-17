import java.util.Scanner;
import java.util.Map;
public class Login {

    Scanner keyboard = new Scanner(System.in);

    //Bank bank = new Bank(); przeniesione do maina

    private Bank bank;
    public Login(Bank bank){
        this.bank = bank;
    }

    boolean exit;


    public void runLogin(){
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


    private void performAction(int choice) {
        switch (choice){
            case 0:
                System.out.println("Goodbye.");
                System.exit(0);
                break;
            case 1:
                login();
                //break;
            case 2:
                createUser();
                break;
            default:
                System.out.println("Error. Pick  number from 0 to 2.");
        }
    }

    private void login() {

        String username, password;
        boolean logged = false;

        System.out.println("Enter your username:");
        //warunki na username
        username = keyboard.nextLine();

        System.out.println("Enter your password:");
        //warunki na password
        password = keyboard.nextLine();

        //????
        while(!logged) {
            for (Map.Entry<User, String> entry : bank.getLoginInfo().entrySet()) {
                if (entry.getKey().getUsername() == username) {
                    if (entry.getValue() == password) {
                        System.out.println("Login successful");
                        logged=true;
                        //Tutaj ważna sprawa bo otwieramy nową funkcję już to menu
                    }
                    System.out.println("Wrong password");
                }
            }
        }





    }

    private void createUser() {

        Scanner scanner = new Scanner(System.in);

        String username, password;
        Double balance; //inicjalna kwata aby otworzyc konto

        //warunki na stworzenie konta
        //boolean valid=false;
        //while (!valid){

            System.out.println("Enter your username:");
            //warunki na username
            username = scanner.nextLine();

            System.out.println("Enter your password:");
            //warunki na password
            password = scanner.nextLine();

            System.out.println("Enter initial balance:");
            // warunek na initial balance ??powyzej 2000?
            balance = scanner.nextDouble();

        //}

        CheckingAccount account = new CheckingAccount(balance);
        User user = new User(username, account);
        bank.addUser(user, password, account);

        //System.out.println("creating an account");
        //System.out.println(bank.getAccounts());

    }
}
