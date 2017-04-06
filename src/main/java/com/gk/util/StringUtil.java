package com.gk.util;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pc on 2017/4/6.
 */
public class StringUtil {

    public static String searchWord(String line,String module){
        StringBuffer sb = new StringBuffer();
        Pattern compile = Pattern.compile("\\b\\S*" + NameUtil.charUpper(module )+ "\\S*\\b");
        Matcher matcher = compile.matcher(line);
        if (matcher.find()){
            sb.append(matcher.group());
        }
        return sb.toString();
    }
}
