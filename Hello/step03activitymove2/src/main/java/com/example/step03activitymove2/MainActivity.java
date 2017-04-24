package com.example.step03activitymove2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText inputMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText의 참조값 얻어와서 멤버 필드에 저장하기
        inputMsg=(EditText)findViewById(R.id.inputMsg);
        //버튼의 참조 값 얻어와서 리스너 등록하기
        Button moveBtn =(Button)findViewById(R.id.moveBtn);
        moveBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //입력한 문자열을 읽어온다.
        String msg = inputMsg.getText().toString();
        //인텐트 객체를 생성하고
        Intent intent = new Intent(this,SubActivity.class);
        //"msg"라는 키값으로 입력한 문자열을 담는다.
        intent.putExtra("msg",msg);
        //액티비티 이동을 한다.
        startActivity(intent);
    }
}
