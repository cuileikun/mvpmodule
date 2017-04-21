package com.cuileikun.architecture.api;

import android.content.Context;

import com.qk.applibrary.api.BaseApiAsyncTask;
import com.qk.applibrary.util.LogUtil;

/**
 * 调用后台api
 * Created by acer on 2016-5-12.
 */
public class ApiAsyncTask extends BaseApiAsyncTask {
    public ApiAsyncTask(Context context) {
        super(context);
    }

    @Override
    public void requestSucessed(String result) {
        ResponseResult data = new ResponseResult();
        data.result = ResponseResult.SUCESS_CODE;
        data.data = result;
        data.message = "";
        mListener.onResult(data);

    }

    @Override
    public void requestFailed(Throwable error, String content) {
        LogUtil.log("error:" + error.getMessage() + ":" + content, apiLogFileDirectory, apiLogFileName);
        ResponseResult result = new ResponseResult();
        result.result = -1;
        result.message = "连接失败";
        mListener.onResult(result);
    }
}
