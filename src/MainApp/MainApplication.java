package MainApp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainApplication {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        new LoginFrame(users);

    }
}
