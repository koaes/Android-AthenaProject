package com.example.android.athena;

/**
 * Created by koaes on 2/9/18.
 */

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;

public class BackgroundMusic {

    private static MediaPlayer backgroundmediaPlayer = null;


    public static void play(Context context){


            backgroundmediaPlayer = MediaPlayer.create(context, R.raw.music);


            backgroundmediaPlayer.start();

    }


    public static void pauseMusic(){
        if (backgroundmediaPlayer.isPlaying()){
            backgroundmediaPlayer.pause();
        }
    }

    protected static void resumeMusic() {
        backgroundmediaPlayer.start();
    }

    protected static void destroymusic(){
        backgroundmediaPlayer.release();
    }

}
