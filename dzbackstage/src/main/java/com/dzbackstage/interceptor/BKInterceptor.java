package com.dzbackstage.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by fighting on 15/9/20.
 */
public abstract class BKInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        ActionContext application = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest)application.get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse)application.get(ServletActionContext.HTTP_RESPONSE);
        Map session = application.getSession();
        String result = interceptResult(invocation,application,request,response,session);
        if (result != null) return result;
        return invocation.invoke();
    }
    public abstract String interceptResult(ActionInvocation invocation,ActionContext context,HttpServletRequest request,HttpServletResponse response, Map session);
}
