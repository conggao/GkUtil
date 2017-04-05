package com.gk.util;

/**
 * Created by pc on 2017/4/5.
 */
public class NameUtil {
    //首字母大写
    public static String firstCharUpper(String module) {
        char[] chars = module.toCharArray();
        if (Integer.valueOf(chars[0])>97)
        chars[0] -= 32;
        return String.valueOf(chars);
    }
    //全部转换为大写
    public static String charUpper(String module){
        return module.toUpperCase();
    }
}
