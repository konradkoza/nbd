package p.lodz.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import p.lodz.Model.Type.ClientType;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    Address address;

    @OneToOne
    ClientType clientType;

    private boolean archived = false;

    private double moneySpent;

    public Client(long id, String firstName, String lastName, Address address, ClientType clientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.clientType = clientType;
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
