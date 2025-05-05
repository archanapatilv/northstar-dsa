package org.northstar.designpattern.creational.singleton;

public class LazySingletonDemo {
    public static void main(String[] args) {
        LazyDemo demo = LazyDemo.getInstance();
    }
}

class LazyDemo {
    private static LazyDemo LAZY;
    private LazyDemo() {
        System.out.println("This is LazyDemo initializing");
    }
    public static LazyDemo getInstance() {
        if (null == LAZY) {
            synchronized (LazyDemo.class) {
                if (null == LAZY) {
                    LAZY = new LazyDemo();
                }
            }
        }
        return LAZY;
    }
}
