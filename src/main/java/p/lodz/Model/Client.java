package p.lodz.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import p.lodz.Model.Type.ClientType;

@Getter
@Setter
@Access(AccessType.FIELD)
@Entity
@Table(name = "Client")
@NoArgsConstructor
public class Client {

    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Embedded
    Address address;
    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_type_id")
    @NonNull
    ClientType clientType;
    @Column(name = "is_Archived")
    private boolean archived = false;
    @Column(name = "money_spend")
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
