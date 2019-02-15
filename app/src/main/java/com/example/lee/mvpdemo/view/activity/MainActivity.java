package com.example.lee.mvpdemo.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lee.mvpdemo.R;
import com.example.lee.mvpdemo.presenter.LoginActivityPresenter;
import com.example.lee.mvpdemo.presenter.impl.LoginPresenterImpl;
import com.example.lee.mvpdemo.view.iView.ILoginActivity;



public class MainActivity extends Activity implements ILoginActivity {

    private LoginPresenterImpl mLoginPresenter;
    private EditText mUid,mPwd;
    private Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initVar();          //初始化一些参数变量
        initUI();           //初始化布局
        initListener();     //初始化监听事件
    }


//    private void initVar() {
//        mLoginPresenter = new LoginPresenterImpl(this);
//    }

    private void initUI() {
        mUid = findViewById(R.id.login_activity_uid);
        mPwd = findViewById(R.id.pwd);
        mLogin = findViewById(R.id.loginBtn);
    }

    private void initListener() {
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("触发：onClick");
                getPresenter().login(mUid.getText().toString(),mPwd.getText().toString());
            }
        });
    }

    private LoginActivityPresenter getPresenter(){
        if(null == mLoginPresenter){
            mLoginPresenter = new LoginPresenterImpl(this);
        }
        return mLoginPresenter;
    }


    //登录成功回调
    @Override
    public void loginSuccess(int resultCode, final String msg) {
        System.out.println("触发：loginSuccess");
        System.out.println("触发：msg:"+msg);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(!TextUtils.isEmpty(msg)){
                    Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                }
            }
        });
//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this,SecondActivity.class);
//        startActivity(intent);
    }

    //登录失败回调
    @Override
    public void loginFailed(int resultCode, final String msg) {
        System.out.println("触发：loginFailed");
        System.out.println("触发：msg:"+msg);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(!TextUtils.isEmpty(msg)){
                    Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
