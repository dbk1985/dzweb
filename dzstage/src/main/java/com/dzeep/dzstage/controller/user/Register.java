package com.dzeep.dzstage.controller.user;

import com.dzeep.dzframe.controller.Base;
import com.dzeep.dzstage.model.UserInfo;

/**
 * Created by fighting on 15/9/13.
 */
public class Register extends Base{
    private UserInfo userInfo;
    @Override
    public String execute() throws Exception {
        userInfo = new UserInfo();
        return SUCCESS;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
