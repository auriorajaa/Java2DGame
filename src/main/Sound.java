package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    Clip clip;
    URL soundUrl[] = new URL[30];

    public Sound() {
        soundUrl[0] = getClass().getResource("/res/sound/BlueBoyAdventure.wav");
        soundUrl[1] = getClass().getResource("/res/sound/coin.wav");
        soundUrl[2] = getClass().getResource("/res/sound/powerup.wav");
        soundUrl[3] = getClass().getResource("/res/sound/unlock.wav");
        soundUrl[4] = getClass().getResource("/res/sound/fanfare.wav");
        soundUrl[5] = getClass().getResource("/res/sound/hitmonster.wav");
        soundUrl[6] = getClass().getResource("/res/sound/receivedamage.wav");
        soundUrl[7] = getClass().getResource("/res/sound/swingweapon.wav");
        soundUrl[8] = getClass().getResource("/res/sound/levelup.wav");
        soundUrl[9] = getClass().getResource("/res/sound/cursor.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
