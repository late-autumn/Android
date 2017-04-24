package com.example.step04listview2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //필요한 맴버 필드 정의하기
    ListView listView;
    List<CountryDto> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =(ListView)findViewById(R.id.listView);
        countries= new ArrayList<>();

        //Model 에 Sample 데이터 넣어주기
        countries.add(new CountryDto(R.drawable.austria, "오스트리아"));
        countries.add(new CountryDto(R.drawable.belgium, "벨기에"));
        countries.add(new CountryDto(R.drawable.brazil, "브라질"));
        countries.add(new CountryDto(R.drawable.france, "프랑스"));
        countries.add(new CountryDto(R.drawable.germany, "독일"));
        countries.add(new CountryDto(R.drawable.greece, "그리스"));
        countries.add(new CountryDto(R.drawable.israel, "이스라엘"));
        countries.add(new CountryDto(R.drawable.italy, "이탈리아"));
        countries.add(new CountryDto(R.drawable.japan, "일본"));
        countries.add(new CountryDto(R.drawable.korea, "대한민국"));
        countries.add(new CountryDto(R.drawable.poland, "폴란드"));
        countries.add(new CountryDto(R.drawable.spain, "스페인"));
        countries.add(new CountryDto(R.drawable.usa, "미국"));
        //ListView 에 연결할 Custom 아답타 객체 생성하기
        CountryAdapter adapter = new CountryAdapter(this,R.layout.listview_cell,countries);
        //ListView 에 아답타 연결
        listView.setAdapter(adapter);
    }
}
