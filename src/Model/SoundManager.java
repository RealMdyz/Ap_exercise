package Model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundManager {
    private Clip clip;
    private boolean isSoundOn;

    public SoundManager() {
        this.isSoundOn = true; // Default to sound on
    }

    public void playBackgroundMusic() {
        try {
            File soundFile = new File("src/BackgroundMusic.wav"); // Provide the path to your sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public void stopBackgroundMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void toggleSound() {
        if (isSoundOn) {
            stopBackgroundMusic();
            isSoundOn = false;
        } else {
            playBackgroundMusic();
            isSoundOn = true;
        }
    }

    public boolean isSoundOn() {
        return isSoundOn;
    }
}
