package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String pincode;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}