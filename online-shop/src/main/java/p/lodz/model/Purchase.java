package p.lodz.model;

import java.time.LocalDate;

public class Purchase {

    private int purchaseId;

    private LocalDate purchaseDate;

    private LocalDate deliveryDate;

    private double finalCost;

    private Client client;

    private Product product;

    public Purchase(int purchaseId, Client client, Product product) {

        purchaseDate = LocalDate.now();
        setDeliveryTime();
        setFinalCost();
        client.addMoneySpent(finalCost);
        //TODO exceptions and values check
        this.purchaseId = purchaseId;
        this.client = client;
        this.product = product;
    }

    public int getId() {
        return purchaseId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    private void setDeliveryTime(){
        deliveryDate = purchaseDate.plusDays(3 - client.getClientShorterDeliveryTime());
    }

    private void setFinalCost(){
        finalCost = product.getBaseCost() -
                product.getBaseCost() * product.getDiscount() -
                client.getClientDiscount() * product.getBaseCost();
    }
}
