package utils;

import controllers.BaseController;
import javafx.scene.media.AudioClip;

import java.util.HashMap;

public class SoundUtils {
    public static HashMap<String, AudioClip> hashMap = new HashMap<>();

    public static void playSound(String soundFile) {
        if (!hashMap.containsKey(soundFile)) {

            AudioClip media = new AudioClip(BaseController.class.getResource(soundFile).toExternalForm());
            hashMap.put(soundFile, media);
        }

        hashMap.get(soundFile).play();
    }
}
