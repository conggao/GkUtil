package com.gk.util;

import com.gk.dom.react.Import;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pc on 2017/4/6.
 */
public class FileUtilTest {
    @Test
    public void getConstants() throws Exception {
        List<String> constants = FileUtil.getConstants(System.getProperty("user.dir") + "\\src\\main\\resources\\constants.txt", "json");
        //生成import
        Import.ImportEntity entity = new Import.ImportEntity();
        entity.setExportName(constants);
        entity.setPackageName("../constants");
        Import anImport = new Import();
        ArrayList<Import.ImportEntity> listEntity = new ArrayList<Import.ImportEntity>();
        listEntity.add(entity);
        anImport.setListEntity(listEntity);
        System.out.println(anImport.getGkImport(true));

    }


}