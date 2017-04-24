package com.acorn.step01layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test04);
    }
    public void btn1Clicked(View v){
        Toast.makeText(this,"btn1 clicked!",Toast.LENGTH_SHORT).show();
    }
    public void btn2Clicked(View v){
        Toast.makeText(this,"btn2 clicked!",Toast.LENGTH_SHORT).show();
    }
    public void btn3Clicked(View v){
        Toast.makeText(this,"btn3 clicked!",Toast.LENGTH_SHORT).show();
    }
    public void btn4Clicked(View v){
        Toast.makeText(this,"btn4 clicked!",Toast.LENGTH_SHORT).show();
    }
}
