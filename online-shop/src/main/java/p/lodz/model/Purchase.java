package p.lodz.model;

import java.time.LocalDate;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Purchase {

    private int purchaseId;

    private LocalDate purchaseDate;

    private LocalDate deliveryDate;

    private double finalCost;

    private Client client;

    private Product product;

    public Purchase(int purchaseId, Client client, Product product) {

        this.purchaseId = purchaseId;
        this.client = client;
        this.product = product;
        purchaseDate = LocalDate.now();
        setDeliveryTime();
        setFinalCost();
        client.addMoneySpent(finalCost);
        //TODO exceptions and values check
        if(product.isArchived()){
            throw new RuntimeException("Product out of stock");
        }else product.reduceNumberOfProducts();
        if(purchaseId < 0 ){
            throw new RuntimeException("ID cannot be negative number");
        }
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

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("purchaseId", purchaseId)
                .add("purchaseDate", purchaseDate)
                .add("deliveryDate", deliveryDate)
                .add("finalCost", finalCost)
                .add("client", client)
                .add("product", product)
                .toString();
    }
}
