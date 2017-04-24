package com.gura.step04listview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener,AlertDialog.OnClickListener{

    //필요한 멤버필드 정의하기
    List<String> names;
    int selectedIndex;  //선택한 인덱스를 저장할 멤버필드
    ArrayAdapter<String> adapter;
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
        adapter= new ArrayAdapter<String>(this,
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
        //선택한 셀의 인덱스를 멤버필드에 저장
        selectedIndex = position;

        //클릭한 셀에 해당하는 이름을 읽어온다.
        String selectedName=names.get(position);
        //토스트로 띄워보기
        // Toast.makeText(this, selectedName, Toast.LENGTH_SHORT).show();

        //알림 다이얼로그 띄우기
        new AlertDialog.Builder(this)
                .setTitle("알림")
                .setMessage(selectedName+"을 삭제 하시겠습니까?")
                .setPositiveButton("네",this)
                .setNegativeButton("아니오",this)
                .setCancelable(true)
                .create()
                .show();
    }
    //네 혹은 아니오 버튼을 눌렀을때 호출되는 메소드
    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==AlertDialog.BUTTON_POSITIVE){
            //Model 에서 선택된 인덱스 삭제
            names.remove(selectedIndex);
            adapter.notifyDataSetChanged();
        }else if(which==AlertDialog.BUTTON_NEGATIVE){

        }

    }
}

