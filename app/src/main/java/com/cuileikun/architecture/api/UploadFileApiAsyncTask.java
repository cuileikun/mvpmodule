package com.cuileikun.architecture.api;

import android.content.Context;

import com.qk.applibrary.api.BaseUploadFileApiAsyncTask;
import com.qk.applibrary.util.LogUtil;

/**
 * Created by acer on 2016-9-19.
 * 调用后台接口上传文件
 */
public class UploadFileApiAsyncTask extends BaseUploadFileApiAsyncTask {
    public UploadFileApiAsyncTask(Context context) {
        super(context);
    }

    @Override
    public void requestFailed(String content) {
        LogUtil.log("error:" + content, mApiLogFileDirectory, mApiLogFileName);
        ResponseResult result = new ResponseResult();
        result.code = -1;
        result.message = "连接失败";
        callPicListener.onResult(result);
    }

    @Override
    protected void requestSucessed(String result) {
        ResponseResult data = new ResponseResult();
        data.code = ResponseResult.SUCESS_CODE;
        data.data = result;
        data.message = "";
        callPicListener.onResult(data);
    }
}
