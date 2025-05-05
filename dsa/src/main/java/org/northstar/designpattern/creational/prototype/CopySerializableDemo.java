package org.northstar.designpattern.creational.prototype;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class CopySerializableDemo {
    public static void main(String[] args) {
        Foo foo = new Foo("ben", 30);
            Foo foo1 = SerializationUtils.roundtrip(foo);
            foo1.age = 29;
            foo.age = 31;
        System.out.println(foo);
        System.out.println(foo1);
    }
}

class Foo implements Serializable {
    String name;
    int age;

    public Foo(String name, int age) {
        this.name= name;
        this.age= age;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='"+ name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
