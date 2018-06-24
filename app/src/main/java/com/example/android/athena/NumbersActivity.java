package com.example.android.athena;

import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    int[] pics = {R.drawable.numbers_one, R.drawable.numbers_two, R.drawable.numbers_three, R.drawable.numbers_four, R.drawable.numbers_five};
    int quantity = 2;
    String[] words = {"One", "Two", "Three", "Four", "Five"};
    String[] german_words = {"Einz", "Zwei", "Drei", "Vier", "Funf"};
    int i = 0;
    int[] tracks = new int[5];
    int MAX_NUMBER_STREAMS = 5;
    SoundPool mySoundPool;
    boolean loaded = false;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        mySoundPool = new SoundPool(MAX_NUMBER_STREAMS, AudioManager.STREAM_MUSIC, 0);

        mySoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
/*
        tracks[0] = R.raw.einz;
        tracks[1] = R.raw.zwei;
        tracks[2] = R.raw.drei;
        tracks[3] = R.raw.vier;
        tracks[4] = R.raw.funf;
        tracks[6] = R.raw.one;
        tracks[7] = R.raw.two;
        tracks[8] = R.raw.three;
        tracks[9] = R.raw.four;
        tracks[10] = R.raw.five;

        for(int i=0;i<10;i++) {
            sound = mySoundPool.load(this, tracks[i], 1);
            Log.v("Sounds", Integer.toString(sound));
        }
        */
    }

    public void mommy(View view){

        display(german_words[i], Color.MAGENTA);
        mySoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);
    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));
        mySoundPool.play(i+7,1.0F, 1.0F,0,0,1.0F);
    }

    public void left(View view){
        ImageView image = (ImageView) findViewById(R.id.number);
        if(i > 0) {
            i = i - 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    public void right(View view){
        ImageView image = (ImageView) findViewById(R.id.number);
        if(i < 4) {
            i = i + 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
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