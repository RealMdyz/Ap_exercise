package MyProject;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MyProjectData {
    private static MyProjectData projectData;

    protected BufferedImage Ball;


    private MyProjectData() {
        addImages();
    }

    private void addImages(){
        try {
            String pathBackground = "src/Ball1.jpg";
            File fileBackground = new File(pathBackground);
            Ball = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MyProjectData getProjectData() {
        if (projectData == null) {
            projectData = new MyProjectData();
        }
        return projectData;
    }

    public BufferedImage getBall() {
        return Ball;
    }

    public void setBall(BufferedImage ball) {
        Ball = ball;
    }
}
