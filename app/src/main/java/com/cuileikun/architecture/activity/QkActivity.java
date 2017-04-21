package com.cuileikun.architecture.activity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.qk.applibrary.model.BaseModel;
import com.qk.applibrary.presenter.BasePresenter;
import com.qk.applibrary.util.GenericsUtils;
import com.qk.applibrary.view.BaseActivity;
import com.qk.applibrary.view.BaseView;

/**
 * Created by acer on 2016-7-19.
 * 青客界面基类
 */
public abstract class QkActivity<P extends BasePresenter,M extends BaseModel> extends BaseActivity {
    public P mPresenter;
    public M mModel;

    @Override
    public ProgressDialog showProgressDialog(String title, String message) {
        try {
            if (isFinishing() == false) {
                if (loadingProgressDialog == null) {
                    loadingProgressDialog = ProgressDialog.show(this, title,
                            message);
                    loadingProgressDialog.setCancelable(false);
//                    loadingProgressDialog.setCanceledOnTouchOutside(true);
                } else {
                    loadingProgressDialog.setTitle(title);
                    loadingProgressDialog.setMessage(message);
                    if (loadingProgressDialog.isShowing() == false) {
                        loadingProgressDialog.show();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadingProgressDialog;
    }

    @Override
    public void dissmissProgressDialog() {
        try {
            if (isFinishing() == false && loadingProgressDialog != null) {
                loadingProgressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = GenericsUtils.getParameterizedType(this,0);
        mModel =  GenericsUtils.getParameterizedType(this,1);
        if(this instanceof BaseView) {
            mPresenter.attachView(this,mModel,this);
        }
        super.onCreate(savedInstanceState);

    }
}
