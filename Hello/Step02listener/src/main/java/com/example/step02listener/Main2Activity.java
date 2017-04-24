package com.example.step02listener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jeongwoo on 2017-04-20.
 */

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //res/layout/activity_main2.xml 로 전개해서 구성된 버튼의 참조값
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        //버튼에 리스너 등록하기
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }
    //버튼을 누르면 실행되는 메소드
    @Override
    public void onClick(View v) {
        //눌러진 버튼의 리소스 아이디 값을 읽어온다.
/*        int resId = v.getId();
        if(resId==R.id.btn1){

        }else if(resId==R.id.btn2){

        }else if(resId==R.id.btn3){

        }*/

        //눌려진 버튼의 아이디값을 읽어와서 분기 한다.
        switch (v.getId()){
            case R.id.btn1:
                Toast.makeText(this,"btn1 !",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this,"btn2 !",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:
                Toast.makeText(this,"btn3 !",Toast.LENGTH_SHORT).show();
                break;
        }

    }

}
