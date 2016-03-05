package com.dzeep.dzstage.controller;

import com.dzeep.dzframe.controller.DZController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by alan on 15/10/7.
 * 基础类
 */
public abstract class DZAction extends DZController {
    private String action;          //动作
    private String title;           //页面标题
    private String responseData;    //jsonData
    protected void createJSonData(String jsonData) {
        setResponseData(jsonData);
    }
    public String getResponseData() {
        return responseData;
    }
    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    protected Log log = LogFactory.getLog(getClass());      //日志记录器

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String execute() throws Exception {          //默认list方法
        String actionResult = list();
        if (actionResult != null) return actionResult;
        return NONE;
    }

    public abstract String list();
}
