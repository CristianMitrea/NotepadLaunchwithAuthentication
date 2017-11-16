package fasttrackit.ro;

import java.util.Scanner;
import java.io.IOException;


public class LoginApp {

    public static void main(String[] args) {

        User[] users = new User[4];


        users[0] = new User();
        users[0].user = "ionel";
        users[0].password = "a";


        users[1] = new User();
        users[1].user = "maria";
        users[1].password = "b";

        users[2] = new User();
        users[2].user = "ioana";
        users[2].password = "c";

        // Username and password keyboard input
       String u = citireNume("Username:");
       String p = citireNume("Password:");
       int counterTries = 1;
       boolean accountLocked = false;

        while (login(users, u, p) != true) {
            if (counterTries < 3){
                u = citireNume("Username:");
                p = citireNume("Password:");
                counterTries++;
            } else {
                accountLocked = true;
                break;
            }
        }

        // Login completed
        if (accountLocked == false) {
            System.out.println("Login successfully completed ");
            try {
                Process proc = Runtime.getRuntime().exec("notepad.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("The system has been locked!");
        }

    }

    // login method checks username and password, returns true if match found

    public static boolean login(User[] a, String u, String p) {

       boolean found = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null)
                if (u.equalsIgnoreCase(a[i].user) && p.equalsIgnoreCase(a[i].password)) {
                    System.out.println("Found matching credentials");
                    found = true;
                    break;
                }
        }
        return found;
    }


    public static String citireNume(String label) {
        System.out.print(label);
        Scanner kbdInput = new Scanner(System.in);
        String readValue = kbdInput.nextLine();
        return readValue;
    }

}