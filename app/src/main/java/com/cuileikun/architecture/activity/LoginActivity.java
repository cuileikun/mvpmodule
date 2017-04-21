package com.cuileikun.architecture.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cuileikun.architecture.R;
import com.cuileikun.architecture.contract.LoginContract;
import com.cuileikun.architecture.model.LoginModel;
import com.cuileikun.architecture.presenter.LoginPresenter;
import com.qk.applibrary.listener.TopbarImplListener;
import com.qk.applibrary.util.CommonUtil;
import com.qk.applibrary.widget.TopbarView;


/**
 * 登录界面
 */
public class LoginActivity extends QkActivity<LoginPresenter,LoginModel> implements LoginContract.View{
    private TopbarView topbarView;
    private Context mContext;
    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBt;


    @Override
    public void initViews() {
        topbarView = (TopbarView)findViewById(R.id.top_bar_view);
        userNameEt = (EditText)findViewById(R.id.user_name_tv);
        passwordEt = (EditText)findViewById(R.id.password_et);
        loginBt = (Button)findViewById(R.id.login_bt);
    }

    @Override
    public void initData() {
        mContext = this;
        topbarView.setTopbarTitle("演示mvp demo");
    }

    private View.OnClickListener loginListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            String userName = userNameEt.getText().toString();
            String password = passwordEt.getText().toString();
            mPresenter.sendLoginRequest(userName,password,"5545545454","android");
        }
    };

    @Override
    public void loginSucess(String json) {
        /**
         * 登录成功
         */
        CommonUtil.sendToast(mContext,json);
    }

    @Override
    public void loginFailed(String error) {
        /**
         * 登录失败
         */
        CommonUtil.sendToast(mContext,error);
    }

    private TopbarImplListener topbarListener = new TopbarImplListener() {

        @Override
        public void leftClick() {
            finish();
        }
    };

    @Override
    public void addListeners() {
        topbarView.setTopBarClickListener(topbarListener);
        loginBt.setOnClickListener(loginListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_mvp;
    }



    @Override
    public ProgressDialog openProgressDialog(String title, String message) {
        return showProgressDialog(title,message);
    }

    @Override
    public void closeProgressDialog() {
        dissmissProgressDialog();
    }
}
