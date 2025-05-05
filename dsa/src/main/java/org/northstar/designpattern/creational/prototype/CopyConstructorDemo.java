package org.northstar.designpattern.creational.prototype;

public class CopyConstructorDemo {
    public static void main(String[] args) {
        IEmployee ben = new IEmployee("ben", new IAddress("91 SCR", "Dublin", "Ireland"));

        IEmployee dover = new IEmployee(ben);
        dover.name = "dover";
        dover.address.streetAddress = "90 SCR";

        System.out.println(ben);
        System.out.println(dover);
    }
}

class IAddress {
    public String streetAddress, city, country;

    public IAddress (String streedAddress, String city, String country) {
        this.streetAddress = streedAddress;
        this.city = city;
        this.country = country;
    }

    public IAddress(IAddress other) {
        this.streetAddress = other.streetAddress;
        this.city = other.city;
        this.country = other.country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='"+ streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

class IEmployee {
    public String name;
    public IAddress address;

    public IEmployee(String name, IAddress address) {
        this.name = name;
        this.address = address;
    }

    public IEmployee (IEmployee other) {
        this.name = other.name;
        this.address = new IAddress(other.address);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                "address='" + address + '\'' +
                '}';
    }
}
