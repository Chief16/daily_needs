package com.example.dyns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResetPass extends AppCompatActivity {

    TextView Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpass);

        Back = findViewById(R.id.Back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent homeIntent = new Intent(ResetPass.this, SignInActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }
}
