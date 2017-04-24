package com.example.step04listview2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jeongwoo on 2017-04-24.
 */

/*
    커스텀 아답타 클래스 정의하기
    -BaseAdapter 추상 클래스를 상속 받아서 만든다.
*/
public class CountryAdapter extends BaseAdapter{
    //필요한 멤버필드 정의하기
    Context context;
    int layoutRes;
    List<CountryDto> list;
    //Layout xml 문서를 전개해서 view 객체를 만들 레이아웃 전개자 객체
    LayoutInflater inflater;

    //생성자 정의하기
    public CountryAdapter(Context context, int layoutRes, List<CountryDto>list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
        //레이아웃 전개자 객체의 참조값을 얻어와서 멤버필드에 저장
        inflater = LayoutInflater.from(context);
    }

    // 모델의 사이즈를 리턴
    @Override
    public int getCount() {
        return list.size();
    }
    //인자로 전달된 인덱스에 해당하는 모델안에 저장된 객체를 리턴해준다.
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    //인자로 전달된 인덱스에 해당되는 아이템의 아이디가 있으면 리턴해준다.
    @Override
    public long getItemId(int position) {
        //없으면 position 을 그대로 리턴
        return position;
    }

    //position 에 해당되는 셀 View 객체를 리턴해준다.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.e("getView()", "position:"+position);
        //처음에는 convertView 에 null 이 전달된다.
        if(convertView == null){
            //레이아웃 전개자 객체를 이용해서 셀 View 를 만든다.
            convertView = inflater.inflate(layoutRes, parent, false);
            //로그에 출력해보기
            Log.e("getView()","convertView == null");
        }
        //셀에 전개된 객체의 참조값을 얻어온다.
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.imageView);
        TextView textView = (TextView)
                convertView.findViewById(R.id.textView);
        //position 에 해당하는 데이터를 모델에서 불러온다.
        CountryDto dto = list.get(position);
        //셀에 데이터를 출력한다
        imageView.setImageResource(dto.getImageResId());
        textView.setText(dto.getName());
        //구성된 셀 뷰를 리턴해준다.
        return convertView;
    }
}

