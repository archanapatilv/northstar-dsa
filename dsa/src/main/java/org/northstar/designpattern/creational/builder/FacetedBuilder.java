package org.northstar.designpattern.creational.builder;

public class FacetedBuilder {
    public static void main(String[] args)
    {
        HumanBuilder pb = new HumanBuilder();
        Human human = pb
                .lives()
                    .at("123 London Road")
                    .in("London")
                    .withPostcode("SW12BC")
                .works()
                    .at("Fabrikam")
                    .asA("Engineer")
                    .earning(123000)
                .build();
        System.out.println(human);
    }
}
class Human {
    String streetAddress, postcode, city;

    String companyName, position;

    int annualIncome;

    @Override
    public String toString()
    {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

class HumanBuilder {
    // the object we're going to build
    protected Human human = new Human(); // reference!

    public HumanJobBuilder works()
    {
        return new HumanJobBuilder(human);
    }

    public HumanAddressBuilder lives()
    {
        return new HumanAddressBuilder(human);
    }
    public Human build()
    {
        return human;
    }
}

class HumanAddressBuilder extends HumanBuilder {
    public HumanAddressBuilder(Human human) {
        this.human = human;
    }

    public HumanAddressBuilder at(String streetAddress) {
        human.streetAddress = streetAddress;
        return this;
    }

    public HumanAddressBuilder withPostcode(String postcode) {
        human.postcode = postcode;
        return this;
    }

    public HumanAddressBuilder in(String city) {
        human.city = city;
        return this;
    }
}

class HumanJobBuilder extends HumanBuilder {
    public HumanJobBuilder(Human human) {
        this.human = human;
    }

    public HumanJobBuilder at(String companyName) {
        human.companyName = companyName;
        return this;
    }

    public HumanJobBuilder asA(String position) {
        human.position = position;
        return this;
    }

    public HumanJobBuilder earning(int annualIncome) {
        human.annualIncome = annualIncome;
        return this;
    }
}

