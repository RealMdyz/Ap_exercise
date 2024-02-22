package MyProject;
import Controller.*;

public class MyProject {
    public MyProject(){
        init();
    }
    public Sttuf sttuf = new Sttuf();
    public void init(){
        CliConnector cliConnector = new CliConnector(sttuf);
        cliConnector.init();
    }
}
