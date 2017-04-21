package com.cuileikun.architecture.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSON;
import com.cuileikun.architecture.R;
import com.cuileikun.architecture.bean.VersionBean;
import com.cuileikun.architecture.contract.WelcomeContract;
import com.cuileikun.architecture.model.WelcomeModel;
import com.cuileikun.architecture.presenter.WelcomePresenter;
import com.qk.applibrary.util.CommonUtil;

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
            mPresenter.sendGetVersionNameRequest("2", CommonUtil.getVersionCode(mContext));


        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void getVersionNameSuccess(String json) {
        VersionBean versionBean = JSON.parseObject(json, VersionBean.class);
//        String version = versionBean.getVersion();
//        String url = versionBean.getUrl();
        CommonUtil.sendToast(mContext,"获取版本号成功++++++");
        startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));

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
