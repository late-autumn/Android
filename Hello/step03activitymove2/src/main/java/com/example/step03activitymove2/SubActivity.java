package com.example.step03activitymove2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
