package com.gk.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/4/6.
 */
public class FileUtil {
    public static List<String> getConstants(String url, String module) {
        List<String> constants = new ArrayList<String>();
        File file = new File(url);
        //逐行读取配置文件
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (-1 != reader.read()) {
                String line = reader.readLine();
                //截取含有module的action
                String constant = StringUtil.searchWord(line, module);
                if (constant != null && !constant.equals("")) {
                    constants.add(constant);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return constants;
    }
}
