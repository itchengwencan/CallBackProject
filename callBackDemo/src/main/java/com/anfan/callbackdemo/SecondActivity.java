package com.anfan.callbackdemo;

public class SecondActivity {

    public SecondActivity() {

    }

    public SecondActivity(GiftCallback2 giftCallback2) {

        giftCallback2.callBack("构造函数传递过来的回调数据");

    }

    public GiftCallback2 giftCallback2;

    // 定义一个接口，接口中定义方法
    public interface GiftCallback2 {
        void callBack(String msg);
    }

    public void setGiftCallback2(GiftCallback2 giftCallback) {
        this.giftCallback2 = giftCallback;
        giftCallback2.callBack("回调的数据，在这里拿到回调的数据");
    }

    public void callBackMethod(GiftCallback2 giftCallback2) {
        giftCallback2.callBack("回调的数据，在这里拿到回调的数据");
    }

    public void callback(Callback<String> callback) {
        callback.get("公共回调拿到的数据");
    }

}
