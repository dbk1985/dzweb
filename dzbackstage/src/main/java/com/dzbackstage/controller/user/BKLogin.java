package com.dzbackstage.controller.user;

import com.dzbackstage.model.UserInfo;
import com.dzbackstage.service.imp.UserInfoService;
import com.dzeep.dzframe.controller.DZController;

/**
 * Created by fighting on 15/9/16.
 */
public class BKLogin extends DZController {
    private UserInfoService userInfoService;
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
    @Override
    public String execute() throws Exception {
        /**
         * struts获取请求的参数的方法
         * 1、在action中定义一个与参数同名的属性，并设置setter和getter方法，xwork的OGNL会自动把request参数的值设置到类属性中，此时访问请求参数只需要访问类属性即可。
         *    String uName = getRequest().getParameter("uname");
         * 2、在Action中使用ActionContext得到parameterMap获取参数:
         *    ActionContext context=ActionContext.getContext();
         *    Map  parameterMap=context.getParameters();
         *    String bookName2[]=(String[])parameterMap.get("bookName");
         *    String bookPrice2[]=(String[])parameterMap.get("bookPrice");
         *    System.out.println("方法二，在Action中使用ActionContext得到parameterMap获取参数：");
         *    System.out.println("bookPrice: " +bookPrice2[0]);
         * 3、在Action中取得HttpServletRequest对象，使用request.getParameter获取参数
         *    HttpServletRequest request = (HttpServletRequest)context.get(ServletActionContext.HTTP_REQUEST);
         *    String bookName=request.getParameter("bookName");
         *    String bookPrice=request.getParameter("bookPrice");
         *
         * */
        /*String uName = getRequest().getParameter("userName");
        String password = getRequest().getParameter("password");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(uName);
        userInfo.setPassword(password);
        userInfo.setEmail("4564564@qq.com");
        if (uName == null){
            return LOGIN;
        }
        userInfoService.save(userInfo);*/
        return SUCCESS;
    }
}
