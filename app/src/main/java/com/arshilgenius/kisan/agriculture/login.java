package com.arshilgenius.kisan.agriculture;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button loginbt;
    EditText userName,passwd;




    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        loginbt = (Button) findViewById(R.id.loginButton);
        userName = (EditText) findViewById(R.id.loginUserName);
        passwd = (EditText) findViewById(R.id.loginPasswd);

        onStart();

    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            // No user is signed in
            loginbt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginfun();
                }
            });


        } else {
            // User logged in
            startActivity(new Intent(login.this,menuscreen.class));
        }
    }

    public void loginfun () {
        mAuth.signInWithEmailAndPassword(userName.getText().toString(), passwd.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(login.this, "Authentication succesful",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();

                            Intent in = new Intent(login.this, menuscreen.class);
                            startActivity(in);

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }


}
