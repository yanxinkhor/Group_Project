package MainApp;

public class NormalUser extends User {

    public NormalUser(String username, String email, String phoneNumber, String password) {
        super(username, email, phoneNumber, password,false);
    }
}
