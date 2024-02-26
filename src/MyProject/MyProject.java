package MyProject;
import Controller.*;

public class MyProject {
    public MyProject(){
        init();
    }
    public static Sttuf sttuf;
    public void init(){
        sttuf = new Sttuf();
        CliConnector cliConnector = new CliConnector(sttuf);
        cliConnector.init();
    }


}
