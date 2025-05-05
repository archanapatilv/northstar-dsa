package org.northstar.designpattern.creational.builder;

public class Builder {

    public static void main(String[] args)
    {
        // RecursiveGenericDemo
        EmployeeBuilder eb = new EmployeeBuilder()
                .withName("Dmitri")
                .withPosition("Quantitative Analyst");
        System.out.println(eb.build());
    }
}

class Person {
    String name;
    String position;
    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder <SELF extends PersonBuilder<SELF>> {
    Person person = new Person();

    //critical to return self here
    public SELF withName(String name) {
        person.name = name;
        return self();
    }
    public Person build() {
        return person;
    }
    protected SELF self()
    {
        // unchecked cast, but actually safe
        // proof: try sticking a non-PersonBuilder
        //        as SELF parameter; it won't work!
        return (SELF) this;
    }
}

//Type reference to the most derived that you are working with ie.<EmployeeBuilder>
class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder withPosition(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}