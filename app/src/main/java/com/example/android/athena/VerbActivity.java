package com.example.android.athena;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VerbActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayerbackground;
    int quantity = 2;
    int[] pics = {R.drawable.paint, R.drawable.pour, R.drawable.ride, R.drawable.sleep, R.drawable.swim, R.drawable.walk, R.drawable.write};
    String[] words = {"Paint", "Pour", "Ride", "Sleep", "Swim", "Walk", "Write"};
    String[] german_words = {"Malen", "Eingiesen", "Reiten", "Schlafen", "Schwimmen", "Laufen", "Schrieben"};
    int i = 0;
    int[] tracks = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb);
        mediaPlayer = MediaPlayer.create(this, R.raw.quack);
        mediaPlayerbackground = MediaPlayer.create(this, R.raw.music);
        mediaPlayerbackground.start();
    }

    @Override
    protected void onPause() {
        if (mediaPlayerbackground.isPlaying()) {
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
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayerbackground.release();
    }

// ======================================

    public void mommy(View view) {

        display(german_words[i], Color.MAGENTA);

        tracks[0] = R.raw.malen;
        tracks[1] = R.raw.eingiesen;
        tracks[2] = R.raw.reiten;
        tracks[3] = R.raw.schlafen;
        tracks[4] = R.raw.schwimmen;
        tracks[5] = R.raw.laufen;
        tracks[6] = R.raw.schreiben;


        mediaPlayer = MediaPlayer.create(this, tracks[i]);
        mediaPlayer.start();
    }

    public void daddy(View view) {

        display(words[i], Color.parseColor("#29b6f6"));

        tracks[0] = R.raw.paint;
        tracks[1] = R.raw.pour;
        tracks[2] = R.raw.ride;
        tracks[3] = R.raw.sleep;
        tracks[4] = R.raw.swim;
        tracks[5] = R.raw.walk;
        tracks[6] = R.raw.write;


        mediaPlayer = MediaPlayer.create(this, tracks[i]);
        mediaPlayer.start();
    }

    public void left(View view) {
        ImageView image = (ImageView) findViewById(R.id.verb);
        if (i > 0) {
            i = i - 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void right(View view) {
        ImageView image = (ImageView) findViewById(R.id.verb);
        if (i < 7) {
            i = i + 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void quack(View view) {

        mediaPlayer.start();

    }

    // ==============================================

    public void display(String animalWord, int textColor) {
        TextView quantityTextView = (TextView) findViewById(R.id.word_text);
        quantityTextView.setTextColor(textColor);
        quantityTextView.setText("" + animalWord);

    }
}
