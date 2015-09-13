package com.dzeep.dzstage.controller.user;

import com.dzeep.dzframe.controller.DZController;
import com.dzeep.dzstage.model.UserInfo;


/**
 * Created by fighting on 15/9/9.
 */
public class Login extends DZController {
    private UserInfo userInfoBean;  /** 登录用户信息模型 */

    @Override
    public String execute() throws Exception {
        userInfoBean = new UserInfo();
        return SUCCESS;
    }

    public UserInfo getUserInfoBean() {
        return userInfoBean;
    }

    public void setUserInfoBean(UserInfo userInfoBean) {
        this.userInfoBean = userInfoBean;
    }
}
