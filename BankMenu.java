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
        } else if (answer == 0){
            System.exit(0);
        } else {
            System.out.println("check your number");
        }
    }

    public void showBankMenu(){
        System.out.println("Select one: \n 1. Account \n 2. Balance \n 3. Create Loan \n " +
                "4. Create Card \n 5. Loan Data 6. Exit");
        int answer = sc.nextInt();
        switch (answer){
            case 1 : bank.myAccount(); break;
            case 2 : bank.myBalance(); break;
            case 3 : createLoan(); break;
            case 4 : createCard(); break;
            case 5 : bank.myLoanData(); break;
            case 6 : bank.exit(); break;
            default:
                System.out.println("Please, check your number"); break;
        }

    }

    private void showLogin(){
        System.out.println("Please, enter your email:");
        String email = sc.next();
        System.out.println("Great! Please, enter your password");
        String password = sc.next();

        if (bank.doLogin(email, password)){
            showBankMenu();
        }
        else {
            System.out.println("Incorrect password or email. Please try again");
            showStartMenu();
        }

    }

    private void showRegister(){
        System.out.println("Please, enter your name:");
        String name = sc.next();
        System.out.println("Enter your surname:");
        String surname = sc.next();
        System.out.println("Enter your Birth Date (dd.MM.yyyy):");
        String birthDate1 = sc.next();

        System.out.println("Enter your gender (M - male, F - female):");
        boolean gender = true;
        String genderString = sc.next();

        if (genderString.equals("F") || genderString.equals("female")){
            gender = false;
        } else if (!genderString.equals("M") && !genderString.equals("male")){
            System.out.println("Sorry, incorrect gender, try again later");
            showStartMenu();
        }

        System.out.println("Enter your email:");
        String email = sc.next();
        System.out.println("Enter your password:");
        String password = sc.next();

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate = null;
        try {
            birthDate = formatter.parse(birthDate1);
        } catch (ParseException e) {
            System.out.println("Please, check birth date format");
            showStartMenu();
        }
        User user = new User(name, surname, birthDate, gender, email, password);

        bank.doRegister(user);
    }

    public void createCard(){
        System.out.println("Enter your Balance (00.00):");
        double balance = sc.nextDouble();
        System.out.println("Enter your Card Number:");
        String cardNumber = sc.next();
        System.out.println("Enter your Expiration Date (MM / yy):");
        String expirationDate1 = sc.next();
        System.out.println("Enter your cvv:");
        int cvv = sc.nextInt();

        DateFormat formatter = new SimpleDateFormat("MM / yy");
        Date expirationDate = null;
        try {
            expirationDate = formatter.parse(expirationDate1);
        } catch (ParseException e) {
            System.out.println("Please, check Expiration Date format");
            showStartMenu();
        }

        DebitCard debitCard = new DebitCard(balance, cardNumber ,expirationDate, cvv);
        bank.createCard(debitCard);
    }

    public void createLoan(){
        System.out.println("Enter your Registration Date (dd.MM.yyyy):");
        String registrationDate1 = sc.next();

        System.out.println("Enter your Sum:");
        double sum = sc.nextDouble();

        System.out.println("Enter your Interest Rate:");
        double interestRate = sc.nextDouble();

        System.out.println("Enter your Credit Term:");
        int creditTerm = sc.nextInt();

        System.out.println("Enter your Monthly Payment:");
        double monthlyPayment = sc.nextDouble();

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date registrationDate = null;
        try {
            registrationDate = formatter.parse(registrationDate1);
        } catch (ParseException e) {
            System.out.println("Please, check Registration Date format");
            showBankMenu();
        }

        Loan loan = new Loan(registrationDate, sum, interestRate, creditTerm, monthlyPayment);
        bank.createLoan(loan);
    }

}
