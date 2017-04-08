package com.gk.dom.react;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yons on 2017/4/8.
 */
public class ReducerTest {
    Reducer reducer;
    @Before
    public void Before(){
        Action action = new Action("car");
        reducer = new Reducer(action);
    }
    @Test
    public void makeReducer() throws Exception {

    }

}