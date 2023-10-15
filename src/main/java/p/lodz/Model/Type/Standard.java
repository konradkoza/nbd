package p.lodz.Model.Type;

import jakarta.persistence.*;
import p.lodz.Model.Client;

@Entity
@Access(AccessType.FIELD)
@DiscriminatorValue("standard")
public class Standard extends ClientType{


    @Override
    public double getClientDiscount() {
        return 0.0;
    }

    @Override
    public int getShorterDeliveryTime() {
        return 0;
    }

}
