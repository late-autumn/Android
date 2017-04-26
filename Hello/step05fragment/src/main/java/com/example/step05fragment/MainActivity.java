package com.example.step05fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
            activity_main.xml 에는
            <fragment>가 존재한다.
            해당 Fragment 객체의 참조값이 필요 하다면?
        */
        setContentView(R.layout.activity_main);
        FragmentManager fManager =getSupportFragmentManager();
        //Fragment 에 부여된 아이디를 이용해서 Fragment 객체의 참조값을 얻어온다.
        Fragment fragment=fManager.findFragmentById(R.id.myFragment);
        //원래 type이 필요하다면 casting한다.
        MyFragment myFragment=(MyFragment)fragment;
    }

    public static class MyFragment extends Fragment {
        //Fragment 가 관리한 view 객체를 만들어서 리턴해 주어야한다.
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            //fragment_my.xml 문서를 전개해서 view 객체를 만든다.
            View view = inflater.inflate(R.layout.fragment_my,container);
            //만든 view 객체를 리턴한다.
            return view;
        }
    }
}
