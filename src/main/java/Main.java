public class Main {
    public static void main (String[] args){

        Bank bank = new Bank();
        Login login = new Login();
        login.runLogin();



//        CheckingAccount basicAccount = new CheckingAccount(123.0);
//        User basicUser = new User("ProbnyUser",basicAccount);
//        basicUser.addSavingsAccount(new SavingsAccount(222.0));
//        System.out.println(basicUser.haveSavingsAccount());
//
//        Menu menu = new Menu(basicUser);
//        menu.makeDeposit();
//        System.out.println(basicUser.getSavingsAccount().getBalance());
    }
}
