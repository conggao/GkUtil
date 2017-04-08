package com.gk.dom.react;

import com.gk.util.NameUtil;

/**
 * Created by pc on 2017/4/6.
 */
public class Reducer {
    private StringBuffer gkReducer;
    private Action action;

    public Reducer(Action action) {
        this.action = action;
    }

    public String makeReducer() {
        //状态名
        String gkStateName = action.getModule() + "State";
        String gkState = "const " +
                gkStateName +
                " = {\n" +
                "};";
        gkReducer.append(gkState);
        gkReducer.append("\n");
        String gkUpdateName = "update" + NameUtil.firstCharUpper(action.getModule());
        String gkUpdate = "export function " +
                gkUpdateName +
                "(state = " +
                gkStateName +
                ", action) {\n" +
                "    switch (action.type) {\n" +
                makeCases()+
                "        default:\n" +
                "            return state;\n" +
                "    }\n" +
                "}\n";
        gkReducer.append(gkUpdate);
        gkReducer.append("\n");
        return gkReducer.toString();
    }

    public boolean outPutReducer(){

        return true;
    }
    /**
     * 生成case
     * @return
     */
    private String makeCases(){
        StringBuffer sb= new StringBuffer();
        for (String constant:action.getActionConstants()){
            sb.append( "        case " +
                    constant +
                    ":\n+" +
                    "            return Object.assign({}, state, {jsonList: action.jsonList});\n" +
                    "            break;\n");
        }
        return sb.toString();
    }
}
