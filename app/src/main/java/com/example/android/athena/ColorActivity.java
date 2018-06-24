package com.example.android.athena;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayerbackground;
    int quantity = 2;
    int[] pics = {R.drawable.colors_blue, R.drawable.colors_green, R.drawable.colors_pink, R.drawable.colors_purple, R.drawable.colors_red,};
    String[] words = {"Blue", "Green", "Pink", "Purple", "Red"};
    String[] german_words = {"Blau", "Grune", "Pink", "Lilac", "Rot"};
    int i = 0;
    int[] tracks = new int[10];
    int MAX_NUMBER_STREAMS = 5;
    SoundPool mySoundPool;
    boolean loaded = false;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mySoundPool = new SoundPool(MAX_NUMBER_STREAMS, AudioManager.STREAM_MUSIC, 0);

        mySoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        tracks[0] = R.raw.blau;
        tracks[1] = R.raw.grune;
        tracks[2] = R.raw.pink;
        tracks[3] = R.raw.lilac;
        tracks[4] = R.raw.red;
        tracks[5] = R.raw.blue;
        tracks[6] = R.raw.green;
        tracks[7] = R.raw.pink1;
        tracks[8] = R.raw.purple;
        tracks[9] = R.raw.red;

        for(int i=0;i<10;i++) {
            sound = mySoundPool.load(this, tracks[i], 1);
            Log.v("Sounds", Integer.toString(sound));
        }


    }


    @Override
    protected void onPause(){
        super.onPause();
        //mySoundPool.release();
        //mySoundPool = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //mediaPlayerbackground.start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //mediaPlayerbackground.release();
    }

// ======================================

    public void mommy(View view){

        display(german_words[i], Color.MAGENTA);

        mySoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);

    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));

        mySoundPool.play(i+6,1.0F, 1.0F,0,0,1.0F);
    }

    public void left(View view){
        ImageView image = (ImageView) findViewById(R.id.color);
        if(i > 0) {
            i = i - 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void right(View view){
        ImageView image = (ImageView) findViewById(R.id.color);
        if(i < 4) {
            i = i + 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void quack(View view){

        //mediaPlayer.start();

    }

    // ==============================================

    public void display(String animalWord, int textColor) {
        TextView quantityTextView = (TextView) findViewById(R.id.word_text);
        quantityTextView.setTextColor(textColor);
        quantityTextView.setText("" + animalWord);
    }





}
