package com.example.dyns.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dyns.HomeActivity;
import com.example.dyns.R;
import com.example.dyns.SignInActivity;

public class Wallet extends AppCompatActivity {

    ImageView BackWlt;
    Button AddMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        BackWlt = findViewById(R.id.WalletBack);
        AddMoney = findViewById(R.id.WalletMny);

        BackWlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(Wallet.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });

        AddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Wallet.this,"Money",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
