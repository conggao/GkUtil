package com.gk.dom.react;

import com.gk.util.NameUtil;

/**
 * Created by pc on 2017/4/6.
 */
public class Reducer {
    private StringBuffer gkReducer;

    public String makeReducer(String module){
        //状态名
        String gkStateName = module+"State";
        String gkState="const " +
                gkStateName +
                " = {\n" +
                "};";
        gkReducer.append(gkState);
        gkReducer.append("\n");
        String gkUpdateName = "update"+ NameUtil.firstCharUpper(module);
        String gkUpdate="export function " +
                gkUpdateName +
                "(state = " +
                gkStateName +
                ", action) {\n" +
                "    switch (action.type) {\n" +
                "        case GETJSONLIST:\n" +
                "            return Object.assign({}, state, {jsonList: action.jsonList});\n" +
                "            break;\n" +
                "        default:\n" +
                "            return state;\n" +
                "    }\n" +
                "}\n";
        gkReducer.append(gkUpdate);
        gkReducer.append("\n");
        return gkReducer.toString();
    }
}
