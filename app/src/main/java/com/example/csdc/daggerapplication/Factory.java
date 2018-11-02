package com.example.csdc.daggerapplication;


import android.util.Log;

import javax.inject.Inject;

/**
 * Created by csdc on 2018/10/17.
 */

public class Factory {

    Product mProduct;

    @Inject
    public Factory(Product product){
        this.mProduct = product;
        Log.d("lqw","dagger_factory");
    }
}
