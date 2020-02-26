package com.example.eng_tr_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    EditText mail,mailhead,mailbody;
    Button buttonsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        mail=findViewById(R.id.editmail);
        mailbody=findViewById(R.id.editmailbody);
        mailhead=findViewById(R.id.editmailhead);
        buttonsend=findViewById(R.id.buttonsend);


    }

    public void sendMessage(View view){

        String to= mail.getText().toString();
        String subject= mailhead.getText().toString();
        String message= mailbody.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL,to);
        email.putExtra(Intent.EXTRA_SUBJECT,subject);
        email.putExtra(Intent.EXTRA_TEXT,message);

        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email,"Mesajı hangi türde göndermek istiyorsunuz?"));


    }
}
