package p.lodz.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;

@Getter
@Entity
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "final_cost")
    private double finalCost;

    @Column(name = "product_amount")
    private int productAmount;


    @ManyToOne
    private Client client;

    @ManyToOne
    private Product product;


    public Purchase(Client client, Product product,int amount) {
        this.client = client;
        this.product = product;
        this.productAmount = amount;
        purchaseDate = LocalDate.now();
        setDeliveryTime();
        setFinalCost();
        client.addMoneySpent(finalCost);
    }

    private void setDeliveryTime(){
        deliveryDate = purchaseDate.plusDays(3 - client.getClientShorterDeliveryTime());
    }

    private void setFinalCost(){
            finalCost += product.getBaseCost() -
                    product.getBaseCost() * product.getDiscount() -
                    client.getClientDiscount() * product.getBaseCost();

    }
    private void reduceNumberOfProducts(int number) {
        this.productAmount -= number;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("purchaseId", id)
                .add("purchaseDate", purchaseDate)
                .add("deliveryDate", deliveryDate)
                .add("finalCost", finalCost)
                .add("client", client)
                .add("product",product)
                .toString();
    }
}
