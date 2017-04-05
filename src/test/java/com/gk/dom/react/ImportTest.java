package com.gk.dom.react;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by pc on 2017/4/5.
 */
public class ImportTest {
    Import anImport;
    @Before
    public void setUp() throws Exception {
        anImport = new Import();
        List<Import.ImportEntity> listEntity  = new ArrayList<Import.ImportEntity>();
        Import.ImportEntity entity = new Import.ImportEntity();
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("react");
        entity.setExportName(stringList);
        entity.setPackageName("React");
        listEntity.add(entity);
        Import.ImportEntity entity1 = new Import.ImportEntity();
        ArrayList<String> stringList1 = new ArrayList<String>();
        stringList1.add("react");
        entity1.setExportName(stringList1);
        entity1.setPackageName("React");
        listEntity.add(entity1);
        anImport.setListEntity(listEntity);
    }

    @Test
    public void getGkImport() throws Exception {
        System.out.println(anImport.getGkImport(true));
    }

}