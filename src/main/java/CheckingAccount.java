public class CheckingAccount extends Account{

        private int number;
        private double balance;

        public CheckingAccount(double balance) {
            super(balance);

        }


    @Override
        public String toString() {
            return "Type: Checking Account\n" + super.toString();
        }


}
