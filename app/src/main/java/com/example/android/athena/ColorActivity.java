package com.example.android.athena;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayerbackground;
    int quantity = 2;
    int[] pics = {R.drawable.blue, R.drawable.green, R.drawable.pink, R.drawable.purple, R.drawable.red,};
    String[] words = {"Blue", "Green", "Pink", "Purple", "Red"};
    String[] german_words = {"Blau", "Grune", "Pink", "Lilac", "Rot"};
    int i = 0;
    int[] tracks = new int[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mediaPlayer = MediaPlayer.create(this,R.raw.quack);
        mediaPlayerbackground = MediaPlayer.create(this,R.raw.music);
        mediaPlayerbackground.start();
    }


    @Override
    protected void onPause(){
        if (mediaPlayerbackground.isPlaying()){
            mediaPlayerbackground.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayerbackground.start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mediaPlayerbackground.release();
    }

// ======================================

    public void mommy(View view){

        display(german_words[i], Color.MAGENTA);
        tracks[0] = R.raw.blau;
        tracks[1] = R.raw.grune;
        tracks[2] = R.raw.pink;
        tracks[3] = R.raw.lilac;
        tracks[4] = R.raw.red;

        mediaPlayer = MediaPlayer.create(this, tracks[i]);
        mediaPlayer.start();
    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));
        tracks[0] = R.raw.blue;
        tracks[1] = R.raw.green;
        tracks[2] = R.raw.pink1;
        tracks[3] = R.raw.purple;
        tracks[4] = R.raw.red;

        mediaPlayer = MediaPlayer.create(this, tracks[i]);
        mediaPlayer.start();
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
        if(i < 3) {
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





}
