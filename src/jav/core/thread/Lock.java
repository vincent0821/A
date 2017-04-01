package jav.core.thread;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Lock {
    /*
    测试synchronized可否锁基本类型。
    结果：不可，只有对象才有锁。
     */
    Integer a;
    private void testPrimitive(){
        synchronized (a){
            System.out.println(a);
        }
    }
}
