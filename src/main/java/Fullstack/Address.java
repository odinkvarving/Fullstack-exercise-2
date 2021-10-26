package Fullstack;

public class Address {
    private int id;
    private String addressname;
    private int zipcode;

    public Address(int id, String addressname, int zipcode) {
        this.id = id;
        this.addressname = addressname;
        this.zipcode = zipcode;
    }

    public Address() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
