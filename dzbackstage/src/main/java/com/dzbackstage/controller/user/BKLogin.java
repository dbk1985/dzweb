package com.dzbackstage.controller.user;

import com.dzeep.dzframe.controller.DZController;

/**
 * Created by fighting on 15/9/16.
 */
public class BKLogin extends DZController {

    @Override
    public String execute() throws Exception {
        String session = (String)getSession().get("account");
        if (session == null){
            return LOGIN;
        }
        return SUCCESS;
    }
}
