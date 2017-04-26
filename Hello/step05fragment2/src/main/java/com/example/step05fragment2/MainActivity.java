package com.example.step05fragment2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
        implements InputFragment.InputFragmentListener{
    //필요한 맴버필드 정의하기
    ConsoleFragment cFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FragmentManager 의 참조값 얻어와서
        FragmentManager fManager=getSupportFragmentManager();
        //ConsoleFragment 객체의 참조값을 얻어온다.
        cFragment=(ConsoleFragment)
                fManager.findFragmentById(R.id.consoleFragment);
    }
    //InputFragment 가 호출하는 메소드
    @Override
    public void sendMessage(String msg) {
        //인자로 전달된 메세지를 ConsoleFragment 객체에 전달하기
        cFragment.getMessage(msg);
    }
}