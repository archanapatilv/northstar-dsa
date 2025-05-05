package org.northstar.designpattern.creational.singleton;

public class EnumBasedSingletonDemo {
}
//cant serialize
//cant override
//no inheritance
enum EnumBasedSingleton {
    INSTANCE;

    EnumBasedSingleton() {
        value = 32;
    }

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
