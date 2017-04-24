package com.example.step03activitymove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Activity Move 버튼을 눌렀을 때 실행되는 메소드
    public void move(View v){
        //SubActivity 로 이동할 수 있는 Intent 객체 생성하기
        Intent intent = new Intent(this, SubActivity.class);    //context type, Activity class Type

        //액티비티 이동하기
        startActivity(intent);
    }
}
