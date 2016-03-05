package com.dzeep.dzstage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;

/**
 * Created by alan on 15/10/11.
 * 站点首页
 */
public class Index extends DZAction {

    @Override
    public String list() {
        HttpServletRequest request = getRequest();
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null){
            return LOGIN;
        }
        return "toIndex";
    }
}
