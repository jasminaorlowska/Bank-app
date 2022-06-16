import java.util.Scanner;

public class Login {

    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit; 
    
    public void runLogin(){
        printHeader();
        while(!exit){
            printLogin();
            int choice = getInput();
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

    private int getInput() {
        int choice = -1;
        do {
            try {
                choice = Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only.");
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid selection. No such number");
            }
        }
        while (choice>4||choice<0);
        return choice;
    }


    private void performAction(int choice) {
        switch (choice){
            case 0:
                System.out.println("Goodbye.");
                System.exit(0);
                break;
            case 1:
                //create an account;
                break;
            case 2:
                //login
                break;
            default:
                System.out.println("ups error");
        }
    }
}
