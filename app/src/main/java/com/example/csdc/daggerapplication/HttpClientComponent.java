package com.example.csdc.daggerapplication;

import dagger.Component;

/**
 * Created by csdc on 2018/10/17.
 */
@Component (modules = HttpActivityModule.class)
@ApplicationScope
public interface HttpClientComponent {

    void inject (MainActivity mainActivity);

    void inject (SecondActivity secondActivity);
}
