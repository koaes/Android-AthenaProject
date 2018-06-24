package com.example.android.athena;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.media.SoundPool.OnLoadCompleteListener;

import static com.example.android.athena.BackgroundMusicService.backgroundmediaPlayer;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this,BackgroundMusicService.class));

    }

    @Override
    protected void onPause(){
        Log.i("Music Update", "On Pause from Main");
        if(backgroundmediaPlayer!=null){
            backgroundmediaPlayer.pause();}
        super.onPause();


    }

    @Override
    protected void onResume() {
        super.onResume();
        //BackgroundMusic.resumeMusic();
        if(backgroundmediaPlayer!=null){
            backgroundmediaPlayer.start();}

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopService(new Intent(this,BackgroundMusicService.class));

    }

    public void openAnimal (View view){

        Intent i = new Intent(this, AnimalActivity.class);
        startActivity(i);
    }

    public void openColor (View view){
        Intent i = new Intent(this, ColorActivity.class);
        startActivity(i);
    }

    public void openAction (View view){
        Intent i = new Intent(this, VerbActivity.class);
        startActivity(i);
    }

    public void openNumbers (View view){
        Intent i = new Intent(this, NumbersActivity.class);
        startActivity(i);
    }

}


