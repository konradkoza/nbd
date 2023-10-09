package p.lodz.Model.Type;

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
