package com.cuileikun.architecture.model;

import android.content.Context;

import com.cuileikun.architecture.api.ApiAsyncTask;
import com.cuileikun.architecture.api.Protocol;
import com.cuileikun.architecture.api.QkBuildConfig;
import com.cuileikun.architecture.contract.LoginContract;
import com.qk.applibrary.listener.ResponseResultListener;
import com.qk.applibrary.util.CommonUtil;

import java.util.HashMap;

/**
 * Created by acer on 2016-9-21.
 */
public class LoginModel implements LoginContract.Model {
    @Override
    public void doLoginRequest(Context mContext,String username, String password, String deviceId, String system, ResponseResultListener resultListener) {
        String loginUrl = QkBuildConfig.getInstance().getConnect().getApiUrl() + Protocol.LOGIN_URl;
        HashMap<String, Object> params = new HashMap<String, Object>();
        HashMap<String, Object> headParams = new HashMap<String, Object>();
        ApiAsyncTask apiAsyncTask = new ApiAsyncTask(mContext);
        params.put("EmployeeAccount", username);
        params.put("Password", password);
        params.put("Device", deviceId);
        params.put("System", system);
        headParams.put("EmployeeAccount", username);
        headParams.put("Device", deviceId);
        String apiLogFileDirectory = CommonUtil.getSDCardPath() + "/test/log";
        String apiLogFileName = "test_api_log.txt";
        apiAsyncTask.post(apiLogFileDirectory, apiLogFileName, loginUrl, params, headParams,resultListener);
    }
}
