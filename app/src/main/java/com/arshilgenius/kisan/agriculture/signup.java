package com.arshilgenius.kisan.agriculture;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    FirebaseAuth mAuth;
    Button signupbt;
    EditText username,password,phnum,email;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Firebase myfirebase;
    String userpalce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        Firebase.setAndroidContext(signup.this);



        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
         adapter = ArrayAdapter.createFromResource(this,
                R.array.district_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        signupbt=(Button)findViewById(R.id.signButton);
        username=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.passwordField);
        phnum=(EditText)findViewById(R.id.userPhone);
        email=(EditText)findViewById(R.id.userEmail);
        myfirebase=new Firebase("https://farmerapp-efbfa.firebaseio.com/USERDATA");

        mAuth=FirebaseAuth.getInstance();
        signupbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

    }
    public void signup() {
        if (password.getText().toString().length() >= 6) {

            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(signup.this, "Login succesful", Toast.LENGTH_LONG).show();
                                FirebaseUser user = mAuth.getCurrentUser();



                                //Map<String, FarmerData> users = new HashMap<>();
                                //users.put(username.getText().toString(), new FarmerData(password.getText().toString(),phnum.getText().toString(),userpalce));



                                myfirebase=myfirebase.child(phnum.getText().toString());
                                myfirebase.child("email").setValue(email.getText().toString());
                                myfirebase.child("place").setValue(userpalce);
                                myfirebase.child("name").setValue(username.getText().toString());

                                Intent in = new Intent(signup.this, menuscreen.class);
                                startActivity(in);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(signup.this, "Login unsuccesful", Toast.LENGTH_LONG).show();

                            }


                        }
                    });
        } else {
            Toast.makeText(signup.this, "password should be of lenght greater than 6 char", Toast.LENGTH_LONG).show();
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        userpalce=parent.getItemAtPosition(pos).toString();
        Toast.makeText(signup.this,parent.getItemAtPosition(pos).toString(),Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
