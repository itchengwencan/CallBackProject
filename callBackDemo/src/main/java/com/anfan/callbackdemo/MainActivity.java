package com.anfan.callbackdemo;

import com.anfan.callbackdemo.SecondActivity.GiftCallback2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
        GiftCallback2 {

    private Button bt_request;
    private TextView tv_content;

    // 主线程在某一时刻开启子线程来做请求数据的操作,子线程在请求网络拿到数据后(不管是失败还是成功,都要通知主线程去更新UI)

    // 如何通知主线程去更新UI：设置回调

    // 设置回调的步奏：(定义一个接口，接口中定义方法(需要参数设置参数),(主线程要在适当的位置拿到子线程对象调用设置回调的方法)子线程在拿到数据后用接口调用方法回调给主线程)

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        bt_request = (Button) findViewById(R.id.bt_request);

        tv_content = (TextView) findViewById(R.id.tv_content);

        bt_request.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_request:

                SecondActivity secondActivity = new SecondActivity();

                // //第三种方式的回调
                // SecondActivity secondActivity = new SecondActivity(
                // new GiftCallback2() {
                //
                // @Override
                // public void callBack(String msg) {
                // tv_content.setText(msg);
                //
                // Toast.makeText(MainActivity.this, msg,
                // Toast.LENGTH_LONG).show();
                //
                // }
                // });

                // 第一种方式做的回调
                secondActivity.setGiftCallback2(this);

                // 第二种方式做的回调常用的方式
                secondActivity.callBackMethod(new GiftCallback2() {
                    @Override
                    public void callBack(String msg) {
                        tv_content.setText(msg);
                    }
                });

                //抽出公共回调类
                secondActivity.callback(new Callback<String>() {
                    @Override
                    public void get(String date) {
                        Toast.makeText(MainActivity.this, date, Toast.LENGTH_SHORT).show();

                    }
                });

                break;

            case R.id.tv_content:

                break;

            default:

                break;
        }

    }

    // 拿到传过来的数据第一种方式的回调拿到的数据
    @Override
    public void callBack(String msg) {
        tv_content.setText(msg);
    }

}
