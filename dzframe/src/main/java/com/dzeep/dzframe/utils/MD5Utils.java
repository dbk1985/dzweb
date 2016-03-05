package com.dzeep.dzframe.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alan on 15/10/7.
 */
public class MD5Utils {
    public final static String md5(String str){
        String string = str == null ? "" : str;
        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        byte[] tempBytes = string.getBytes();
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");        //加密器
            mdTemp.update(tempBytes);   //执行加密
            byte[] md = mdTemp.digest();    //加密结果
            int length = md.length;
            char mdStr[] = new char[length*2];
            int k = 0;
            for (int i = 0; i < length; i++){
                byte byte0 = md[i];
                mdStr[k++] = hexDigits[byte0 >>> 4 & 0xf];
                mdStr[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(mdStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }finally {
            return null;
        }
    }
}
