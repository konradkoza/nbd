package p.lodz.model;

public class Premium implements ClientType {

    @Override
    public double getClientDiscount() {
        return 0.1;
    }

    @Override
    public int getShorterDeliveryTime() {
        return 1;
    }
}
