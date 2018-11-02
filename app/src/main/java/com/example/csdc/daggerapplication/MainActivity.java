package com.example.csdc.daggerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.jump);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        //DaggerAppComponent.create().inject(this);//注入
        APP.get(MainActivity.this).getHttpClientComponent().inject(this);//1
        Log.d("lqw","MainActivity"+mOkHttpClient.hashCode());
        Log.d("lqw","MainActivity"+mProduct.hashCode());
        Log.d("lqw","MainActivity"+mProduct1.hashCode());
        /*HttpClientComponent component = DaggerHttpClientComponent.builder()//2
                .httpActivityModule(new HttpActivityModule()).build();
        component.inject(this);*/

        //1和2的注入表达式虽然不同，但实际上一样的，create（）方法实现的就是
        // builder().httpActivityModule(new HttpActivityModule()).build()这段代码
    }
}
