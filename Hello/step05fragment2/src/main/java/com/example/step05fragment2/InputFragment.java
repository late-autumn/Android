package com.example.step05fragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by jeongwoo on 2017-04-25.
 */


public class InputFragment extends Fragment
        implements View.OnClickListener{
    //필요한 맴버필드 정의하기
    EditText inputText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate
                (R.layout.fragment_input, container, false);
        //View 에서 EditText의 참조값을 얻어와서 맴버필드에 저장
        inputText=(EditText)view.findViewById(R.id.inputText);
        //버튼의 참조값 얻어와서 리스너 등록
        Button sendBtn=(Button)view.findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(this);
        return view;
    }
    //버튼을 클릭했을때 호출되는 메소드
    @Override
    public void onClick(View v) {
        //입력한 문자열을 읽어온다.
        String msg=inputText.getText().toString();
        //*** 이 Fragment 를 관리하고 있는 액티비티의 참조값 얻어오기
        InputFragmentListener activity=
                (InputFragmentListener)getActivity();
        activity.sendMessage(msg);
    }
    //인터페이스 정의하기
    public interface InputFragmentListener{
        public void sendMessage(String msg);
    }
}
