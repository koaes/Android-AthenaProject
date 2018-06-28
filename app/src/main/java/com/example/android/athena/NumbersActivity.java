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

import java.util.ArrayList;

import static com.example.android.athena.BackgroundMusicService.backgroundmediaPlayer;

public class NumbersActivity extends AppCompatActivity {

    int[] pics = {R.drawable.numbers_one, R.drawable.numbers_two, R.drawable.numbers_three, R.drawable.numbers_four, R.drawable.numbers_five, R.drawable.numbers_six, R.drawable.numbers_seven, R.drawable.numbers_eight, R.drawable.numbers_nine, R.drawable.numbers_ten};
    int quantity = 2;
    String[] words = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
    String[] german_words = {"Einz", "Zwei", "Drei", "Vier", "Funf", "Sechs", "Seben", "Acht", "Neun", "Zain"};
    int i = 0;
    ArrayList<Integer> englishTrack = new ArrayList<Integer>();
    ArrayList<Integer> germanTrack = new ArrayList<Integer>();
    int MAX_NUMBER_STREAMS = 10;
    SoundPool englishSoundPool;
    SoundPool germanSoundPool;
    boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        englishSoundPool = new SoundPool(MAX_NUMBER_STREAMS, AudioManager.STREAM_MUSIC, 0);
        englishSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        germanSoundPool = new SoundPool(MAX_NUMBER_STREAMS, AudioManager.STREAM_MUSIC, 0);
        germanSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        germanTrack.add(R.raw.numbers_einz);
        germanTrack.add(R.raw.numbers_zwei);
        germanTrack.add(R.raw.numbers_drei);
        germanTrack.add(R.raw.numbers_vier);
        germanTrack.add(R.raw.numbers_funf);
        germanTrack.add(R.raw.numbers_sechs);
        germanTrack.add(R.raw.numbers_seben);
        germanTrack.add(R.raw.numbers_acht);
        germanTrack.add(R.raw.numbers_neun);
        germanTrack.add(R.raw.numbers_zain);

        englishTrack.add(R.raw.numbers_one);
        englishTrack.add(R.raw.numbers_two);
        englishTrack.add(R.raw.numbers_three);
        englishTrack.add(R.raw.numbers_four);
        englishTrack.add(R.raw.numbers_five);
        englishTrack.add(R.raw.numbers_six);
        englishTrack.add(R.raw.numbers_seven);
        englishTrack.add(R.raw.numbers_eight);
        englishTrack.add(R.raw.numbers_nine);
        englishTrack.add(R.raw.numbers_ten);

        for(int i=0;i<englishTrack.size();i++) {
            englishSoundPool.load(this, englishTrack.get(i), 1);
         }

        for(int i=0;i<germanTrack.size();i++) {
            germanSoundPool.load(this, germanTrack.get(i), 1);
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
        germanSoundPool.play(i+1,1.5F, 1.5F,0,0,1.0F);
    }

    public void daddy(View view){

        display(words[i], Color.parseColor("#29b6f6"));
        englishSoundPool.play(i+1,1.5F, 1.5F,0,0,1.0F);
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
        if(i < englishTrack.size()-1) {
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