package jav.core.thread;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class Lock {
    /*
    ����synchronized�ɷ����������͡�
    ��������ɣ�ֻ�ж����������
     */
    Integer a;
    private void testPrimitive(){
        synchronized (a){
            System.out.println(a);
        }
    }
}
