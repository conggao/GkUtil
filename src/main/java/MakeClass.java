import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by yons on 2017/4/3.
 */
public class MakeClass {
    public String makeFunction(String module, String urd,Boolean isImpl,Boolean isDao) {
        char[] chars = urd.toCharArray();
        String daoUFunction = "";
        String daoRFunction = "";
        String daoDFunction = "";
        String daoRLFunction = "";
        String body=(isDao?makeDao(isImpl):makeService(isImpl));
        //循环检测添加操作
        for (char c : chars) {
            if (c == 'u') {
                daoUFunction = "public boolean update" + firstCharUpper(module) +
                        "(" +
                        firstCharUpper(module) +
                        " info" //参数
                        +")"
                        + body;
            }
            if (c == 'r') {
                daoRFunction = "public " +
                         firstCharUpper(module)+
                        " query" + firstCharUpper(module) +
                        "(" +
                        "Long id"
                        +")"
                        + body;
                daoRLFunction = "public " +
                        "List<"+
                        firstCharUpper(module)+
                        ">" +
                        " queryList" + firstCharUpper(module) +
                        "("
                        +")"
                        + body;
            }
            if (c == 'd') {
                daoDFunction = "public boolean del" + firstCharUpper(module) +
                        "(" +
                        firstCharUpper(module) +
                        " info" //参数
                        +")"
                        + body;
            }
        }
        return daoUFunction + "\n" + daoRFunction + "\n" + daoRLFunction + "\n" + daoDFunction + "\n";

    }

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

    //第一个字母大写
    public String firstCharUpper(String module) {

        char[] chars = module.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
