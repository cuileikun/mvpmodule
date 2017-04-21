package com.cuileikun.architecture.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.cuileikun.architecture.R;
import com.cuileikun.architecture.contract.WelcomeContract;
import com.cuileikun.architecture.model.WelcomeModel;
import com.cuileikun.architecture.presenter.WelcomePresenter;

public class WelcomeActivity extends QkActivity<WelcomePresenter, WelcomeModel> implements WelcomeContract.View {
    public static WelcomeActivity mInstance = null;
    private Context mContext;

    private Button test_mvp_btn;

    @Override
    public void initViews() {
        test_mvp_btn = (Button) findViewById(R.id.test_mvp_btn);
    }

    @Override
    public void initData() {
        mInstance = this;
        mContext = this;

    }

    @Override
    public void addListeners() {
        test_mvp_btn.setOnClickListener(getVersionNameListener);
    }

    private View.OnClickListener getVersionNameListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void getVersionNameSuccess(String json) {

    }

    @Override
    public void getVersionNameFail(String error) {

    }

    @Override
    public ProgressDialog openProgressDialog(String title, String message) {
        return null;
    }

    @Override
    public void closeProgressDialog() {

    }
}
