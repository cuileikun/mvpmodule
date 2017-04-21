package com.cuileikun.architecture.presenter;

import android.content.Context;

import com.cuileikun.architecture.api.ResponseResult;
import com.cuileikun.architecture.contract.WelcomeContract;
import com.qk.applibrary.listener.ResponseResultListener;
import com.qk.applibrary.util.CommonUtil;

/**
 * 作者：popular cui
 * 时间：2017/4/21 10:31
 * 功能:欢迎界面处理器
 */
public class WelcomePresenter extends WelcomeContract.Presenter {
    @Override
    public void sendGetVersionNameRequest(String platform, String version) {
        if (CommonUtil.checkNetwork(mContext)) {
            if (validateGetVersionName(mContext, platform, version)) {
                v.openProgressDialog("加载中", "");
                m.getVersionName(platform, version, new ResponseResultListener() {
                    @Override
                    public void onResult(Object o) {
                        ResponseResult result = (ResponseResult) o;
                        v.closeProgressDialog();
                        if (result.code == ResponseResult.SUCESS_CODE) {
                            /**
                             * 登录成功。通知界面刷新ui
                             */
                            v.getVersionNameSuccess(result.data);
                        } else {
                            /**
                             * 登陆失败,通知界面刷新ui
                             */
                            v.getVersionNameFail(result.message);
                        }
                    }
                });
            }
        }

    }

    @Override
    public boolean validateGetVersionName(Context mContext, String platform, String version) {
        boolean loginFlag = false;
        if (CommonUtil.isEmpty(platform)) {
            CommonUtil.sendToast(mContext, "应用平台不能为空");
        } else if (CommonUtil.isEmpty(version)) {
            CommonUtil.sendToast(mContext, "应用版本号不能为空");
        } else {
            loginFlag = true;
        }
        return loginFlag;
    }

}
