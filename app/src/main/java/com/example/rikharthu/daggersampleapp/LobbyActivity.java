package com.example.rikharthu.daggersampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rikharthu.daggersampleapp.common.CommonHelloService;
import com.example.rikharthu.daggersampleapp.lobby.LobbyHelloService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class LobbyActivity extends AppCompatActivity
        implements HasSupportFragmentInjector {
    // Activity must implement the HasSupportFragmentInjector to support injecting fragments in
    // their onAttach() callbacks

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    CommonHelloService mCommonHelloService;
    @Inject
    LobbyHelloService mLobbyHelloService;

    @BindView(R.id.common_hello)
    TextView mCommonHelloTv;
    @BindView(R.id.lobby_hello)
    TextView mLobbyHelloTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        ButterKnife.bind(this);

        // Inject dependencies
        // Corresponding injector defined in BuildersModule as @ContributesAndroidInjector
    }

    @Override
    protected void onResume() {
        super.onResume();

        sayCommonHello();
        sayLobbyHello();
    }

    private void sayLobbyHello() {
        mLobbyHelloTv.setText(mLobbyHelloService.sayHello());
    }

    private void sayCommonHello() {
        mCommonHelloTv.setText(mCommonHelloService.sayHello());
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
