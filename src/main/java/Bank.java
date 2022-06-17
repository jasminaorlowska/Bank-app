import java.util.HashMap;

public class Bank {

    HashMap<User, String> loginInfo = new HashMap<User,String>();

    Bank(){

        User basicUser = new User("ProbnyUser",new CheckingAccount(555));
        basicUser.addSavingsAccount(new SavingsAccount(222.0));
        basicUser.getSavingsAccount().setOwner(basicUser);
        //basicUser.getAccount().setOwner(basicUser);

        User secondBasicUser = new User("ProbnyUser2", new CheckingAccount(1000));
        //secondBasicUser.getAccount().setOwner(secondBasicUser);

        User thirdBasicUser = new User("ProbnyUser3", new CheckingAccount(700));
        //secondBasicUser.getAccount().setOwner(secondBasicUser);

        loginInfo.put(basicUser, "haslo");
        loginInfo.put(secondBasicUser, "haslo");
        loginInfo.put(thirdBasicUser, "haslo");

    }

    public HashMap<User, String> getLoginInfo() {
        return loginInfo;
    }

    public User getUser(String userToGet) {
        for (User user : loginInfo.keySet()) {
            if (user.getUsername().equals(userToGet)) {
                return user;
            }
        } return null;
    }

    public User getUserByAccountNum(int accNumber){
        for (User user: loginInfo.keySet()){
            if (user.getAccount().getNumber() == accNumber || user.getSavingsAccount().getNumber() == accNumber){
                return user;}
        } return null;
    }


}
