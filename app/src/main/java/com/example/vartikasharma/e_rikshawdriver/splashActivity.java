package com.example.vartikasharma.e_rikshawdriver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class splashActivity extends AppCompatActivity {
    TextView signup;
    TextView signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        signin=(TextView)findViewById(R.id.firstpagesignin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(splashActivity.this,MainActivity.class));
            }
        });





    }
}
