package model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int num;
    private String street;
    private String area;
    private String city;
    private String pincode;

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

    public int getNumber() {
        return num;
    }

    public void setNumber(int num) {
        this.num = num;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "No." + num + ", " + street + ", " + area + ", " + city + "-" + pincode;
    }
}