package test;

import com.ziqi.designpattern.singleton.HungryRunner;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonBrokenTest {

    @Test
    public void test1(){
        try {
            Class<?> aClass = Class.forName("com.ziqi.designpattern.singleton.HungryRunner");
            Constructor<?> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            HungryRunner runner1 = (HungryRunner)constructor.newInstance();
            HungryRunner runner2 = (HungryRunner)constructor.newInstance();
            System.out.println(runner1==runner2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        HungryRunner instance = HungryRunner.getInstance();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("E://singleton.txt")));
            oos.writeObject(instance);
            ois = new ObjectInputStream(new FileInputStream(new File("E://singleton.txt")));
            HungryRunner o = (HungryRunner)ois.readObject();
            System.out.println(instance == o);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
