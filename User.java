import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    private String name;
    private String surname;

    private Date birthDate;
    private boolean gender;

    private String email;
    private String password;

    private List<Loan> loans = new ArrayList<>();
    private List<DebitCard> cards = new ArrayList<>();

    public User(String name, String surname, Date birthDate, boolean gender, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<DebitCard> getCards() {
        return cards;
    }

    public void setCards(List<DebitCard> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        String gender1;

        if (gender) gender1 = "male";
        else gender1 = "female";

        String s1 = "First name: " + name + "\n" +
                "Last name: " + surname + "\n" +
                "Birth date: " + sdf.format(birthDate) + "\n" +
                "Gender: " + gender1 + "\n" +
                "Email: " + email + "\n" +
                "Password: " + password + "\n";


        StringBuilder s2 = new StringBuilder("Loan List: \n");
        loans.stream().forEach(loan -> {
            s2.append(loan).append(" ");
        });

        StringBuilder s3 = new StringBuilder("Card List: \n");
        cards.stream().forEach(debitCard -> {
            s3.append(debitCard).append(" ");
        });


        return s1+s2+s3;
    }
}
