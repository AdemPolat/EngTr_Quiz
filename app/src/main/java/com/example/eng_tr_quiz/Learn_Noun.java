package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Learn_Noun extends AppCompatActivity {

    Switch sw;


    private TextToSpeech mTTS;
    TextView textShowWord;
    Button button;

    Button b_answer1,b_answer2,b_answer3,b_answer4;
    TextView iv_country;
    List<Noun_Item> list;
    Random r;
    int turn =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn__noun);

        sw =  findViewById(R.id.switch1);

        textShowWord = findViewById(R.id.textShowWord);
        button=findViewById(R.id.button);

        r= new Random();
        iv_country = findViewById(R.id.iv_country);
        b_answer1=findViewById(R.id.b_answer1);
        b_answer2=findViewById(R.id.b_answer2);
        b_answer3=findViewById(R.id.b_answer3);
        b_answer4=findViewById(R.id.b_answer4);

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


        list = new ArrayList<>();

        for(int i = 0; i< new Noun_Database().turkish.length; i++){

            list.add(new Noun_Item(new Noun_Database().turkish[i],new Noun_Database().english[i]));
        }
        Collections.shuffle(list);
        newQuestions(turn);
    }

    private void newQuestions(int number ){

        iv_country.setText(list.get(number-1).getAnlam());

        int correct_answer = r.nextInt(4) + 1;

        int firstButton= number - 1;
        int secondButton= number;
        int thirdButton= number;
        int fourthButton= number;

        switch (correct_answer){
            case 1:
                b_answer1.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());


                break;
            case 2:

                b_answer2.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer1.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 3:

                b_answer3.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer1.setText(list.get(thirdButton).getName());
                b_answer4.setText(list.get(fourthButton).getName());
                break;
            case 4:

                b_answer4.setText(list.get(firstButton).getName());

                do{
                    secondButton = r.nextInt(list.size());
                }while (secondButton == firstButton);
                do{
                    thirdButton = r.nextInt(list.size());
                }while (thirdButton == firstButton || thirdButton == secondButton);
                do{
                    fourthButton = r.nextInt(list.size());
                }while (fourthButton == firstButton || fourthButton == secondButton || fourthButton == thirdButton);

                b_answer2.setText(list.get(secondButton).getName());
                b_answer3.setText(list.get(thirdButton).getName());
                b_answer1.setText(list.get(fourthButton).getName());
                break;

        }
    }

    public void sound(View view){

        String text = iv_country.getText().toString();

        mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }

    public void country(View view){

        YoYo.with(Techniques.SlideInRight).duration(500).repeat(0).playOn(textShowWord);
        YoYo.with(Techniques.SlideInLeft).duration(500).repeat(0).playOn(textShowWord);

        textShowWord.setVisibility(View.VISIBLE);

        if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            String c_answer1 = b_answer1.getText().toString();

            textShowWord.setText(c_answer1);
        }
        else if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            String c_answer2 = b_answer2.getText().toString();

            textShowWord.setText(c_answer2);
        }
        else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            String c_answer3 = b_answer3.getText().toString();

            textShowWord.setText(c_answer3);
        }
        else if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            String c_answer4 = b_answer4.getText().toString();

            textShowWord.setText(c_answer4);
        }


    }

    public void next(View view){

        turn++;
        newQuestions(turn);
        if (sw.isChecked()){
            String text = iv_country.getText().toString();

            mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);

        }else {

        }

        textShowWord.setVisibility(View.INVISIBLE);

        YoYo.with(Techniques.BounceIn).duration(500).repeat(0).playOn(iv_country);

    }

    public void show(View view){

        YoYo.with(Techniques.SlideInRight).duration(500).repeat(0).playOn(textShowWord);
        YoYo.with(Techniques.SlideInLeft).duration(500).repeat(0).playOn(textShowWord);

        textShowWord.setVisibility(View.VISIBLE);

        if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            String c_answer1 = b_answer1.getText().toString();

            textShowWord.setText(c_answer1);
        }
        else if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            String c_answer2 = b_answer2.getText().toString();

            textShowWord.setText(c_answer2);
        }
        else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            String c_answer3 = b_answer3.getText().toString();

            textShowWord.setText(c_answer3);
        }
        else if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            String c_answer4 = b_answer4.getText().toString();

            textShowWord.setText(c_answer4);
        }


    }
}