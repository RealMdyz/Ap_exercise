package Controller;
import View.*;

import java.util.Scanner;
import View.*;
public class CliConnector {

    public Sttuf sttuf;

    public CliConnector(Sttuf sttuf){
        this.sttuf = sttuf;
    }
    public void init(){
        Scanner scanner = new Scanner(System.in);
        Student student = new Student(sttuf);
        Admin admin = new Admin(sttuf);
        System.out.println("Are you a Admin or a Student!?");
        String username = scanner.next();
        scanner.nextLine();
        if (username.equals("Student")) {
            student.init();
        }
        else if (username.equals("Admin")) {
            admin.init();
        }
        else {
            init();
        }


    }
}
