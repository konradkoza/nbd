package p.lodz.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "base_cost")
    private double baseCost;
    @Column(name = "discount")
    private double discount;
    @Column(name = "archived")
    private boolean archived = false;
    @Column(name = "nuber_of_products")
    private int numberOfProducts;
    @Column(name = "description")
    private String desciption;

    public Product(String productName, double baseCost, int numberOfProducts, String desciption) {
        this.productName = productName;
        this.baseCost = baseCost;
        this.numberOfProducts = numberOfProducts;
        this.desciption = desciption;
    }

    public void reduceNumberOfProducts(int amount){
        numberOfProducts -= amount;
        if(numberOfProducts <= 0){
            setArchived(true);
        }
    }
}
