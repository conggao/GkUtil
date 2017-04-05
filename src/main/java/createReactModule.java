import java.util.List;

/**
 * Created by pc on 2017/4/5.
 */
public class createReactModule {
    private String gkImport;

    public String getGkImport() {
        return gkImport;
    }

    public void setGkImport(String gkImport) {
        this.gkImport = gkImport;
    }

    private static class gkClass {

        private List<String> gkField;
        private List<String> gkFunction;

        public List<String> getGkField() {
            return gkField;
        }

        public void setGkField(List<String> gkField) {
            this.gkField = gkField;
        }

        public List<String> getGkFunction() {
            return gkFunction;
        }

        public void setGkFunction(List<String> gkFunction) {
            this.gkFunction = gkFunction;
        }
    }


}
