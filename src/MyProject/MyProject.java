package MyProject;
import Controller.*;
public class MyProject {

    public MyProject(){
        init();
    }
    public void init(){
        CliConnector cliConnector = new CliConnector();
        cliConnector.init();
    }
}
