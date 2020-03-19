package com.exa.demo.DemoTest;

import com.exa.demo.utils.ThreadPoolUtil;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentHashMapTest {

    public static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    public static ThreadPoolUtil pool = new ThreadPoolUtil(2);
    public static final AtomicInteger aa = new AtomicInteger();

    public static void main(String[] args) {
//        for(int i=0;i<100;i++){
//            int finalI = i;
//            pool.execute(() -> {
//                map.put(finalI,finalI);
//                System.out.println(map);
//            });
//        }

//        new Thread(()->{
//            A a=new A("0f8c0a90-edf1-45a1-a12a-6f4f9ca6bdd0");
//            B.cc(a);
//        }).start();
//
//        new Thread(()->{
//            A a=new A("0f8c0a90-edf1-45a1-a12a-6f4f9ca6bdd0");
//            B.cc(a);
//        }).start();

//        Interner<String> pool = Interners.newWeakInterner();
//        System.out.println(pool.intern("123"));


        new Thread(() -> {
            while (true) {
                System.out.println("====================start");
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class B {
    private static Interner<String> pool = Interners.newWeakInterner();

    public static void cc(A a) {
//        Interner<String> pool = Interners.newWeakInterner();
//        String ids=a.getId().intern();
        synchronized (pool.intern(a.getId())) {
            System.out.println(Thread.currentThread().getName() + "=====" + a.hashCode());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "=====" + a.hashCode());
        }
    }
}

class A {
    String id = "";

    public A(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}



