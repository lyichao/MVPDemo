package com.example.lee.mvpdemo.view.iView;
public interface ILoginActivity {
    //用于验证成功后返回
    void loginSuccess(int resultCode, String msg);
    //用于验证成失败后返回
    void loginFailed(int resultCode, String msg);
}
