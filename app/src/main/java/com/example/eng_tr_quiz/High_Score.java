package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class High_Score extends AppCompatActivity {


    int StoredAdj1;
    int StoredAdj2;
    int StoredAdj3;

    int StoredAdv1;
    int StoredAdv2;
    int StoredAdv3;

    int StoredVerb1;
    int StoredVerb2;
    int StoredVerb3;

    int StoredNoun1;
    int StoredNoun2;
    int StoredNoun3;

    TextView adj1;
    TextView adj2;
    TextView adj3;

    TextView adv1;
    TextView adv2;
    TextView adv3;

    TextView verb1;
    TextView verb2;
    TextView verb3;

    TextView noun1;
    TextView noun2;
    TextView noun3;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.high__score);

        adj1 = findViewById(R.id.adj1);
        adj2 = findViewById(R.id.adj2);
        adj3 = findViewById(R.id.adj3);

        adv1 = findViewById(R.id.adv1);
        adv2 = findViewById(R.id.adv2);
        adv3 = findViewById(R.id.adv3);

        verb1 = findViewById(R.id.verb1);
        verb2 = findViewById(R.id.verb2);
        verb3 = findViewById(R.id.verb3);

        noun1 = findViewById(R.id.noun1);
        noun2 = findViewById(R.id.noun2);
        noun3 = findViewById(R.id.noun3);

        Intent intent = getIntent();
        String uAdj1 = intent.getStringExtra("userAdj1");
        String uAdj2 = intent.getStringExtra("userAdj2");
        String uAdj3 = intent.getStringExtra("userAdj3");

        String uAdv1 = intent.getStringExtra("userAdv1");
        String uAdv2 = intent.getStringExtra("userAdv2");
        String uAdv3 = intent.getStringExtra("userAdv3");

        String uVerb1 = intent.getStringExtra("userVerb1");
        String uVerb2 = intent.getStringExtra("userVerb2");
        String uVerb3 = intent.getStringExtra("userVerb3");

        String uNoun1 = intent.getStringExtra("userNoun1");
        String uNoun2 = intent.getStringExtra("userNoun2");
        String uNoun3 = intent.getStringExtra("userNoun3");

        adj1.setText("" + uAdj1);
        adj2.setText("" + uAdj2);
        adj3.setText("" + uAdj3);

        adv1.setText("" + uAdv1);
        adv2.setText("" + uAdv2);
        adv3.setText("" + uAdv3);

        verb1.setText("" + uVerb1);
        verb2.setText("" + uVerb2);
        verb3.setText("" + uVerb3);

        noun1.setText("" + uNoun1);
        noun2.setText("" + uNoun2);
        noun3.setText("" + uNoun3);

        sharedPreferences = this.getSharedPreferences("com.example.eng_tr_quiz", Context.MODE_PRIVATE);  // Shared Preferences

        StoredAdj1 = sharedPreferences.getInt("StoredAdj1", 0);
        StoredAdj2 = sharedPreferences.getInt("StoredAdj2", 0);
        StoredAdj3 = sharedPreferences.getInt("StoredAdj3", 0);

        StoredAdv1 = sharedPreferences.getInt("StoredAdv1", 0);
        StoredAdv2 = sharedPreferences.getInt("StoredAdv2", 0);
        StoredAdv3 = sharedPreferences.getInt("StoredAdv3", 0);

        StoredVerb1 = sharedPreferences.getInt("StoredVerb1", 0);
        StoredVerb2 = sharedPreferences.getInt("StoredVerb2", 0);
        StoredVerb3 = sharedPreferences.getInt("StoredVerb3", 0);

        StoredNoun1 = sharedPreferences.getInt("StoredNoun1", 0);
        StoredNoun2 = sharedPreferences.getInt("StoredNoun2", 0);
        StoredNoun3 = sharedPreferences.getInt("StoredNoun3", 0);

        adj1.setText("" + StoredAdj1);
        adj2.setText("" + StoredAdj2);
        adj3.setText("" + StoredAdj3);

        adv1.setText("" + StoredAdv1);
        adv2.setText("" + StoredAdv2);
        adv3.setText("" + StoredAdv3);

        verb1.setText("" + StoredVerb1);
        verb2.setText("" + StoredVerb2);
        verb3.setText("" + StoredVerb3);

        noun1.setText("" + StoredNoun1);
        noun2.setText("" + StoredNoun2);
        noun3.setText("" + StoredNoun3);


    }

}