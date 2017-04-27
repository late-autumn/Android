package com.example.step08broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 방송 수신자 객체를 생성하는 클래스 정의하기
 *
 *  1. BroadcastReciver 추상 클래스 상속 받기
 *  2. onReceive() 메소드 오버라이딩하기
 *  3. AndroidManifest.xml 에 등록하고 어떤 이름의 방송을 받을지 명시 해야한다.
 */

public class ReceiverType1 extends BroadcastReceiver{

    //2.
    @Override
    public void onReceive(Context context, Intent intent) {
        //방송이 수신 되었을때 하고 싶은 작업을 여기서 하면 된다.
        Toast.makeText(context,"TYPE1 방송 수신됨",Toast.LENGTH_SHORT).show();
    }
}
