package org.northstar.designpattern.creational.singleton;

import java.io.*;

public class BasicSingletonDemo {
    public static void main(String[] args) throws IOException {
        Demo d = Demo.getInstance();
        d.setValue(10);
        System.out.println(d.getValue());

        //TO break singleton
        try(FileOutputStream fs = new FileOutputStream("temp.txt")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            // NOTE: This requires the class to be serializable
            os.writeObject(d) ;
            os.close();
        }
        try(FileInputStream in = new FileInputStream("temp.txt")) {
            ObjectInputStream ois = new ObjectInputStream(in);
            Demo o = (Demo)ois.readObject();
            System.out.println("Whether they are equal : " + (d == o));
            d.setValue(21);
            System.out.println(d.getValue());
            System.out.println(o.getValue());
            ois.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Demo implements Serializable {
    private static final Demo DEMO = new Demo();
    private int value;
    private Demo() {
    }
    public static Demo getInstance() {
        return DEMO;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    //Note: To fix the serializable issue you need to have this method
    protected Object readResolve() {
        return DEMO;
    }
}