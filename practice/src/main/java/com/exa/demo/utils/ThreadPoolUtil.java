package com.exa.demo.utils;

import com.exa.demo.DemoTest.ConcurrentHashMapTest;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolUtil {

    private ThreadPoolExecutor pool;

    private ThreadPoolUtil() {}

    public ThreadPoolUtil(int threadNum) {
        this.pool = new ThreadPoolExecutor(0,threadNum,50,TimeUnit.SECONDS,
                new SynchronousQueue<>(),new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build(),new MyRejectedExecutionHandler());
    }

    public void shutdown(){
        if(pool!=null){
            this.pool.shutdown();
        }
    }

    public void execute(Runnable r){
        this.pool.execute(r);
    }

    class MyRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if(!executor.isShutdown()){
                try {
                    executor.getQueue().put(r);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}



