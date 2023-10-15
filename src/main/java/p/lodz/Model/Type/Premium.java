package p.lodz.Model.Type;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue( "premium")
@Access(AccessType.FIELD)
public class Premium extends ClientType {


    @Override
    public double getClientDiscount() {
        return 0.1;
    }

    @Override
    public int getShorterDeliveryTime() {
        return 1;
    }

}
