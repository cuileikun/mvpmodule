package com.cuileikun.architecture.model;

import android.content.Context;

import com.cuileikun.architecture.api.ApiAsyncTask;
import com.cuileikun.architecture.contract.WelcomeContract;
import com.qk.applibrary.listener.ResponseResultListener;
import com.qk.applibrary.util.CommonUtil;

import java.util.HashMap;

/**
 * 作者：popular cui
 * 时间：2017/4/21 10:32
 * 功能:联网获取版本号
 */
public class WelcomeModel implements WelcomeContract.Model {
    @Override
    public void getVersionName(Context mContext, String platform, String version, ResponseResultListener resultListener) {
//        String versionUrl = QkBuildConfig.getInstance().getConnect().getApiUrl() + Protocol.VERSION;
        String versionUrl="http://192.168.1.72:89/mdk/fgy/app/upgrade/version.json";
        HashMap<String, Object> params = new HashMap<String, Object>();
        HashMap<String, Object> headParams = new HashMap<String, Object>();
        ApiAsyncTask apiAsyncTask = new ApiAsyncTask(mContext);
        params.put("platform", "2");
        params.put("version", CommonUtil.getVersionCode(mContext));
        String apiLogFileDirectory = CommonUtil.getSDCardPath() + "/test/log";
        String apiLogFileName = "test_api_log.txt";
        apiAsyncTask.post(apiLogFileDirectory, apiLogFileName, versionUrl, params, headParams, resultListener);
    }
}
