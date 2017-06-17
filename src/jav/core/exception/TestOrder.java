package jav.core.exception;

/**
 * Created by gongkuaikuai on 2017/3/31.
 */
public class TestOrder {
    public static void main(String[] args) {
        System.out.println(new TestOrder().a());
    }

    public int a(){
        try{
            System.out.println(0);
            throw new Exception();
        }catch (Exception e){
            System.out.println(1);
            return 0;
        }finally {
            System.out.println(2);
            return 1;
        }
    }
}
