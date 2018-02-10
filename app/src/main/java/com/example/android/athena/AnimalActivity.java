package com.example.android.athena;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    String[] german_sounds = new String[] {"R.raw.hund", "ente", "pferd", "hahn", "fisch", "kuh"};
    int i = 0;
    int pos = 0;
    int[] tracks = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        BackgroundMusic.resumeMusic();

        //mediaPlayerbackground = (MediaPlayer)getLastNonConfigurationInstance();

        //if (mediaPlayerbackground == null){
            //mediaPlayerbackground = MediaPlayer.create(this,R.raw.music);
            //mediaPlayerbackground.start();
       // }

        //mediaPlayer = MediaPlayer.create(this,R.raw.quack);



    }

    @Override
    protected void onPause(){
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

// ======================================

    public void mommy(View view){

        display(german_words[i], Color.MAGENTA);


        tracks[0] = R.raw.hund;
        tracks[1] = R.raw.ente;
        tracks[2] = R.raw.pferd;
        tracks[3] = R.raw.hahn;
        tracks[4] = R.raw.fisch;
        tracks[5] = R.raw.kuh;


        mediaPlayer = MediaPlayer.create(this, tracks[i]);
        mediaPlayer.start();
    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));

        tracks[0] = R.raw.dog;
        tracks[1] = R.raw.duck;
        tracks[2] = R.raw.horse;
        tracks[3] = R.raw.rooster;
        tracks[4] = R.raw.fish;
        tracks[5] = R.raw.cow;


        mediaPlayer = MediaPlayer.create(this, tracks[i]);
        mediaPlayer.start();
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
