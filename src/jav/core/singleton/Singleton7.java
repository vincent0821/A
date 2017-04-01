package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Singleton7 {
    private static class SingletonHolder{
        private final static Singleton7 s = new Singleton7();
    }

    public static Singleton7 getS(){
        return SingletonHolder.s;
    }

    private Singleton7(){}
}
