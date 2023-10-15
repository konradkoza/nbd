package p.lodz.Model.Type;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue( "premium_deluxe")
@Access(AccessType.FIELD)
public class PremiumDeluxe extends ClientType{

    @Override
    public double getClientDiscount() {
        return 0.2;
    }

    @Override
    public int getShorterDeliveryTime() {
        return 2;
    }
}
