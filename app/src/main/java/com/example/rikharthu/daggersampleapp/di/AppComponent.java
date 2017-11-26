package com.example.rikharthu.daggersampleapp.di;

import com.example.rikharthu.daggersampleapp.App;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        // Use AndroidInjectionModule.class if you're not using support library
        AndroidSupportInjectionModule.class,
        AppModule.class,
        BuildersModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

    /*
    Members-injection methods have a single parameter and inject dependencies into each
    of the Inject-annotated fields and methods of the passed instance. A members-injection
    method may be void or return its single parameter as a convenience for chaining.
    The following are all valid members-injection method declarations:
     */
    void inject(App app);
}
