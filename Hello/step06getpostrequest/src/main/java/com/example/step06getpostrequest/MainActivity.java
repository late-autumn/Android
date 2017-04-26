package com.example.step06getpostrequest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Util.RequestListener{

    private static final String REQUEST_URL = "http://study.kimgura.net/members";

    //필요한 멤버필드 정의하기
    EditText console;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        console = (EditText)findViewById(R.id.console);
    }
    public void getMember(View v){

/*        //요청하면서 서버에 전달할 파라미터가 있다면 Map 객체를 생성해서
        Map<String,String> map = new HashMap<>();
        //map에 담을때 키값이 서버에서 해당 파라미터를 추출할때 파라미터 명이 된다.
        map.put("id","gura");   //"id"가 파라미터 명이다.
        map.put("pwd","1234");
*/
        /*
            서버측 java 코드
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");

         */

        //Util 을 이용해서 요청을 하고 결과를 받아온다.
        Util.sendGetRequest(0,REQUEST_URL,map,this);
    }
    //요청이 성공적으로 끝났을때 호출되는 메소드
    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        if(requestId==0){
            //"data"라는 키값으로 서버가 응답한 문자열이 들어있다. (JSON)
            String jsonStr =(String)result.get("data");
            //Toast.makeText(this,jsonStr,Toast.LENGTH_SHORT).show();
            //console.setText(jsonStr);

            try{
                //json 문자열을 이용해서 JSONObject 객체를 생성한다.
                JSONObject obj = new JSONObject(jsonStr);
                //members 라는 키값으로 저장된 JSONArray 객체 얻어오기
                JSONArray arr= obj.getJSONArray("members");
                for(int i=0; i<arr.length();i++){
                   //i번째 JSONObject 추출
                    JSONObject tmp = arr.getJSONObject(i);
                    //번호
                    int num = tmp.getInt("num");
                    //이름
                    String name=tmp.getString("name");
                    //주소
                    String addr = tmp.getString("addr");
                    //정보 구성하기
                    String info="번호:"+num+" 이름:"+name+" 주소:"+addr;
                    //출력하기
                    console.append(info+"\n");

                }
            }catch(JSONException je){
                console.setText(je.getMessage());
            }
        }
    }

    //요청이 실패 했을때 호출되는 메소드
    @Override
    public void onFail(int requestId, Map<String, Object> result) {
        if(requestId==0){
            //"data"라는 키값으로 예외 메세지가 담겨있다.
            String errMsg = (String)result.get("data");
            Toast.makeText(this,errMsg,Toast.LENGTH_SHORT).show();
        }
    }
}
