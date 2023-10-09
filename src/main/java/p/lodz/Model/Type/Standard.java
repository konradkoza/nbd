package p.lodz.Model.Type;

public class Standard implements ClientType{

    @Override
    public double getClientDiscount() {
        return 0.0;
    }

    @Override
    public int getShorterDeliveryTime() {
        return 0;
    }
}
