package com.chan.discover;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyTest {
    static SyncDemo syncDemo;
    SyncDemo s1, s2;

    public static void main(String[] args) {
        new MyTest().demo4();
    }

    void demo3() {
        syncDemo = new SyncDemo();
        new Thread(() -> {
            syncDemo.noneStatic("m1");
        }).start();
        new Thread(() -> {
            syncDemo.noneStatic("m2");
        }).start();
    }

    void demo4() {
        s1 = new SyncDemo();
        s2 = new SyncDemo();
        new Thread(() -> {
            s1.staticMethod("m1");
        }).start();
        new Thread(() -> {
            s2.staticMethod("m2");
        }).start();

    }

    static void demo() {
        new MyThread().start();
    }

    static void demo2() {
        FutureTask<String> myThread = new FutureTask<>(new MyThread2());
        Thread thread = new Thread(myThread);
        thread.start();
    }

    static class MyThread extends Thread {
        @Override
        public void run() {

        }
    }

    static class MyThread2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("使用实现callable的方式实现多线程");
            return "返回一个结果";
        }

    }

}

class SyncDemo {
    static String publicS = "";

    void noneStatic(String mark) {
        for (int i = 0; i < 1000000; i++) {
            publicS = mark;
            System.out.println(publicS);
        }
    }

    synchronized static void staticMethod(String mark) {
        for (int i = 0; i < 1000000; i++) {
            publicS = mark;
            System.out.println(publicS);
        }
    }
}