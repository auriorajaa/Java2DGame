package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
    Clip clip;
    URL soundUrl[] = new URL[30];
    FloatControl fc;
    int volumeScale = 3;
    float volume;

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
        soundUrl[10] = getClass().getResource("/res/sound/burning.wav");
        soundUrl[11] = getClass().getResource("/res/sound/cuttree.wav");
        soundUrl[12] = getClass().getResource("/res/sound/gameover.wav");
        soundUrl[13] = getClass().getResource("/res/sound/stairs.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
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

    public void checkVolume() {
        switch (volumeScale) {
            case 0:
                volume = -80f;
                break;
            case 1:
                volume = -20f;
                break;
            case 2:
                volume = -12f;
                break;
            case 3:
                volume = -5f;
                break;
            case 4:
                volume = 1f;
                break;
            case 5:
                volume = 6f;
                break;
        }

        fc.setValue(volume);
    }
}
