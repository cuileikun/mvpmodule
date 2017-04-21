package com.cuileikun.architecture.utils;

import com.qk.applibrary.util.CommonUtil;

/**
 * Created by acer on 2016-7-19.
 * 定义常量类
 */
public class Constant {
    /**
     * 日志常量
     */
    public static final class LogDef {
        /**
         * 本地文件基目录
         */
        public static final String FILE_BASE_DIRECTORY = CommonUtil.getSDCardPath() + "/" + "project";
        /**
         * 日志目录
         */
        public static final String logFileDirectory = FILE_BASE_DIRECTORY + "/log";
        /**
         * 日志名称
         */
        public static final String logFileName = "qk_api_log.txt";
    }
}
