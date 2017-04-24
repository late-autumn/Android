package com.example.jeongwoo.hello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        //res/layout/text.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.test);

    }
    //버튼을 클릭했을 때 호출되는 메소드
    public void buttonClicked(View v){
        Toast.makeText(this,"버튼을 눌렀네?",Toast.LENGTH_SHORT).show();
    }
}
