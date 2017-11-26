package com.example.rikharthu.daggersampleapp.di;

import com.example.rikharthu.daggersampleapp.LobbyActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Defines bindings for sub-components so that Dagger can inject them
 */
@Module
public abstract class BuildersModule {
    /*
    Note that @ContributesAndroidInjector annotation (introduced in 2.11) frees us
    from having to create separate components annotated with @Subcomponent
     */

    //    @ContributesAndroidInjector
    @ContributesAndroidInjector(modules = LobbyActivityModule.class)
    abstract LobbyActivity bindLobbyActivity();

    // Add bindings for other sub-components here
}
