package com.example.csdc.daggerapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class SecondActivity extends AppCompatActivity {
    @Inject
    OkHttpClient mOkHttpClient;
    @Inject
    @Named("A")
    Product mProduct;
    @Inject
    @Named("B")
    Product mProduct1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        APP.get(SecondActivity.this).getHttpClientComponent().inject(this);

        Log.d("lqw","SecondActivity"+mOkHttpClient.hashCode()); //与第二个Activity比较，由于创建的不是单例，因此创建的对象的hashcode不一样
        Log.d("lqw","SecondActivity"+mProduct.hashCode());
        Log.d("lqw","SecondActivity"+mProduct1.hashCode());
    }
}
