package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.internal.Objects;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://chatapp-faa46-default-rtdb.firebaseio.com/");

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
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.child("users").hasChild(mobileTxt)){
                            Toast.makeText(Register.this, "Mobile already exists", Toast.LENGTH_SHORT).show();
                        }else{
                            databaseReference.child("users").child(mobileTxt).child("email").setValue(emailTxt);
                            databaseReference.child("users").child(mobileTxt).child("name").setValue(nameTxt);

                            Toast.makeText(Register.this, "Success", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Register.this, MainActivity.class);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }
    });
    }
}