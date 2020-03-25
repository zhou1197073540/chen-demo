package com.exa.demo.DemoTest;

public class ExceptionDemo {

    public static void main(String[] args) {
//        test();
        testQiOu(2);

    }

    //测试奇数偶数
    private static boolean testQiOu(int i) {
        int res=i&3;
        System.out.println(res);
        return false;
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

    static class SubException{

        public void test(){
            int a=1/0;
        }
    }

}


