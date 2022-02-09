import java.io.*;
import java.util.ArrayList;

public class Bank {
    private ArrayList<User> users;

    private final BankMenu bankMenu = new BankMenu(this);
    private User user;

    private static final String PATH = "C:\\Users\\DELL\\Desktop\\Users.dat";

    public void start(){
        users = deserializeUsers();
        System.out.println();
        bankMenu.showStartMenu();

    }

    public boolean doLogin(String email, String password){
        for (User user : users){

            if (email.equals(user.getEmail()) && password.equals(user.getPassword())){
                this.user = user;
                return true;
            }
        }
        return false;
    }

    public void doRegister(User user){
        users.add(user);
        serializeUsers(users);
        bankMenu.showStartMenu();
    }


    public void serializeUsers(ArrayList<User> users){
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(users);

            oos.close();
        } catch (IOException e) {
            System.out.println("Sorry, can not find file");
        }
    }

    public ArrayList<User> deserializeUsers() {
        File file = new File(PATH);

        if (file.exists() && !file.isDirectory()){
            try {
                FileInputStream fis = new FileInputStream(PATH);
                ObjectInputStream ois = new ObjectInputStream(fis);

                users = (ArrayList<User>) ois.readObject();
                System.out.println("User's list:");
                for (User user : users){
                    System.out.println(user.getName() + " " +user.getSurname());
                }

                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Sorry, can not find file or file is empty");
                e.printStackTrace();
            }
            return users;
        } else {
            try {
                if (file.createNewFile()){
                    users = new ArrayList<>();
                    serializeUsers(users);
                    return users;
                } else {
                    throw new RuntimeException("Sorry, can't create file");
                }
            } catch (IOException e) {
                throw new RuntimeException("Sorry, can't create file");
            }
        }

    }

    public void myAccount(){
        System.out.println(user);
        bankMenu.showBankMenu();
    }

    public void myBalance(){
        for (DebitCard card : user.getCards()){
            System.out.println("Card number: " + card.getCardNumber() + "\n" +
                    "Balance: " + card.getBalance());
        }

        bankMenu.showBankMenu();
    }

    public void myLoanData(){
        System.out.println(user.getLoans());
        bankMenu.showBankMenu();
    }

    public void createCard(DebitCard debitCard){
        user.getCards().add(debitCard);
        serializeUsers(users);
        bankMenu.showBankMenu();
    }

    public void createLoan(Loan loan){
        user.getLoans().add(loan);
        serializeUsers(users);
        bankMenu.showBankMenu();
    }

    public void exit(){
        System.out.println("Goodbye");
        this.user = null;
        bankMenu.showStartMenu();
    }


}
