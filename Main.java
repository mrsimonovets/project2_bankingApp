import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();

        User user1 = new User("Ivan", "Ivanov", new Date(516511135553L),true, "ivan.ivanov@gmail.com", "123456789qwert");
        System.out.println(user1);

    }
}
