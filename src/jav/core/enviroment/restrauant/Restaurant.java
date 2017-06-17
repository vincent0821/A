package jav.core.enviroment.restrauant;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

/**
 * Created by gongkuaikuai on 2017/4/10.
 * 范式：
 * 对象式，过程式
 * 并发式：
 */
public class Restaurant {
    private Customer accept(){
        return new Customer();
    }

    private void serve(Customer customer){
        Receptionist receptionist = findReceptionList();
        receptionist.receive(customer);
        receptionist.usher(customer);

        Waiter waiter = findWaiter();
        waiter.pourTea(customer);
        List<Order> orders = waiter.write(customer);

        Cook cook = waiter.pass(orders);
        for(Order order : orders){
            Course course = cook.cook(order);
            waiter = findWaiter();
            waiter.serve(customer,course);
            customer.eat(course);
        }

        Cashier cashier = findCashier();
        cashier.charge(customer);
        cashier.issueInvoice(customer);

        receptionist = findReceptionList();
        receptionist.sent(customer);

    }

    private Cashier findCashier() {
        return new Cashier();
    }

    private Waiter findWaiter() {
        return new Waiter();
    }

    private Receptionist findReceptionList() {
        return new Receptionist();
    }

    public void service(){
        while(true){
            final Customer customer;
            if((customer=accept())!=null){
//                serve(customer);//这里这么用的话就是单线程的
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        Restaurant.this.serve(customer);
                    }
                }).start();
            }
        }
    }

    public static void main(String[] args) {
        new Restaurant().service();
    }
}
