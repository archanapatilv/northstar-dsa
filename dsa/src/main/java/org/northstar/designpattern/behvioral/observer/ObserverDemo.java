package org.northstar.designpattern.behvioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo implements Observer<Person>{
    Person person;
    public ObserverDemo() {
        person = new Person(10);
        person.subscribe(this);
    }
    public static void main(String[] args) {
        ObserverDemo demo = new ObserverDemo();
        demo.person.setAge(12);
    }

    @Override
    public void handle(final PropertyChangedEventArgs<Person> propertyChangedEventArgs) {
        System.out.println("Property Change Event: Property Name: " + propertyChangedEventArgs.propertyName
                + " value: " + propertyChangedEventArgs.value);
    }
}

class PropertyChangedEventArgs<T> {
    public T source;
    public String propertyName;
    public Object value;

    public PropertyChangedEventArgs(T source, String propertyName, Object value) {
        this.source = source;
        this.propertyName = propertyName;
        this.value = value;
    }
}

interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> propertyChangedEventArgs);
}

class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe (Observer<T> observer) {
        observers.add(observer);
    }

    protected void propertyChanged(T source, String propertyName, Object value) {
        observers
                .stream()
                .forEach(observer -> observer.handle(
                        new PropertyChangedEventArgs<T>(source, propertyName, value))
                );
    }
}
class Person extends Observable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(this.age == age)
            return;
        this.age = age;
        propertyChanged(this, "age", age);
    }
}
