package com.lxy.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start;
    private Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
    }

    private void initView() {
        btn_start=(Button)findViewById(R.id.btn_start);
        btn_stop=(Button)findViewById(R.id.btn_stop);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,ServiceTest.class);
       switch (view.getId()){
           case R.id.btn_start:
               startService(intent);
               Log.e("123", "onClick: start" );
               break;
           case R.id.btn_stop:
               stopService(intent);
               break;
       }
    }
}
