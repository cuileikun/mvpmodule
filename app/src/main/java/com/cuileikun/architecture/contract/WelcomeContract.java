package com.cuileikun.architecture.contract;

import android.content.Context;

import com.qk.applibrary.listener.ResponseResultListener;
import com.qk.applibrary.model.BaseModel;
import com.qk.applibrary.presenter.BasePresenter;
import com.qk.applibrary.view.BaseView;

/**
 * 作者：popular cui
 * 时间：2017/4/21 10:33
 * 功能:契约类
 * 管理欢迎view与presenter的所有的类,维护方便.
 */
public interface WelcomeContract {


    interface Model extends BaseModel {

        /**
         * 处理获取版本请求
         *  @param platform
         * @param version
         * @param listener
         */
        public void getVersionName(String platform, String version, ResponseResultListener listener);
    }

    interface View extends BaseView {
        /**
         * 获取版本号成功
         *
         * @param json
         */
        public void getVersionNameSuccess(String json);

        /**
         * 获取版本号失败
         *
         * @param error
         */
        public void getVersionNameFail(String error);

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        /**
         * 发送获取版本号请求
         *
         * @param platform
         * @param version
         */
        public abstract void sendGetVersionNameRequest(String platform, String version);

        /**
         * 验证请求参数
         *
         * @param platform
         * @param version
         * @param mContext
         * @return
         */
        public abstract boolean validateGetVersionName(Context mContext, String platform, String version);
    }


}
