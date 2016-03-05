package com.dzeep.dzstage.result;

import com.dzeep.dzstage.controller.DZAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.inject.Inject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by alan on 15/10/11.
 * 自定义Reuslt: 开发自定义Result是非常简单的，只需要实现com.opensymphony.xwork2.Result接口就可以了,也可以通过继承
 * StrutsResultSupport来编辑自己的Result。
 * 定义好自己的Result后在Strut的配置文件中进行配置就可以使用自定义的Result。
 * struts配置文件中配置自定义Result
 * <package name="{web名称}"  extends="struts-default">
 *      <result-types>
 *          <result-type name="AJAX_RESULT" class="package com.dzeep.dzstage.result.AjaxResult" default="false"/>
 *      </result-types>
 *      <action name="ajax" class="action对应的类">
 *          <result name="toWelcome" type="AJAX_RESULT">/welcome.jsp</result>
 *      </action>
 * </package>
 */
public class AjaxResult extends StrutsResultSupport {
    private String defaultEncoding = "UTF-8";
    private PrintWriter writer;

    public PrintWriter getWriter() throws IOException {
        if (this.writer != null) return this.writer;
        return ServletActionContext.getResponse().getWriter();
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    protected String getContentType(String finalLocation) {
        return "application/json";
    }

    @Inject(value = "struts.i18n.encoding")
    protected void setDefaultEncoding(String encoding) {
        this.defaultEncoding = encoding;
    }

    /**
     * 获取编码
     * @param finalLocation
     * @return
     */
    protected String getEncoding(String finalLocation){
        String encoding = this.defaultEncoding;
        if (encoding == null){
            encoding = System.getProperty("file.encoding");
        }
        if (encoding == null){
            HttpServletRequest request = ServletActionContext.getRequest();
            encoding = request.getCharacterEncoding();
        }
        return encoding;
    }

    @Override
    protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
        Object action = invocation.getAction();
        String responseData = "";
        if ((action instanceof DZAction)) {
            DZAction ajaxAction = (DZAction) action;
            HttpServletResponse response = ServletActionContext.getResponse();
            String encoding = getEncoding(finalLocation);
            String contentType = getContentType(finalLocation);
            if (encoding != null) {
                contentType = contentType + ";charset=" + encoding;
            }
            response.setContentType(contentType);
            String successData = ajaxAction.getResponseData();
            if (successData != null) {
                if ("success".equals(successData)) {
                    responseData = "{\"success\":true}";
                } else {
                    responseData = successData;
                }

            }
            // 输出json数据
            getWriter().write(responseData);
        }
    }
}
