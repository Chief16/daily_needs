package com.example.dyns;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dyns.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SignUpActivity extends AppCompatActivity {

    EditText name, phone, password, email;
    Button SignUp;
    TextView AlRegUP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.NameUP);
        phone = findViewById(R.id.UpPhn);
        password = findViewById(R.id.PassUP);
        SignUp = findViewById(R.id.btnUp);
        email = findViewById(R.id.EmailUP);
        AlRegUP = findViewById(R.id.AlRegUP);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Inphone = phone.getText().toString().trim();
                String Inpass = password.getText().toString().trim();
                String Inname = name.getText().toString().trim();
                String Inemail = email.getText().toString().trim();


                if (TextUtils.isEmpty(Inname)){
                    name.setError("Name is Required!");
                    name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Inphone)){
                    phone.setError("Phone no. is Required!");
                    phone.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Inemail)){
                    email.setError("Email is Required!");
                    email.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Inpass)){
                    password.setError("Password is Required!");
                    password.requestFocus();
                    return;
                }

                if (password.length()<6){
                    password.setError("Password must be of more than  character!!");
                }

                final ProgressDialog mDialog = new ProgressDialog(SignUpActivity.this);
                mDialog.setMessage("Please Wait...");
                mDialog.show();

                table_user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignUpActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss();
                            User user = new User(name.getText().toString(),password.getText().toString(),email.getText().toString());
                            table_user.child(phone.getText().toString()).setValue(user);
                            Toast.makeText(SignUpActivity.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent homeIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                            startActivity(homeIntent);
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        AlRegUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
