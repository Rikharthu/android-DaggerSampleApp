package com.example.rikharthu.daggersampleapp.di;

import com.example.rikharthu.daggersampleapp.lobby.LobbyHelloService;

import dagger.Module;
import dagger.Provides;

/**
 * Define LobbyActivity-specific dependencies here
 */
@Module
public class LobbyActivityModule {

    @Provides
    LobbyHelloService provideLobbyHelloService() {
        return new LobbyHelloService();
    }
}
