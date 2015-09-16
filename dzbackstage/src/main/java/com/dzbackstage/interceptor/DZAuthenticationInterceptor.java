package com.dzbackstage.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * Created by fighting on 15/9/14.
 * 权限拦截器
 */
public class DZAuthenticationInterceptor  extends AbstractInterceptor{
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String,Object> sessionValues = invocation.getInvocationContext().getSession();
        String account = (String)sessionValues.get("account");
        if (account != null){
            return Action.LOGIN;
        }
        return invocation.invoke();
    }
}
