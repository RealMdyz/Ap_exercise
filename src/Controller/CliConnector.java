package Controller;
import MyProject.MyProject;

import java.util.Scanner;
import View.*;
public class CliConnector {
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username to sign in:");
        String username = scanner.next();
        scanner.nextLine();
        // sign in:
        if (username.equalsIgnoreCase("Student")) {

        }
        else if (username.equalsIgnoreCase("Admin")) {

        }
        else {
            init();
        }
    }
}
