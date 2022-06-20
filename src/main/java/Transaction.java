import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {

    private String time;
    private String type;
    private double amount;
    private int receiverAccNum;

    public  Transaction(String type,  double amount, Account account){
        String currTime;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        currTime = dtf.format(now);
        this.time = currTime;
        this.type = type;
        this.amount = amount;
        this.receiverAccNum = account.getNumber();
    }

    @Override
    public String toString(){
        return "-----------------------------------------\n" +
                "Amount: " + amount + "\nType: " + type +
                "\nReceiver: " + receiverAccNum +  "\nTime of transaction: " + time
                +  "\n-----------------------------------------";
    }


}
