import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BankMenu {
    private Bank bank;

    public BankMenu (Bank bank){
        this.bank = bank;
    }

    Scanner sc = new Scanner(System.in);

    public void showStartMenu(){
        System.out.println("Select one: \n 1. Login \n 2. Register \n 0. Exit");
        int answer = sc.nextInt();
        if (answer == 1){
            showLogin();
        } else if (answer == 2){
            showRegister();
        } else {
            System.exit(0);
        }
    }

    public void showBankMenu(){
        System.out.println("Select one: \n 1. Login \n 2. Register \n 0. Exit");
    }

    private void showLogin(){
        System.out.println("Please, enter your email:");
        String email = sc.next();
        System.out.println("Great! Please, enter your password");
        String password = sc.next();
        bank.doLogin(email,password);

    }

    private void showRegister(){
        System.out.println("Please, enter your name:");
        String name = sc.next();
        System.out.println("Enter your surname:");
        String surname = sc.next();
        System.out.println("Enter your Birth Date (dd.MM.yyyy):");
        String birthDate1 = sc.next();
        System.out.println("Enter your gender:");
        boolean gender = sc.nextBoolean();
        System.out.println("Enter your email:");
        String email = sc.next();
        System.out.println("Enter your password:");
        String password = sc.next();

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate = null;
        try {
            birthDate = formatter.parse(birthDate1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(name, surname, birthDate, gender, email, password);
    }

}
