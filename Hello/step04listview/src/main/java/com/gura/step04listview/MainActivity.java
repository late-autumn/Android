package com.gura.step04listview;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener{
    List<String> names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ListView 의 참조값 얻어오기
        ListView listView=(ListView)findViewById(R.id.listView);

        //Adapter 에 연결할 Model
        names=new ArrayList<>();
        names.add("김구라1");
        names.add("김구라2");
        names.add("김구라3");
        names.add("김구라4");
        names.add("김구라5");
        names.add("김구라6");
        names.add("김구라7");
        names.add("김구라8");
        names.add("김구라9");
        names.add("김구라10");
        names.add("김구라11");
        names.add("김구라12");
        names.add("김구라13");
        names.add("김구라14");
        names.add("김구라15");
        //ListView 연결할 Adapter 객체
        ArrayAdapter<String> adapter=
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        names);
        //ListView 에 아답타 연결하기
        listView.setAdapter(adapter);
        //ListView 에 아이템 클릭 리스너 등록하기
        listView.setOnItemClickListener(this);
    }
    //ListView 의 셀을 클릭하면 호출되는 메소드
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //클릭한 셀에 해당하는 이름을 읽어온다.
        String selectedName=names.get(position);
        //토스트로 띄워보기
       // Toast.makeText(this, selectedName, Toast.LENGTH_SHORT).show();

        //알림 다이얼로그 띄우기
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage(selectedName)
                .setNeutralButton("확인",null)
                .setCancelable(true)
                .create()
                .show();
    }
}









