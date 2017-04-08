package com.gk.dom.java;

import com.gk.util.NameUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yons on 2017/4/3.
 */
public class MakeClass {
    /**
     * 生成java函数
     * @param module  模块名
     * @param urd  u(更新或者创建) r(查询) d(删除)
     * @param isImpl
     * @param isDao
     * @return
     */
    public String makeFunction(String module, String urd,Boolean isImpl,Boolean isDao) {
        char[] chars = urd.toCharArray();
        String daoUFunction = "";
        String daoRFunction = "";
        String daoDFunction = "";
        String daoRLFunction = "";
        String body=(isDao?makeDao(isImpl):makeService(isImpl));
        //首字母大写
        for (char c : chars) {
            if (c == 'u') {
                daoUFunction = "public boolean update" + NameUtil.firstCharUpper(module) +
                        "(" +
                        NameUtil.firstCharUpper(module) +
                        " info"
                        +")"
                        + body;
            }
            if (c == 'r') {
                daoRFunction = "public " +
                         NameUtil.firstCharUpper(module)+
                        " query" + NameUtil.firstCharUpper(module) +
                        "(" +
                        "Long id"
                        +")"
                        + body;
                daoRLFunction = "public " +
                        "List<"+
                        NameUtil.firstCharUpper(module)+
                        ">" +
                        " queryList" + NameUtil.firstCharUpper(module) +
                        "("
                        +")"
                        + body;
            }
            if (c == 'd') {
                daoDFunction = "public boolean del" + NameUtil.firstCharUpper(module) +
                        "(" +
                        NameUtil.firstCharUpper(module) +
                        " info"
                        +")"
                        + body;
            }
        }
        return daoUFunction + "\n" + daoRFunction + "\n" + daoRLFunction + "\n" + daoDFunction + "\n";

    }

    /**
     * 生成接口或者实现类
     * @param isImpl 是否
     * @return
     */
    private String makeDao(Boolean isImpl) {
        if (isImpl) {
            return "{}";
        } else {
            return ";";
        }
    }
    private String makeService(Boolean isImpl){
        if(isImpl){
            return "{}";
        }else {
            return ";";
        }
    }



}
