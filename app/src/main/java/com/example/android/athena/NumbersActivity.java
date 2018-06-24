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

import static com.example.android.athena.BackgroundMusicService.backgroundmediaPlayer;

public class NumbersActivity extends AppCompatActivity {

    int[] pics = {R.drawable.numbers_one, R.drawable.numbers_two, R.drawable.numbers_three, R.drawable.numbers_four, R.drawable.numbers_five, R.drawable.numbers_six, R.drawable.numbers_seven, R.drawable.numbers_eight, R.drawable.numbers_nine, R.drawable.numbers_ten};
    int quantity = 2;
    String[] words = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] german_words = {"Einz", "Zwei", "Drei", "Vier", "Funf", "Sechs", "Seben", "Acht", "Neun", "Zain"};
    int i = 0;
    int[] tracks = new int[20];
    int MAX_NUMBER_STREAMS = 10;
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

        tracks[0] = R.raw.numbers_einz;
        tracks[1] = R.raw.numbers_zwei;
        tracks[2] = R.raw.numbers_drei;
        tracks[3] = R.raw.numbers_vier;
        tracks[4] = R.raw.numbers_funf;
        tracks[5] = R.raw.numbers_sechs;
        tracks[6] = R.raw.numbers_seben;
        tracks[7] = R.raw.numbers_acht;
        tracks[8] = R.raw.numbers_neun;
        tracks[9] = R.raw.numbers_zain;
        tracks[10] = R.raw.numbers_one;
        tracks[11] = R.raw.numbers_two;
        tracks[12] = R.raw.numbers_three;
        tracks[13] = R.raw.numbers_four;
        tracks[14] = R.raw.numbers_five;
        tracks[15] = R.raw.numbers_six;
        tracks[16] = R.raw.numbers_seven;
        tracks[17] = R.raw.numbers_eight;
        tracks[18] = R.raw.numbers_nine;
        tracks[19] = R.raw.numbers_ten;

        for(int i=0;i<20;i++) {
            sound = mySoundPool.load(this, tracks[i], 1);
            Log.v("Sounds", Integer.toString(sound));
        }

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

    public void mommy(View view){

        display(german_words[i], Color.MAGENTA);
        mySoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);
    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));
        mySoundPool.play(i+11,1.0F, 1.0F,0,0,1.0F);
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
        if(i < 9) {
            i = i + 1;
            image.setImageResource(pics[i]);
            Log.v("Numbers", Integer.toString(i));
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