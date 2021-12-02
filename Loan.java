import java.text.SimpleDateFormat;
import java.util.Date;

public class Loan {
    private Date registrationDate;
    private double sum;
    private double interestRate;
    private int creditTerm;
    private double monthlyPayment;


    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getCreditTerm() {
        return creditTerm;
    }

    public void setCreditTerm(int creditTerm) {
        this.creditTerm = creditTerm;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return "Registration date: " + sdf.format(registrationDate) + "\n" +
                "Sum: " + sum + "\n" +
                "Interest rate: " + interestRate + "\n" +
                "Credit term: " + creditTerm + "\n" +
                "Monthly payment: " + monthlyPayment;
    }

    public Loan(Date registrationDate, double sum) {
        this.registrationDate = registrationDate;
        this.sum = sum;
    }
}
