package com.example.rikharthu.daggersampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rikharthu.daggersampleapp.common.CommonHelloService;
import com.example.rikharthu.daggersampleapp.lobby.LobbyHelloService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class LobbyActivity extends AppCompatActivity {

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);
        ButterKnife.bind(this);

        // Inject dependencies
        // Corresponding injector defined in BuildersModule as @ContributesAndroidInjector
        AndroidInjection.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sayCommonHello();
        sayLobbyHello();
    }

    private void sayLobbyHello() {
        mCommonHelloTv.setText(mCommonHelloService.sayHello());
    }

    private void sayCommonHello() {
        mCommonHelloTv.setText(mCommonHelloService.sayHello());
    }
}
