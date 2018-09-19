package com.example.modularizationtest.view;

import android.app.Application;
import android.util.Log;

/**
 * Author：白树 on 2018/9/14 11:14
 * <p>
 * Email:  gusumobai@163.com
 */
public class ShopApplication implements ApplicationImpl{

    private static final String TAG = "ShopApplication";

    @Override
    public void onCreate(Application baseApplication) {
        Log.e(TAG,"初始化ShopApplication");
    }

}
