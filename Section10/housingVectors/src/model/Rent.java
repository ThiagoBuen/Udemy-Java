package model;

public class Rent {

    private Double rent;
    private String name;
    private String email;

    private Integer roomNumber;

    public Rent() {
    }

    public Rent(String name, String email, Integer roomNumber, Double rent) {
        this.name = name;
        this.email = email;
        this.roomNumber = roomNumber;
        this.rent = rent;
    }


    public void setRent(Double rent) {
        this.rent = rent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return roomNumber + ": Student: " + name + ", email: " + email + ", rent: " + rent;
    }
}
