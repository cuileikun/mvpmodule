package com.cuileikun.architecture.presenter;

import android.content.Context;

import com.cuileikun.architecture.api.ResponseResult;
import com.cuileikun.architecture.contract.LoginContract;
import com.qk.applibrary.listener.ResponseResultListener;
import com.qk.applibrary.util.CommonUtil;
/**
 * Created by acer on 2016-9-21.
 * 登录处理器
 */
public class LoginPresenter extends LoginContract.Presenter {
    /**
     * 发送登录请求
     * @param userName  用户名
     * @param password 密码
     * @param deviceId 设备id
     * @param system 系统标识
     */
    @Override
    public void sendLoginRequest(String userName, String password, String deviceId, String system) {
        if(CommonUtil.checkNetwork(mContext)) {
            if(validateLogin(mContext,userName,password)) {
                    v.openProgressDialog("加载中","");
                    m.doLoginRequest(mContext, userName, password, deviceId, system, new ResponseResultListener() {
                        @Override
                        public void onResult(Object o) {
                            ResponseResult result = (ResponseResult)o;
                            v.closeProgressDialog();
                            if(result.code == ResponseResult.SUCESS_CODE) {
                                /**
                                 * 登录成功。通知界面刷新ui
                                 */
                                v.loginSucess(result.data);
                            } else {
                                /**
                                 * 登陆失败,通知界面刷新ui
                                 */
                                v.loginFailed(result.message);
                            }
                        }
                    });
                }
            }

        }


    /**
     * 验证登录参数有没有问题
     * @param mContext 上下文
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public boolean validateLogin(Context mContext, String userName, String password) {
        boolean loginFlag = false;
        if(CommonUtil.isEmpty(userName)) {
            CommonUtil.sendToast(mContext,"用户名不能为空");
        } else if(CommonUtil.isEmpty(password)) {
            CommonUtil.sendToast(mContext,"密码不能为空");
        } else {
            loginFlag = true;
        }
        return loginFlag;
    }
}
