import java.io.*;
import java.util.ArrayList;

public class Bank {
    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void start(){
        users = deserializeUsers();
    }

    public boolean doLogin(String email, String password){
        for (User user : users){
            String checkedEmail = user.getEmail();

            if (email.equals(checkedEmail)){
                String checkedPassword = user.getPassword();

                if (password.equals(checkedPassword)){
                    return true;
                }
            }
        }
        return false;
    }

    public void doRegister(User user){
        users.add(user);
        serializeUsers(users);
    }

    public void serializeUsers(ArrayList<User> users){
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\DELL\\Desktop\\Users.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(users);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> deserializeUsers(){
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Users.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            ArrayList<User> users = (ArrayList<User>) ois.readObject();

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }
}
