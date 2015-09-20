package com.dzbackstage.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by fighting on 15/9/14.
 * 权限拦截器
 */
public class BKAuthenticationInterceptor extends BKInterceptor{
    @Override
    public String interceptResult(ActionInvocation invocation, ActionContext context, HttpServletRequest request, HttpServletResponse response, Map session) {
        String account = (String)session.get("account");
        if (account != null){
            return Action.LOGIN;
        }
        return null;
    }
}
