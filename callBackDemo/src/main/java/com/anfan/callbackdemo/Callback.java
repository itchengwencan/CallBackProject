package com.anfan.callbackdemo;

/**
 * Created by chengwencan on 16/9/4.
 * 异步加载公共回调接口
 */
public interface Callback<E> {

    void get(E date);
}
