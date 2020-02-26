package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Locale;

public class FirstActivity extends AppCompatActivity {

    CountDownTimer myCountDownTimer;
    private TextToSpeech mTTS;

    ImageView imageView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        imageView= findViewById(R.id.imageView);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView6=findViewById(R.id.textView6);

        textView1.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {   // Text to Voice
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTS.setLanguage(Locale.UK);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {

                        Log.e("TTS","Language not supported");
                    } else{

                    }
                } else {
                    Log.e("TTS","Inıtıalization failed.");
                }
            }
        });






        myCountDownTimer = new CountDownTimer(2200,200) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

                if(millisUntilFinished > 1400){
                    textView1.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceIn).duration(1500).repeat(0).playOn(textView1);



                }
                else if(millisUntilFinished > 1200){
                    textView2.setVisibility(View.VISIBLE);
                    YoYo.with(Techniques.BounceIn).duration(1500).repeat(0).playOn(textView2);
                }
                else if(millisUntilFinished > 1000){

                    textView3.setVisibility(View.VISIBLE);

                    YoYo.with(Techniques.BounceIn).duration(1500).repeat(0).playOn(textView3);

                }


            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                Intent intent= new Intent(FirstActivity.this,Anasayfa.class);
                startActivity(intent);



            }
        }.start();


    }


}
