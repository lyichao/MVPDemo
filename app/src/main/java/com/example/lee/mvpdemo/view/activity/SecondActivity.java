package com.example.lee.mvpdemo.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lee.mvpdemo.R;

public class SecondActivity extends AppCompatActivity {

    private Button mLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initUI();
        initListener();
    }

    private void initUI() {
        mLoginBack = findViewById(R.id.loginOut);
    }

    private void initListener() {
        mLoginBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
