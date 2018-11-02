package com.example.csdc.daggerapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by csdc on 2018/11/2.
 */

public class APP extends Application{
    HttpClientComponent mHttpClientComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("lqw","Application");
        mHttpClientComponent = DaggerHttpClientComponent.builder().build();// 会在这里报错
    }

    public static APP get(Context context){
        return (APP) context.getApplicationContext();
    }

    public HttpClientComponent getHttpClientComponent(){
        return mHttpClientComponent;
    }
}
