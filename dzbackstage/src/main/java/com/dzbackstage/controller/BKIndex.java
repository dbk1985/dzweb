package com.dzbackstage.controller;

import com.dzeep.dzframe.controller.DZController;

/**
 * Created by fighting on 15/9/16.
 */
public class BKIndex extends DZController{
    private static int a=-1;
    @Override
    public String execute() throws Exception {
        a++;
        if (a % 2 != 0){
            return SUCCESS;
        }
        return LOGIN;
    }
}
