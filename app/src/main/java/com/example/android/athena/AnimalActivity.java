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

import java.util.ArrayList;

public class AnimalActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    //MediaPlayer mediaPlayerbackground;

    int quantity = 2;
    int[] pics = {R.drawable.dog, R.drawable.duck, R.drawable.horse, R.drawable.rooster, R.drawable.fish,
            R.drawable.cow, R.drawable.animal_bee, R.drawable.animal_buffalo, R.drawable.animal_bunny, R.drawable.animal_dolphin,
            R.drawable.animal_dragon, R.drawable.animal_owl, R.drawable.animal_spider};
    String[] words = {"Dog", "Duck", "Horse", "Rooster", "Fish", "Cow", "Bee", "Buffalo", "Bunny", "Dolphin", "Dragon", "Owl", "Spider"};
    String[] german_words = {"Der Hund", "Die Ente", "Das Pferd", "Der Hahn", "Der Fisch", "Die Kuh", "Die Biene", "Der Buffel", "Der Hase", "Der Delphin",
                    "Der Drachen", "Die Eule", "Die Spinne" };
    int i = 0;
    ArrayList<Integer> germanTrack = new ArrayList<Integer>();
    ArrayList<Integer> englishTrack = new ArrayList<Integer>();
    int MAX_NUMBER_STREAMS = 2;
    SoundPool englishSoundPool;
    SoundPool germanSoundPool;
    boolean loaded = false;
    int sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

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

        germanTrack.add(R.raw.hund);
        germanTrack.add(R.raw.ente);
        germanTrack.add(R.raw.pferd);
        germanTrack.add(R.raw.hahn);
        germanTrack.add(R.raw.fisch);
        germanTrack.add(R.raw.kuh);
        germanTrack.add(R.raw.animals_bee2);
        germanTrack.add(R.raw.animals_buffalo2);
        germanTrack.add(R.raw.animals_bunny2);
        germanTrack.add(R.raw.animals_dolphin2);
        germanTrack.add(R.raw.animals_dragon2);
        germanTrack.add(R.raw.animals_owl2);
        germanTrack.add(R.raw.animals_spider2);

        englishTrack.add(R.raw.dog);
        englishTrack.add(R.raw.duck);
        englishTrack.add(R.raw.horse);
        englishTrack.add(R.raw.rooster);
        englishTrack.add(R.raw.fish);
        englishTrack.add(R.raw.cow);
        englishTrack.add(R.raw.animals_bee);
        englishTrack.add(R.raw.animals_buffalo);
        englishTrack.add(R.raw.animals_bunny);
        englishTrack.add(R.raw.animals_dolphin);
        englishTrack.add(R.raw.animals_dragon);
        englishTrack.add(R.raw.animals_owl);
        englishTrack.add(R.raw.animals_spider);

        for(int i=0; i < germanTrack.size(); i++){
            germanSoundPool.load(this, germanTrack.get(i), 1);
        }

        for(int i=0; i < englishTrack.size();i++) {
           englishSoundPool.load(this, englishTrack.get(i), 1);

        }

    }

    @Override
    protected void onPause(){

        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        //BackgroundMusic.destroymusic();
    }

// ======================================

    public void mommy(View view){
        display(german_words[i], Color.MAGENTA);
        germanSoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);
    }

    public void daddy(View view){
        display(words[i], Color.parseColor("#29b6f6"));
        englishSoundPool.play(i+1,1.0F, 1.0F,0,0,1.0F);
    }

    public void left(View view){
        ImageView image = (ImageView) findViewById(R.id.animal);
        if(i > 0) {
            i = i - 1;
            image.setImageResource(pics[i]);
            display("", Color.CYAN);
        }
    }

    //i should be 1 less than the number of animals in the english group
    public void right(View view){
        ImageView image = (ImageView) findViewById(R.id.animal);
        if(i < englishTrack.size()-1) {
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
