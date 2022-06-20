public class SavingsAccount extends Account {

    private int number;
    private double balance;

    private double interest;

    public SavingsAccount(double balance){
        super(balance);
        setInterest();
    }

    private void setInterest(){
        if(getBalance() > 5000){
            if(getBalance()>20000){
            this.interest = getBalance()*.01;
        } else {
                this.interest = getBalance()*.005;
            }
        }
        else{
            this.interest = getBalance()*.001;
        }
    }

    public double getInterest() {
        return interest;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        setInterest();
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        setInterest();
    }

    @Override
    public void takeMoney(double amount) {
        super.takeMoney(amount);
        setInterest();
    }
    @Override
    public void addMoney(double amount) {
        super.addMoney(amount);
        setInterest();
    }


    @Override
    public String toString() {
        return "Type: Savings Account\n" + super.toString() + "\nInterest: " + getInterest();
    }

}
