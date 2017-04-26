package com.example.step06asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText inputUrl,console;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputUrl=(EditText)findViewById(R.id.inputUrl);
        console=(EditText)findViewById(R.id.console);
    }
    //요청 버튼을 눌렀을때 호출되는 메소드
    public void request(View v){
        //입력한 url 주소를 읽어온다.
        String urlAddr=inputUrl.getText().toString();
        // 비동기 작업 객체를 실행 시킨다.
        new DownTask().execute(urlAddr);
    }
    /*
        비동기 작업객체를 생성할 클래스 정의하기
        -AsyncTask 추상 클래스를 상속받아서 만든다.
        AsyncTask<파라미터 Type, 진행중 Type, 결과 Type>
     */
    public class DownTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            //파라미터로 전달된 요청 url 주소를 읽어온다.
            String urlAddr=params[0];
            //서버가 http 요청에 대해서 응답하는 문자열을 누적할 객체
            StringBuilder builder=new StringBuilder();
            HttpURLConnection conn=null;
            InputStreamReader isr=null;
            BufferedReader br=null;

            String result=null;
            try{
                //URL 객체 생성
                URL url=new URL(urlAddr);
                //HttpURLConnection 객체의 참조값 얻어오기
                conn=(HttpURLConnection)url.openConnection();
                if(conn!=null){//연결이 되었다면
                    conn.setConnectTimeout(20000); //응답을 기다리는 최대 대기 시간
                    conn.setUseCaches(false);//케쉬 사용 여부
                    //응답 코드를 읽어온다.
                    int responseCode=conn.getResponseCode();
                    if(responseCode==200){//정상 응답이라면...
                        //서버가 출력하는 문자열을 읽어오기 위한 객체
                        isr=new InputStreamReader(conn.getInputStream());
                        br=new BufferedReader(isr);
                        //반복문 돌면서 읽어오기
                        while(true){
                            //한줄씩 읽어들인다.
                            String line=br.readLine();
                            //더이상 읽어올 문자열이 없으면 반복문 탈출
                            if(line==null)break;
                            //읽어온 문자열 누적 시키기
                            builder.append(line);
                        }
                        //출력받은 문자열 전체 얻어내기
                        result=builder.toString();
                    }
                }
            }catch(Exception e){//예외가 발생하면
                //예외 메세지 리턴하기
                return e.getMessage();
            }finally {
                try{
                    if(isr!=null)isr.close();
                    if(br!=null)br.close();
                    if(conn!=null)conn.disconnect();
                }catch(Exception e){}
            }

            //console.setText(result); //호출 불가

            //결과 문자열을 리턴해준다.
            return result;
        }
        // doInBackground() 메소드에서 리턴된 값이 이 메소드의 인자로 전달된다.
        @Override
        protected void onPostExecute(String s) {
            //여기는 UI Thread 이다.
            console.setText(s);
        }
    }
}





