package p.lodz.Model;

import lombok.Getter;
import lombok.Setter;
import p.lodz.Model.Type.ClientType;

@Getter
@Setter
public class Client {
    private String firstName;
    private String lastName;
    private final int id;
    Address address;
    ClientType clientType;

    private boolean archived = false;

    private double moneySpent;

    public Client(String firstName, String lastName, int id, String city, String street, String number, ClientType clientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = new Address(city, street, number);
        this.clientType = clientType;
    }

    public String getStreet(){
        return address.getStreet();
    }

    public String getCity(){
        return address.getCity();
    }

    public String getNumber(){
        return address.getNumber();
    }

    public double getClientDiscount(){
        return clientType.getClientDiscount();
    }

    public int getClientShorterDeliveryTime(){
        return clientType.getShorterDeliveryTime();
    }

    public void addMoneySpent(double value){
        moneySpent += value;
    }
}
