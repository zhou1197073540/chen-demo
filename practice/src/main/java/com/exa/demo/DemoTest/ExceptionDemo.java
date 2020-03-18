package com.exa.demo.DemoTest;

public class ExceptionDemo {

    public static void main(String[] args) {
        test();
    }


    public static void test(){
        try{
            SubException sub=new SubException();
            sub.test();
        }catch (Exception e){
            System.out.println("====");
            e.printStackTrace();
        }
    }

}

class SubException{

    public void test(){
        int a=1/0;
    }
}
