package com.gk.dom.react;

import com.gk.util.NameUtil;

/**
 * Created by pc on 2017/4/5.
 */
public class Action {
    Action(String actionName,String jsonName) {
        gkActon = "export const " +
                actionName +
                "=" +
                jsonName +
                "=>{\n" +
                "    return{\n" +
                "        " +
                "type:" +
            NameUtil.charUpper(actionName)+
                ",\n" +
                "        "+
                jsonName +
                "\n" +
                "    }\n" +
                "};";
    }

    private String gkActon;

    public String getGkActon() {
        return gkActon;
    }

    public void setGkActon(String gkActon) {
        this.gkActon = gkActon;
    }
}
