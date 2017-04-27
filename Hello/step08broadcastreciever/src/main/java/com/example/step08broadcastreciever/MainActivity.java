package com.example.step08broadcastreciever;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.oneBtn);
        Button btn2 = (Button)findViewById(R.id.twoBtn);

        //버튼 클릭 리스너 등록하기
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.oneBtn:
                Intent intent1 = new Intent();
                intent1.setAction("com.gura.TYPE1");
                //방송하기
                sendBroadcast(intent1);
                break;
            case R.id.twoBtn:
                //0번 식별값을 가지는 메세지를 5000/1000 초 이후에 Handler 객체에 보내기
                handler.sendEmptyMessageDelayed(0,5000);
                break;
        }
    }
    //일정 시간 지연시켜서 작업을 할때 사용할 Handler 객체 생성하기
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           Intent intent2 = new Intent();
            intent2.setAction("com.gura.TYPE2");
            //방송하기
            sendBroadcast(intent2);

        }
    };
}
