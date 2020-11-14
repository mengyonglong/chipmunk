package com.chipmunk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5utils {
    private MD5utils() {
    }

    public  static String code(String str){
        try {
            // MessageDigest 类为应用程序提供信息摘要算法的功能
            MessageDigest md =MessageDigest.getInstance("MD5");
            //更新数据
            md.update(str.getBytes());
            //加密操作
            byte[] byteDigest=md.digest();
            int i;
            StringBuffer buf =new StringBuffer("");
            for(int offset=0;offset < byteDigest.length;offset++){
                i=byteDigest[offset];
                if(i<0)
                    i+=256;

                if(i<16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }


}
