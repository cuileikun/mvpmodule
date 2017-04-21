package com.cuileikun.architecture.contract;

import android.content.Context;

import com.qk.applibrary.listener.ResponseResultListener;
import com.qk.applibrary.model.BaseModel;
import com.qk.applibrary.presenter.BasePresenter;
import com.qk.applibrary.view.BaseView;

/**
 * 契约类
 * 管理登录view与presenter的所有的类,维护方便.
 * Created by acer on 2016-9-21.
 */
public interface LoginContract {
    interface Model extends BaseModel {

        /**
         * 处理登录请求
         * @param username
         * @param password
         * @param deviceId
         * @param system
         * @param mContext
         * @param listener
         */
        public void doLoginRequest(Context mContext, String username, String password, String deviceId, String system, ResponseResultListener listener) ;
    }

    interface View  extends BaseView {
        /**
         * 登录成功
         * @param json
         */
        public void loginSucess(String json);
        /**
         * 登录失败
         * @param error
         */
        public void loginFailed(String error);

    }

    abstract class Presenter extends BasePresenter<View,Model> {
        /**
         * 发送登录请求
         * @param username
         * @param password
         * @param deviceId
         * @param system
         */
        public abstract void sendLoginRequest(String username, String password, String deviceId, String system);
        /**
         * 验证登录
         * @param userName
         * @param password
         * @param mContext
         * @return
         */
        public abstract boolean validateLogin(Context mContext, String userName, String password) ;
    }
}
