public class SavingsAccount extends Account {

    private int number;
    private double balance;
    //trzeba stworzyć coś do interestu? do przegadania, to potem
    double interest;

    public SavingsAccount(double balance){
        super(balance);
    }

    @Override
    public String toString() {
        return "Type: Savings Account\n" + super.toString();
    }

}
