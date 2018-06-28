package com.example.android.athena;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class BackgroundMusicService extends Service {
    public static MediaPlayer backgroundmediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        backgroundmediaPlayer = MediaPlayer.create(this, R.raw.music);
        backgroundmediaPlayer.setVolume(0.5f, 0.5f);
        backgroundmediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        backgroundmediaPlayer.stop();
    }
}
