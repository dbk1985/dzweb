package com.dzeep.dzstage.controller.user;

import com.dzeep.dzframe.controller.DZController;
import com.dzeep.dzstage.model.UserInfo;

/**
 * Created by fighting on 15/9/13.
 */
public class Register extends DZController {
    private UserInfo userInfo;
    private String userName;

    @Override
    public String execute() throws Exception {
        userInfo = new UserInfo();
        if (userName != null)
            getUserInfo().setUserName(userInfo.getUserName()+":"+getUserName());
        return SUCCESS;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
