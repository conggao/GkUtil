package com.gk.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pc on 2017/4/5.
 */
public class NameUtilTest {


    @Test
    public void firstCharUpper() throws Exception {
        System.out.println(NameUtil.firstCharUpper("getJson"));
    }

    @Test
    public void charUpper() throws Exception {
        System.out.println(NameUtil.charUpper("getJson"));
    }

}