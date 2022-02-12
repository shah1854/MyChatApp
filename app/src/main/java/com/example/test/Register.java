package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    final EditText name = findViewById(R.id.r_name);
    final EditText mobile = findViewById(R.id.r_mobile);
    final EditText email = findViewById(R.id.r_email);
    final AppCompatButton registerBtn = findViewById(R.id.r_registerBtn);

    registerBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String nameTxt = name.getText().toString();
            final String mobileTxt = mobile.getText().toString();
            final String emailTxt = email.getText().toString();

            if(nameTxt.isEmpty() || mobileTxt.isEmpty() || emailTxt.isEmpty()){
                Toast.makeText(Register.this, "All Fields Required!", Toast.LENGTH_SHORT).show();
            }
            else{

            }
        }
    });
    }
}