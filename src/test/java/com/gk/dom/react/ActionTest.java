package com.gk.dom.react;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pc on 2017/4/5.
 */
public class ActionTest {
    Action action;
    @Before
    public void setUp() throws Exception {
        action = new Action();
    }

    @Test
    public void getGkActon() throws Exception {
        System.out.println(action.getGkActon());
    }
    @Test
    public void makeAction() throws Exception{
        System.out.println(action.makeAction("user",  "cr","http://localhost:8080"));

    }

}