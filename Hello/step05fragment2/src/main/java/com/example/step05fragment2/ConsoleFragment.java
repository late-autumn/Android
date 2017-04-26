package com.example.step05fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsoleFragment extends Fragment {
    //필요한 맴버필드 정의하기
    EditText console;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_console, container, false);
        console=(EditText)view.findViewById(R.id.console);
        return view;
    }
    //MainActivity 에서 호출하는 메소드
    public void getMessage(String  msg){
        console.append(msg);
    }

}