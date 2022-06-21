public interface IMenu {

    /* wprowadzenie depozytu **/
    private void makeDeposit(){
        double amount;
    }

    /* wypłacenie pieniędzy z konta **/
    private void makeWithdrawal(){
        double amount;
    }

    /* sprawdza czy dane użytkownika, któremu chcemy przelać pieniądze są poprawne **/
    private void sendMoneyTo(){

    }

    /* przelewy do konkretnego użytkownika **/
    private void sendMoney(User receiver){
        double amount;
    }

    /* pokazuje historię transakcji użytkownika **/
    private void showTransactions(){

    }

    /* pokazuje szczegóły konta oszczędnościowego, wyślwietla opcje **/
    private void mySavingsAccount(){
        int choice;
    }

    /* przelewa pieniądze z konta oszczędnościowego **/
    private void TransferMoneySavingsAccount(){
        double amount;
    }

    /* tworzy konto oszczędnościowe **/
    private void createSavingsAccount(){

    }

    /* pokazuje nazwę użytkownika **/
    private void displayAccount(){

    }

    /* sprawdza, czy użytkownik chce wziąć kredyt **/
    private void askToTakeLoan(){
        int maxLoan = checkLoan();

    }

    /* przypisuje kredyt **/
    private void takeLoan(int maxLoan){
        double amount;
    }

    /* sprawdza aktualny kredyt **/
    private int checkLoan(){
        double percentage = 1;
        int availableLoan;
        return -1;
    }

    /* zamyka aplikacje lub wylogowywuje **/
    private boolean exitOrLogout(){
        return false;
    }
}
