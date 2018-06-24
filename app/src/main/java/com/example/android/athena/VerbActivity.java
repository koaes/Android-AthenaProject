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

public class VerbActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayerbackground;
    int quantity = 2;
    int[] pics = {R.drawable.paint, R.drawable.pour, R.drawable.ride, R.drawable.sleep, R.drawable.swim, R.drawable.walk, R.drawable.write};
    String[] words = {"Paint", "Pour", "Ride", "Sleep", "Swim", "Walk", "Write"};
    String[] german_words = {"Malen", "Eingiesen", "Reiten", "Schlafen", "Schwimmen", "Laufen", "Schrieben"};
    int i = 0;
    int[] tracks = new int[14];
    int MAX_NUMBER_STREAMS = 5;
    SoundPool mySoundPool;
    boolean loaded = false;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verb);

        mySoundPool = new SoundPool(MAX_NUMBER_STREAMS, AudioManager.STREAM_MUSIC, 0);

        mySoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        tracks[0] = R.raw.malen;
        tracks[1] = R.raw.eingiesen;
        tracks[2] = R.raw.reiten;
        tracks[3] = R.raw.schlafen;
        tracks[4] = R.raw.schwimmen;
        tracks[5] = R.raw.laufen;
        tracks[6] = R.raw.schreiben;
        tracks[7] = R.raw.paint;
        tracks[8] = R.raw.pour;
        tracks[9] = R.raw.ride;
        tracks[10] = R.raw.sleep;
        tracks[11] = R.raw.swim;
        tracks[12] = R.raw.walk;
        tracks[13] = R.raw.write;

        for(int i=0;i<14;i++) {
            sound = mySoundPool.load(this, tracks[i], 1);
            Log.v("Sounds", Integer.toString(sound));
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        //mySoundPool.release();
        //mySoundPool = null;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

// ======================================

    public void mommy(View view) {

        display(german_words[i], Color.MAGENTA);
        mySoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);
    }

    public void daddy(View view) {

        display(words[i], Color.parseColor("#29b6f6"));

        mySoundPool.play(i+8,1.0F, 1.0F,0,0,1.0F);
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
        if (i < 6) {
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
