package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
//@Table(name = "USER_DETAILS") (rename table name)
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //@Transient (ignore this as column)
    //@Column(name="user_name") (rename column name)
    private String name;

//    @OneToOne
//    @JoinColumn(name="vehicleId")
//    private Vehicle vehicle;

    @OneToMany
    @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
    private Collection<Vehicle> vehicleCollection = new ArrayList<>();

    /*@ElementCollection
    @GenericGenerator(name = "sequence", strategy = "sequence")
    @CollectionId(columns = {@Column(name = "Address_Id")}, generator = "sequence", type = @Type(type = "long"))
    private Collection<Address> addressCollection = new ArrayList<Address>();*/

    /*@Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
            @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN"))
    })
    private Address home_address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
            @AttributeOverride(name = "pincode", column = @Column(name = "oFFICE_PIN"))
    })
    private Address office_address;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Address getHome_address() {
        return home_address;
    }

    public void setHome_address(Address home_address) {
        this.home_address = home_address;
    }

    public Address getOffice_address() {
        return office_address;
    }

    public void setOffice_address(Address office_address) {
        this.office_address = office_address;
    }*/

    /*public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }*/

    /*public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }*/

    public Collection<Vehicle> getVehicleCollection() {
        return vehicleCollection;
    }

    public void setVehicleCollection(Collection<Vehicle> vehicleCollection) {
        this.vehicleCollection = vehicleCollection;
    }
}
