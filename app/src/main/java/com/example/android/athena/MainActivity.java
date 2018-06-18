package com.example.android.athena;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BackgroundMusic.play(this);
    }

    @Override
    protected void onPause(){
        Log.i("Music Update", "On Pause from Main");
        BackgroundMusic.pauseMusic();
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
        BackgroundMusic.resumeMusic();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        BackgroundMusic.destroymusic();
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


}


