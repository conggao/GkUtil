package com.gk.util;

import java.util.List;

/**
 * Created by pc on 2017/4/5.
 */
public class MapReduceUtil {
    public static String reduceWithComma(List<String> items) {
        StringBuffer sb = new StringBuffer();
        sb.append(items.get(0));
        for (int i = 1; i < items.size(); i++) {
            sb.append(",");
            sb.append(items.get(i));
        }
        return sb.toString();
    }
}
