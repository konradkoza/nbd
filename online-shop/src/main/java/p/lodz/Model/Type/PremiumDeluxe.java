package p.lodz.model;

public class PremiumDeluxe implements ClientType{

    @Override
    public double getClientDiscount() {
        return 0.2;
    }

    @Override
    public int getShorterDeliveryTime() {
        return 2;
    }
}
