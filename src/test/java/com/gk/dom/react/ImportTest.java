package com.gk.dom.react;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pc on 2017/4/5.
 */
public class ImportTest {
    Import anImport;
    @Before
    public void setUp() throws Exception {
        anImport = new Import(false);
    }

    @Test
    public void getGkImport() throws Exception {
        System.out.println(anImport.getGkImport());
    }

}