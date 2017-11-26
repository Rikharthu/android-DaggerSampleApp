package com.example.rikharthu.daggersampleapp.di;

import android.content.Context;

import com.example.rikharthu.daggersampleapp.App;
import com.example.rikharthu.daggersampleapp.common.CommonHelloService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Inject Application wide dependencies
 */
@Module
public class AppModule {

    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    CommonHelloService provideCommonHelloService() {
        return new CommonHelloService();
    }
}
