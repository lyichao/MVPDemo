package com.example.lee.mvpdemo.presenter.impl;

import android.text.TextUtils;
import com.example.lee.mvpdemo.presenter.LoginActivityPresenter;
import com.example.lee.mvpdemo.view.iView.ILoginActivity;

public class LoginPresenterImpl implements LoginActivityPresenter {

    private ILoginActivity mIView;


    public  LoginPresenterImpl(ILoginActivity iLoginActivity){
        mIView = iLoginActivity;
    }

    @Override
    public void login(String uid, String pwd) {
        System.out.println("触发：login"+" "+"uid:"+uid+" "+"pwd:"+pwd);
        if(TextUtils.isEmpty(uid)){
            mIView.loginFailed(0,"账号不能为空");
        }else if(TextUtils.isEmpty(pwd)){
            mIView.loginFailed(0,"密码不能为空");
        }else if(uid.equals("chaoiscool")  && pwd.equals("123456")){
            mIView.loginSuccess(1,"登录成功");
        }else {
            mIView.loginFailed(1,"登录失败");
        }
    }
}
