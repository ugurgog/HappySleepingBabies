package uren.com.happysleepingbabies.GeneralUtils;


import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayUtil {

    Context context;
    int audioId;
    int itemVoiceId;
    MediaPlayer mediaPlayer;

    public AudioPlayUtil(Context context) {
        this.context = context;
        this.mediaPlayer = new MediaPlayer();
    }

    public void startMediaPlayer() {
        if (audioId != 0 && context != null) {
            try {
                stopSound();
                mediaPlayer = MediaPlayer.create(context, audioId);
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        playItemVoice();
                    }
                });
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        } else {
            playItemVoice();
        }
    }

    public  void playItemVoice() {
        try {
            if (itemVoiceId != 0 && context != null) {
                stopSound();
                mediaPlayer = MediaPlayer.create(context, itemVoiceId);
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                    }
                });
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    private void stopSound(){
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            try {
                mediaPlayer.stop();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayer = null;
            mediaPlayer = new MediaPlayer();
        }
    }

    public void setAndPlayAudioItems(int audioId, int itemVoiceId) {
        this.audioId = audioId;
        this.itemVoiceId = itemVoiceId;
        startMediaPlayer();
    }

    public void clearMediPlayer(){
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying())
                mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
