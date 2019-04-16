package com.ziqi.designpattern.singleton;

/**
 * 懒汉式
 */
public class LazyRunnerOne {

    private static LazyRunnerOne runner = null;

    private LazyRunnerOne(){}

    public static synchronized LazyRunnerOne getInstance(){
        if(runner==null){
            runner = new LazyRunnerOne();
        }
        return runner;
    }
}
