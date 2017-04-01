package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Singleton5 {
    private static final Singleton5 s = new Singleton5();
    public static Singleton5 getS(){
        return s;
    }
    private Singleton5(){}
}
