package com.example.step02listener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    //필요한 맴버필드 선언하기
    EditText inputText;
    TextView textView;

    // MainAcitvity 가 활성화될때 최초 한번 자동 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
        // inputText 라는 아이디를 가지고 있는 View 의 참조값 얻어오기
        View v=findViewById(R.id.inputText);
        //원래 Type 으로 casting !
        inputText=(EditText)v;

        //전송 버튼의 참조값 얻어오기
        Button sendBtn=(Button)findViewById(R.id.sendBtn);
        //버튼의 클릭리스너 등록하기 (MainActivity)
        sendBtn.setOnClickListener(this);

        //TextView 의 참조값 얻어와서 맴버필드에 저장하기
        textView=(TextView)findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        //1. EditText 에 입력한 문자열을 읽어온다.
        String msg=inputText.getText().toString();
        //2. 읽어온 문자열을 TextView 에 출력한다.
        textView.setText(msg);
    }
}









