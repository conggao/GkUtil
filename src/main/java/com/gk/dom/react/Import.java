package com.gk.dom.react;

import com.gk.util.MapReduceUtil;

import java.util.List;

/**
 * Created by pc on 2017/4/5.
 */
public class Import {
    //export default set isDefault true else fault
    Import(boolean isDefault) {
        for (ImportEntity entity : getListEntity()) {
            gkImport = "import " +
                    (isDefault ? "{" : "") +
                    MapReduceUtil.reduceWithComma(entity.getExportName()) +
                    (isDefault ? "}" : "") +
                    " from '" +
                    entity.getPackageName() +
                    "'";
        }


    }
    public class ImportEntity {
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

    private String gkImport;

    public String getGkImport() {
        return gkImport;
    }

    public void setGkImport(String gkImport) {
        this.gkImport = gkImport;
    }

}
