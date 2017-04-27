package com.example.setop07webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //필요한 멤버 필드 정의하기
    EditText inputUrl;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputUrl = (EditText)findViewById(R.id.inputUrl);
        //WebView 의 참조값 얻어와서 멤버필드에 저장하기
        webView = (WebView)findViewById(R.id.webView);

        //WebView 설정하기
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
    }
    //이동버튼을 눌렀을때 실행되는 메소드
    public void move(View v){
        //입력한 URL 주소를 읽어와서
        String url = inputUrl.getText().toString();
        //WebView 객체가 로딩하도록 한다.
        webView.loadUrl(url);
    }
}
