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

    public static boolean outPutFile(String module, String text, int type) {
        String dir = System.getProperty("user.dir") + "//src//main//output//" + module;
        File dirFile = new File(dir);
        if (!dirFile.getParentFile().exists()) {
            if (!dirFile.getParentFile().mkdir())
                return false;
        }
        if (!dirFile.exists()) {
            if (!dirFile.mkdir()) {
                return false;
            }
        }
        if (type == 1) {
            File file = new File(dir + "//actions//" + NameUtil.firstCharUpper(module) + "Action.js");
            if (!file.getParentFile().exists()) {
                if (!file.getParentFile().mkdir())
                    return false;
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(text);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else if(type == 2) {
            File file = new File(dir + "//reducers//" + NameUtil.firstCharUpper(module) + "Reducer.js");
            if (!file.getParentFile().exists()) {
                if (!file.getParentFile().mkdir())
                    return false;
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(text);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
