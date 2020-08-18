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

import com.example.dyns.Common.Common;
import com.example.dyns.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.core.UserData;

public class SignInActivity extends AppCompatActivity {
    EditText phone, password;
    Button SignIn;
    TextView NotReg, RstPassIN, Skip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        phone = findViewById(R.id.InPhn);
        password = findViewById(R.id.InPass);
        SignIn = findViewById(R.id.InBtn);
        RstPassIN = findViewById(R.id.RstPassIN);
        NotReg = findViewById(R.id.NotRegIN);
        Skip = findViewById(R.id.Skip);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Inphone = phone.getText().toString().trim();
                String Inpass = password.getText().toString().trim();

                if (TextUtils.isEmpty(Inphone)){
                    phone.setError("Phone no. is Required!");
                    phone.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(Inpass)){
                    password.setError("Password is Required!");
                    password.requestFocus();
                    return;
                }

                if (password.length()<6){
                    password.setError("Wrong Password!!!");
                }

                final ProgressDialog mDialog = new ProgressDialog(SignInActivity.this);
                mDialog.setMessage("Please Wait...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(phone.getText().toString()).exists()) {

                            mDialog.dismiss();
                            User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(password.getText().toString())) {
                                {
                                    Toast.makeText(SignInActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                                    Intent homeIntent = new Intent(SignInActivity.this,HomeActivity.class);
                                    Common.currentUser = user;
                                    startActivity(homeIntent);
                                }
                            } else {
                                Toast.makeText(SignInActivity.this, "InValid Details!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(SignInActivity.this, "User Does not Exist!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SignInActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        NotReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        RstPassIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(SignInActivity.this, ResetPass.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}