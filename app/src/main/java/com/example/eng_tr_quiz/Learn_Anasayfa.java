package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Learn_Anasayfa extends AppCompatActivity {

    Button buttonAdjective;
    Button buttonAdverb;
    Button buttonVerb;
    Button buttonNoun;
    ImageView imageView;
    CountDownTimer myCountDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn__anasayfa);

        buttonAdjective=findViewById(R.id.buttonAdjective);
        buttonAdverb=findViewById(R.id.buttonAdverb);
        buttonVerb=findViewById(R.id.buttonVerb);
        buttonNoun=findViewById(R.id.buttonNoun);
        imageView=findViewById(R.id.imageView);

        buttonAdjective.setVisibility(View.INVISIBLE);
        buttonAdverb.setVisibility(View.INVISIBLE);
        buttonNoun.setVisibility(View.INVISIBLE);
        buttonVerb.setVisibility(View.INVISIBLE);

        myCountDownTimer = new CountDownTimer(1000,200) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

                if(millisUntilFinished > 800){
                    buttonAdjective.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInLeft).duration(1500).repeat(0).playOn(buttonAdjective);

                }
                else if(millisUntilFinished > 600){
                    buttonVerb.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceInLeft).duration(1500).repeat(0).playOn(buttonVerb);
                }
                else if(millisUntilFinished > 400){

                    buttonNoun.setVisibility(View.VISIBLE);

                    YoYo.with(Techniques.BounceInLeft).duration(1500).repeat(0).playOn(buttonNoun);

                }

                else if(millisUntilFinished > 200){

                    buttonAdverb.setVisibility(View.VISIBLE);

                    YoYo.with(Techniques.BounceInLeft).duration(1500).repeat(0).playOn(buttonAdverb);


                }

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

            }
        }.start();



    }

    public void adjective(View view){

        Intent intent= new Intent(Learn_Anasayfa.this, Learn_Adjective.class);
        startActivity(intent);
    }
    public void verb(View view){

        Intent intent= new Intent(Learn_Anasayfa.this, Learn_Verb.class);
        startActivity(intent);
    }
    public void noun(View view){

        Intent intent= new Intent(Learn_Anasayfa.this, Learn_Noun.class);
        startActivity(intent);
    }
    public void adverb(View view){

        Intent intent= new Intent(Learn_Anasayfa.this, Learn_Adverb.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {



        Intent intent = new Intent(Learn_Anasayfa.this, Anasayfa.class);
        startActivity(intent);

    }

}
