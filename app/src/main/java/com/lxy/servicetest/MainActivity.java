package com.lxy.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start;
    private Button btn_stop;
    private Button btn_bind;
    private Button btn_unbind;
    private BindServiceTest.Mybinder myBinder;
    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBinder = (BindServiceTest.Mybinder) iBinder;
                myBinder.start();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
    }

    private void initListener() {
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_bind.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);
    }

    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_stop = (Button) findViewById(R.id.btn_stop);
        btn_bind = (Button) findViewById(R.id.btn_bind);
        btn_unbind = (Button) findViewById(R.id.btn_unbind);

    }

    @Override
    public void onClick(View view) {
        Intent startintent = new Intent(this, ServiceTest.class);
        Intent bindintent = new Intent(this, BindServiceTest.class);
        switch (view.getId()) {
            case R.id.btn_start:
                startService(startintent);
                Log.e("123", "onClick: start");
                break;
            case R.id.btn_stop:
                stopService(startintent);
                break;
            case R.id.btn_bind:
                bindService(bindintent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.btn_unbind:
                unbindService(connection);
                break;
        }
    }

}
