package p.lodz.Model.Type;

import jakarta.persistence.*;

@Entity
@DiscriminatorColumn(name = "typ")
@Access(AccessType.FIELD)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract  class ClientType {
    @Column(name="client_discount")
    private double clientDiscount;
    @Column(name="shorter_delivery_time")
    private int shorterDeliveryTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ClientType() {
        this.clientDiscount = getClientDiscount();
        this.shorterDeliveryTime = getShorterDeliveryTime();
    }

    public abstract double getClientDiscount();
    public abstract int getShorterDeliveryTime();

}
