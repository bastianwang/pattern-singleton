package com.ziqi.designpattern.singleton;

/**
 * 第二种懒加载
 */
public class LazyRunnerTwo {

    private static boolean isInitial = false;

    //私有化构造方法
    private LazyRunnerTwo() {
        synchronized (LazyRunnerTwo.class){
            if(isInitial == false){
                isInitial = !isInitial;
            }else{
                throw new RuntimeException("单例已经被侵犯！！");
            }
        }
    }

    public static LazyRunnerTwo getInstace() {
            return  InnerClass.LAZY;
    }


    static class InnerClass {
        private static final LazyRunnerTwo LAZY = new LazyRunnerTwo();
    }
}
