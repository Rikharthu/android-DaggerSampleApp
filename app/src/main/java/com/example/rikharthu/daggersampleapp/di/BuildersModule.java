package com.example.rikharthu.daggersampleapp.di;

import com.example.rikharthu.daggersampleapp.LobbyActivity;
import com.example.rikharthu.daggersampleapp.LobbyFragment;

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

    @ContributesAndroidInjector(modules = LobbyFragmentModule.class)
    // or gain access to lobby activity dependencies from fragment via
    // @ContributesAndroidInjector(modules = {LobbyFragmentModule.class, LobbyActivityModule.class})
    abstract LobbyFragment bindLobbyFragment();

    // Add bindings for other sub-components here
}
