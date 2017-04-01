package jav.core.singleton;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Singleton4 {
    private static volatile Singleton4 s;
    private Singleton4(){}
    public static Singleton4 getS() {
        if (s == null) {
            synchronized (Singleton4.class) {
                if (s == null) {
                    s = new Singleton4();
                }
            }
        }
        return s;
    }
}
