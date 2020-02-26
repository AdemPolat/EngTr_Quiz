package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Anasayfa extends AppCompatActivity {

    CountDownTimer myCountDownTimer;

    Button buttonPlay;
    Button buttonLearn;
    Button buttonSet;
    Button buttonScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anasayfa);

        buttonPlay = findViewById(R.id.buttonPlay);
        buttonLearn = findViewById(R.id.buttonLearn);
        buttonSet = findViewById(R.id.buttonSet);
        buttonScore = findViewById(R.id.buttonScore);

        buttonPlay.setVisibility(View.INVISIBLE);
        buttonLearn.setVisibility(View.INVISIBLE);
        buttonSet.setVisibility(View.INVISIBLE);
        buttonScore.setVisibility(View.INVISIBLE);

       myCountDownTimer = new CountDownTimer(500,100) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

                if(millisUntilFinished > 400){
                    buttonPlay.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInLeft).duration(1500).repeat(0).playOn(buttonPlay);

                }
                else if(millisUntilFinished > 300){
                    buttonLearn.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.FadeInRight).duration(1500).repeat(0).playOn(buttonLearn);
                }
                else if(millisUntilFinished > 200){

                    buttonSet.setVisibility(View.VISIBLE);

                    YoYo.with(Techniques.FadeInRight).duration(1500).repeat(0).playOn(buttonSet);

                }

                else if(millisUntilFinished > 100){

                    buttonScore.setVisibility(View.VISIBLE);

                    YoYo.with(Techniques.FadeInLeft).duration(1500).repeat(0).playOn(buttonScore);

                }

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

            }
        }.start();
    }

    public void play(View view){

        Intent intent = new Intent(Anasayfa.this,Quiz_Anasayfa.class);
        startActivity(intent);
    }

    public void learn(View view){
        Intent intent = new Intent(Anasayfa.this, Learn_Anasayfa.class);
        startActivity(intent);
    }

    public void settings(View view){
        Intent intent = new Intent(Anasayfa.this, ContactActivity.class);
        startActivity(intent);
    }

    public void hscore(View view){

        Intent intent = new Intent(Anasayfa.this, High_Score.class);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Anasayfa.this, Anasayfa.class);
        startActivity(intent);

    }
}
