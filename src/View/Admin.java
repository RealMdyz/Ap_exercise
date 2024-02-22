package View;

import Controller.CliConnector;
import Controller.Sttuf;

import java.util.Scanner;

public class Admin {
    String PassWord, Name;
    private CliConnector cliConnector;
    public Sttuf sttuf;

    public Admin(Sttuf sttuf){
        this.sttuf = sttuf;
    }
    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("you have entered as a Admin\n what do you want to do:\n 0- back\n 1- see lessons\n 2- add a lesson \n 3- remove a lesson \n 4- increase Capacity of a lesson \n 5- see the student of a lesson \n 6- remove a student from a lesson \n 7- add a student to a lesson");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {

        } else if (choice == 2) {

        } else if (choice == 0) {
            cliConnector.init();
        }
        else if (choice == 3){

        }
        else if(choice == 4){

        }
        else if(choice == 5){

        }
        else if(choice == 6){

        }
        else if(choice == 7){

        }
        else {
            init();
        }
    }
}
