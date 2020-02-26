package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.CountDownTimer;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Adjective_EngTr extends AppCompatActivity {

    Switch sw;
    int puan=0,number=1,truescore=0,wrongscore=0,turn =1;
    String uAdj1,uAdj2,uAdj3;
    TextView textHigh1,textHigh2,textHigh3,textShowWord,textHideWord,textSoru,iv_country;
    SharedPreferences sharedPreferences;
    private TextToSpeech mTTS;
    CountDownTimer btnCountDownTimer,myCountDownTimer;
    Button b_answer1,b_answer2,b_answer3,b_answer4,resultButton,timeButton;
    List<Adjective_Item> list;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adjective_engtr);

        sw =  findViewById(R.id.switch1);


         textHigh1 = findViewById(R.id.textHigh1);
        textHigh2 = findViewById(R.id.textHigh2);
        textHigh3 = findViewById(R.id.textHigh3);
        sharedPreferences =this.getSharedPreferences("com.example.eng_tr_quiz", Context.MODE_PRIVATE);
        int StoredAdj1 = sharedPreferences.getInt("StoredAdj1", 0);
        int StoredAdj2 = sharedPreferences.getInt("StoredAdj2", 0);
        int StoredAdj3 = sharedPreferences.getInt("StoredAdj3", 0);
        textHigh1.setText(""+StoredAdj1);
        textHigh2.setText(""+StoredAdj2);
        textHigh3.setText(""+StoredAdj3);

        textSoru= findViewById(R.id.textSoru);
        timeButton= findViewById(R.id.timebutton);
        resultButton= findViewById(R.id.resultButton);
        textShowWord = findViewById(R.id.textShowWord);
        textHideWord = findViewById(R.id.textHideWord);

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

        for(int i = 0; i< new Adjective_Database().turkish.length; i++){

            list.add(new Adjective_Item(new Adjective_Database().turkish[i],new Adjective_Database().english[i]));
        }

        Collections.shuffle(list);
        newQuestions(turn);

        myCountDownTimer = new CountDownTimer(100000,1000) {  //
            @Override
            public void onTick(long millisUntilFinished) {
                timeButton.setText(""+ millisUntilFinished/1000);
            }
            @Override
            public void onFinish() {//

                gameOver();
            }
        }.start();

    }

    public void answer1(View view){


        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            truebutton();
            b_answer1.setBackgroundResource(R.drawable.buttontrue);
            YoYo.with(Techniques.Tada).duration(1500).repeat(0).playOn(b_answer1);


        } else {

            wrongbutton();
            b_answer1.setBackgroundResource(R.drawable.buttonfalse);
            b_answer1.setEnabled(false);

            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer2.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer2);
            }
            else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer3.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer3);
            }
            else{
                b_answer4.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer4);
            }

        }

    }

    public void answer2(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            truebutton();
            b_answer2.setBackgroundResource(R.drawable.buttontrue);
            YoYo.with(Techniques.Tada).duration(1500).repeat(0).playOn(b_answer2);



        } else{

            wrongbutton();
            b_answer2.setBackgroundResource(R.drawable.buttonfalse);
            b_answer2.setEnabled(false);

            if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer1.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer1);
            }
            else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer3.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer3);
            }
            else{
                b_answer4.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer4);
            }

        }
    }

    public void answer3(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
            truebutton();
            b_answer3.setBackgroundResource(R.drawable.buttontrue);
            YoYo.with(Techniques.Tada).duration(1500).repeat(0).playOn(b_answer3);


        } else {

            wrongbutton();
            b_answer3.setBackgroundResource(R.drawable.buttonfalse);
            b_answer3.setEnabled(false);

            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer2.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer2);
            }
            else if(b_answer1.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer1.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer1);
            }
            else{
                b_answer4.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer4);
            }


        }
    }

    public void answer4(View view){

        b_answer1.setEnabled(false);
        b_answer2.setEnabled(false);
        b_answer3.setEnabled(false);
        b_answer4.setEnabled(false);

        if(b_answer4.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){

            truebutton();
            b_answer4.setBackgroundResource(R.drawable.buttontrue);
            YoYo.with(Techniques.Tada).duration(1500).repeat(0).playOn(b_answer4);

        } else{

            wrongbutton();
            b_answer4.setBackgroundResource(R.drawable.buttonfalse);
            b_answer4.setEnabled(false);

            if(b_answer2.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer2.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer2);
            }
            else if(b_answer3.getText().toString().equalsIgnoreCase(list.get(turn-1).getName())){
                b_answer3.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer3);
            }
            else{
                b_answer1.setBackgroundResource(R.drawable.buttontrue);
                YoYo.with(Techniques.Tada).duration(500).repeat(1).playOn(b_answer1);
            }


        }
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

    public void wrongbutton(){

        wrongscore++;
        resultButton.setText("DOĞRU "+truescore+ "  "+"YANLIŞ "+wrongscore);

        number++;
        textSoru.setText("Soru Sayısı"+number+"/100");

        if(number >=100){

            gameOver();
            myCountDownTimer.cancel();
            b_answer1.setEnabled(false);
            b_answer2.setEnabled(false);
            b_answer3.setEnabled(false);
            b_answer4.setEnabled(false);

        }



        btnCountDownTimer = new CountDownTimer(1000,1000) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                turn++;
                newQuestions(turn);

                b_answer1.setBackgroundResource(R.drawable.blueoption);
                b_answer2.setBackgroundResource(R.drawable.blueoption);
                b_answer3.setBackgroundResource(R.drawable.blueoption);
                b_answer4.setBackgroundResource(R.drawable.blueoption);

                b_answer1.setEnabled(true);
                b_answer2.setEnabled(true);
                b_answer3.setEnabled(true);
                b_answer4.setEnabled(true);

                if (sw.isChecked()){

                    String text = iv_country.getText().toString();

                    mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);

                }else {

                }
            }
        }.start();
    }

    public void truebutton() {

        truescore++;
        resultButton.setText("DOĞRU "+truescore+ "  "+"YANLIŞ "+wrongscore);

        number++;
        textSoru.setText("Soru Sayısı"+number+"/100");

        if(number >=100){

            gameOver();
            myCountDownTimer.cancel();
            b_answer1.setEnabled(false);
            b_answer2.setEnabled(false);
            b_answer3.setEnabled(false);
            b_answer4.setEnabled(false);

        }


        btnCountDownTimer = new CountDownTimer(1000,1000) {  // Geriye saydırma
            @Override
            public void onTick(long millisUntilFinished) {

            }
            @Override
            public void onFinish() {// Geriye Sayma Bittiği zaman ne olacağı

                turn++;
                newQuestions(turn);

                b_answer1.setBackgroundResource(R.drawable.blueoption);
                b_answer2.setBackgroundResource(R.drawable.blueoption);
                b_answer3.setBackgroundResource(R.drawable.blueoption);
                b_answer4.setBackgroundResource(R.drawable.blueoption);

                b_answer1.setEnabled(true);
                b_answer2.setEnabled(true);
                b_answer3.setEnabled(true);
                b_answer4.setEnabled(true);

                if (sw.isChecked()){
                    String text = iv_country.getText().toString();

                    mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);

                }else {

                }

            }
        }.start();
    }


    public void gameOver(){

        puan= truescore *2 - wrongscore;

        int hScore = Integer.parseInt(textHigh1.getText().toString());
        int hScore2 = Integer.parseInt(textHigh2.getText().toString());
        int hScore3 = Integer.parseInt(textHigh3.getText().toString());

        if(puan >= hScore){

            hScore3=hScore2;
            hScore2=hScore;
            hScore=puan;

            textHigh1.setText("" + hScore);
            textHigh2.setText("" + hScore2);
            textHigh3.setText("" + hScore3);
            sharedPreferences.edit().putInt("StoredAdj1",hScore).apply();
            sharedPreferences.edit().putInt("StoredAdj2",hScore2).apply();
            sharedPreferences.edit().putInt("StoredAdj3",hScore3).apply();

        }
        else if(puan < hScore && puan >= hScore2){

            hScore3=hScore2;
            hScore2=puan;

            textHigh1.setText("" + hScore);
            textHigh2.setText("" + hScore2);
            textHigh3.setText("" + hScore3);
            sharedPreferences.edit().putInt("StoredAdj1",hScore).apply();
            sharedPreferences.edit().putInt("StoredAdj2",hScore2).apply();
            sharedPreferences.edit().putInt("StoredAdj3",hScore3).apply();

        }
        else if(puan < hScore && puan < hScore2 && puan > hScore3){

            hScore3=puan;

            textHigh1.setText("" + hScore);
            textHigh2.setText("" + hScore2);
            textHigh3.setText("" + hScore3);
            sharedPreferences.edit().putInt("StoredAdj1",hScore).apply();
            sharedPreferences.edit().putInt("StoredAdj2",hScore2).apply();
            sharedPreferences.edit().putInt("StoredAdj3",hScore3).apply();

        }

        uAdj1= textHigh1.getText().toString();  // GET INTENT
        uAdj2= textHigh2.getText().toString();
        uAdj3= textHigh3.getText().toString();
        Intent intent = new Intent(Adjective_EngTr.this, High_Score.class);
        intent.putExtra("userAdj1",uAdj1);
        intent.putExtra("userAdj2",uAdj2);
        intent.putExtra("userAdj3",uAdj3);



        myCountDownTimer.cancel();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Adjective_EngTr.this);
        alertDialogBuilder.setTitle("OYUN BİTTİ");

        alertDialogBuilder.setMessage("PUANINIZ: "+ puan+"\nDoğru Sayısı:"+truescore+"\nYanlış Sayısı:"+wrongscore);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Yeni Oyun", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(), Adjective_EngTr.class));
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Anasayfaya Dön", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(), Anasayfa.class));

                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder alert = new AlertDialog.Builder(Adjective_EngTr.this);  // Uyarı mesajını açar
        alert.setTitle("UYARI");
        alert.setMessage("Çıkmak istiyor musunuz?");
        alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                myCountDownTimer.cancel();
                Intent intent= new Intent(Adjective_EngTr.this, Quiz_Anasayfa.class);
                startActivity(intent);

            }
        });

        alert.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    public void sound(View view){

        String text = iv_country.getText().toString();

        mTTS.speak(text,TextToSpeech.QUEUE_FLUSH,null);

    }

    public void showWord(View view){

        textShowWord.setVisibility(View.INVISIBLE);
        iv_country.setVisibility(View.VISIBLE);
        textHideWord.setVisibility(View.VISIBLE);

    }
    public void hideWord(View view){

        textShowWord.setVisibility(View.VISIBLE);
        iv_country.setVisibility(View.INVISIBLE);
        textHideWord.setVisibility(View.INVISIBLE);

    }

    public void sesUK(){

    }
   }