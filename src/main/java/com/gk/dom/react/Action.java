package com.gk.dom.react;

import com.gk.util.NameUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017/4/5.
 */
public class Action {
    Action() {
        actionConstants = new ArrayList<String>();

    }

    private List<String> actionConstants;

    public String makeAction(String module, String cr, String url) {
        StringBuffer sb = new StringBuffer();
        //更新操作
        String changeAction = "";
        String changeActionName;
        String changeActionConstant;
        //获取列表
        String readAction = "";
        String readActionName;
        String readActionConstant;
        //fetch请求
        String fetchRead = "";
        String fetchReadName;
        //redux包装
        String reduxAction = "";
        String reduxActionName = "";
        char[] chars = cr.toCharArray();
        for (char c : chars) {
            if (c == 'c') {
                changeActionName = "change" + NameUtil.firstCharUpper(module);
                changeActionConstant = "CHANGE" + NameUtil.charUpper(module);
                actionConstants.add(changeActionConstant);
                changeAction = "export const " +
                        changeActionName +
                        "=" +
                        module + "Data" +
                        "=>{\n" +
                        "    return{\n" +
                        "        " +
                        "type:" +
                        changeActionConstant +
                        ",\n" +
                        "        " +
                        module + "Data" +
                        "\n" +
                        "    }\n" +
                        "};";
                sb.append(changeAction);
                sb.append("\n");
            } else if (c == 'r') {
                readActionName = "getList" + NameUtil.firstCharUpper(module);
                readActionConstant = "GETLIST" + NameUtil.charUpper(module);
                actionConstants.add(readActionConstant);
                readAction = "export const " +
                        readActionName +
                        "=" +
                        module + "Data" +
                        "=>{\n" +
                        "    return{\n" +
                        "        " +
                        "type:" +
                        readActionConstant +
                        ",\n" +
                        "        " +
                        module + "Data" +
                        "\n" +
                        "    }\n" +
                        "};";
                sb.append(readAction);
                sb.append("\n");
                //生成fetch代码
                fetchReadName = "fetch" + NameUtil.firstCharUpper(readActionName) + "Data";
                fetchRead = "function " +
                        fetchReadName +
                        "(data) {\n" +
                        "    return (dispatch) => {\n" +
                        "        return fetch(\"" +
                        url +
                        "\", {\n" +
                        "            method: \"POST\",\n" +
                        "            body: JSON.stringify(data),\n" +
                        "            headers: {\"Content-type\": \"application/json\", \"charset\": \"utf-8\"}\n" +
                        "        })\n" +
                        "            .then(\n" +
                        "            (res)=> {\n" +
                        "                return res.json();\n" +
                        "            }\n" +
                        "        ).then(\n" +
                        "            (data)=> {\n" +
                        "                console.log(data);\n" +
                        "                return dispatch(" +
                        readActionName +
                        "(data));\n" +
                        "            }\n" +
                        "        ).catch(e=> {\n" +
                        "            console.log(e.message);\n" +
                        "        })\n" +
                        "    }\n" +
                        "}";
                sb.append(fetchRead);
                sb.append("\n");
                reduxActionName = "fetch" + NameUtil.firstCharUpper(readActionName);
                reduxAction = "export function " +
                        reduxActionName +
                        "() {\n" +
                        "    return (dispatch, getState)=> {\n" +
                        "        return dispatch(" +
                        fetchReadName +
                        "());\n" +
                        "    }\n" +
                        "}";
                sb.append(reduxAction);
                sb.append("\n");
            }
        }
        if (actionConstants!=null && actionConstants.size()>0) {
            //生成import
            Import.ImportEntity entity = new Import.ImportEntity();
            entity.setExportName(actionConstants);
            entity.setPackageName("../constants");
            Import anImport = new Import();
            ArrayList<Import.ImportEntity> listEntity = new ArrayList<Import.ImportEntity>();
            listEntity.add(entity);
            anImport.setListEntity(listEntity);
            sb.insert(0,anImport.getGkImport(true));
        }
        return sb.toString();
    }

    private String gkActon;

    public String getGkActon() {
        return gkActon;
    }

    public void setGkActon(String gkActon) {
        this.gkActon = gkActon;
    }
}
