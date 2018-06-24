package com.example.android.athena;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AnimalActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    //MediaPlayer mediaPlayerbackground;

    int quantity = 2;
    int[] pics = {R.drawable.dog, R.drawable.duck, R.drawable.horse, R.drawable.rooster, R.drawable.fish, R.drawable.cow};
    String[] words = {"Dog", "Duck", "Horse", "Rooster", "Fish", "Cow"};
    String[] german_words = {"Der Hund", "Die Ente", "Das Pferd", "Der Hahn", "Der Fisch", "Die Kuh"};
    int i = 0;
    int pos = 0;
    int[] tracks = new int[12];
    int MAX_NUMBER_STREAMS = 5;
    SoundPool mySoundPool;
    boolean loaded = false;
    int sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        mySoundPool = new SoundPool(MAX_NUMBER_STREAMS, AudioManager.STREAM_MUSIC, 0);

        mySoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        tracks[0] = R.raw.hund;
        tracks[1] = R.raw.ente;
        tracks[2] = R.raw.pferd;
        tracks[3] = R.raw.hahn;
        tracks[4] = R.raw.fisch;
        tracks[5] = R.raw.kuh;
        tracks[6] = R.raw.dog;
        tracks[7] = R.raw.duck;
        tracks[8] = R.raw.horse;
        tracks[9] = R.raw.rooster;
        tracks[10] = R.raw.fish;
        tracks[11] = R.raw.cow;

        for(int i=0;i<12;i++) {
            sound = mySoundPool.load(this, tracks[i], 1);
            Log.v("Sounds", Integer.toString(sound));
        }

    }

    @Override
    protected void onPause(){
        //BackgroundMusic.pauseMusic();
        super.onPause();
        //mySoundPool.release();
        //mySoundPool = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //BackgroundMusic.resumeMusic();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //BackgroundMusic.destroymusic();
    }

// ======================================

    public void mommy(View view){

        display(german_words[i], Color.MAGENTA);

        //tracks[0] = R.raw.hund;
        //tracks[1] = R.raw.ente;
        //tracks[2] = R.raw.pferd;
        //tracks[3] = R.raw.hahn;
        //tracks[4] = R.raw.fisch;
        //tracks[5] = R.raw.kuh;


        //mediaPlayer = MediaPlayer.create(this, tracks[i]);
        //mediaPlayer.start();


        mySoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);
    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));




        //mediaPlayer = MediaPlayer.create(this, tracks[i]);
        //mediaPlayer.start();

        mySoundPool.play(i+7,1.0F, 1.0F,0,0,1.0F);
    }

    public void left(View view){
        ImageView image = (ImageView) findViewById(R.id.animal);
        if(i > 0) {
            i = i - 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void right(View view){
        ImageView image = (ImageView) findViewById(R.id.animal);
        if(i < 5) {
            i = i + 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void quack(View view){

        mediaPlayer.start();

    }

    // ==============================================

    public void display(String animalWord, int textColor) {
        TextView quantityTextView = (TextView) findViewById(R.id.word_text);
        quantityTextView.setTextColor(textColor);
        quantityTextView.setText("" + animalWord);
    }

    public int getQuantity() {
        return quantity;
    }
}
