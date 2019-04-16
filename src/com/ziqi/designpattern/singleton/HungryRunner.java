package com.ziqi.designpattern.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例
 */
public class HungryRunner implements Serializable {

    private static final HungryRunner runner = new HungryRunner();

    //私有构造方法
    private HungryRunner(){
        super();
    }

    public static HungryRunner getInstance(){
        return runner;
    }
}
