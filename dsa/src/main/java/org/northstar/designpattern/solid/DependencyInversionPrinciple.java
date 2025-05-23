package org.northstar.designpattern.solid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// A. High-level modules should not depend on low-level modules.
// Both should depend on abstractions.

// B. Abstractions should not depend on details.
// Details should depend on abstractions.

public class DependencyInversionPrinciple {
    public static void main(String[] args)
    {
        Person parent = new Person("John");
        Person child1 = new Person("Chris");
        Person child2 = new Person("Matt");

        // low-level module
        Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
enum Relationship
{
    PARENT,
    CHILD,
    SIBLING
}

class Person
{
    public String name;
    // dob etc.


    public Person(String name) {
        this.name = name;
    }
}

class Triplet<P, R, P1> {
    P value0;
    R value1;
    P1 value2;

    public Triplet (P value0, R value1, P1 value2) {
        this.value0 = value0;
        this.value1 = value1;
        this.value2 = value2;
    }

    public P getValue0() {
        return value0;
    }

    public R getValue1() {
        return value1;
    }

    public P1 getValue2() {
        return value2;
    }
}

interface RelationshipBrowser
{
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser
{
    public List<Person> findAllChildrenOf(String name) {

        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name)
                        && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2)
                .collect(Collectors.toList());
    }

    // Triplet class requires javatuples
    private List<Triplet<Person, Relationship, Person>> relations =
            new ArrayList<>();

    public List<Triplet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(Person parent, Person child)
    {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }
}

class Research
{
    public Research(Relationships relationships)
    {
        // high-level: find all of john's children
        List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream()
                .filter(x -> x.getValue0().name.equals("John")
                        && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
    }

    public Research(RelationshipBrowser browser)
    {
        List<Person> children = browser.findAllChildrenOf("John");
        for (Person child : children)
            System.out.println("John has a child called " + child.name);
    }
}
