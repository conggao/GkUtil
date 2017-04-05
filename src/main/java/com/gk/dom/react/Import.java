package com.gk.dom.react;

import com.gk.util.MapReduceUtil;

import java.util.List;

/**
 * Created by pc on 2017/4/5.
 */
public class Import {

    Import() {
        gkImport = new StringBuffer();
    }

    public static class ImportEntity {
        private String packageName;
        private List<String> exportName;

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public List<String> getExportName() {
            return exportName;
        }

        public void setExportName(List<String> exportName) {
            this.exportName = exportName;
        }
    }

    private List<ImportEntity> listEntity;

    public List<ImportEntity> getListEntity() {
        return listEntity;
    }

    public void setListEntity(List<ImportEntity> listEntity) {
        this.listEntity = listEntity;
    }

    private StringBuffer gkImport;

    public void setGkImport(StringBuffer gkImport) {
        this.gkImport = gkImport;
    }

    public String getGkImport(boolean isDefault) {
        for (ImportEntity entity : getListEntity()) {
            gkImport.append("import " +
                    (isDefault ? "{" : "") +
                    MapReduceUtil.reduceWithComma(entity.getExportName()) +
                    (isDefault ? "}" : "") +
                    " from '" +
                    entity.getPackageName() +
                    "'\n");
        }
        return gkImport.toString();
    }

}
