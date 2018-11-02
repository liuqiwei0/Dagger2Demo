package com.example.csdc.daggerapplication;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by csdc on 2018/10/17.
 */
@Module
public class HttpActivityModule {

    @ApplicationScope
    @Provides
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Named("A")
    Product provideProductA(){
        return new ProductA();
    }

    @ApplicationScope
    @Provides
    @Named("B")
    Product provideProductB(){
        return new ProductB();
    }
}
