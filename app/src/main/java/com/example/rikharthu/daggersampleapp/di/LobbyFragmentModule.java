package com.example.rikharthu.daggersampleapp.di;

import com.example.rikharthu.daggersampleapp.lobby.LobbyFragmentHelloService;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyFragment-specific dependencies here.
 */
@Module
public class LobbyFragmentModule {

    @Provides
    LobbyFragmentHelloService provideLobbyFragmentHelloService() {
        return new LobbyFragmentHelloService();
    }
}