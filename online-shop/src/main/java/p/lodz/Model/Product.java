package p.lodz.Model;

public class Product {
    private String productName;

    private int productId;
    private double baseCost;

    private double discount;

    private boolean isArchived = false;

    private int numberOfProducts;

    private String desciption;

    public Product(String productName, int productId, double baseCost, int numberOfProducts, String desciption) {
        this.productName = productName;
        this.productId = productId;
        this.baseCost = baseCost;
        this.numberOfProducts = numberOfProducts;
        this.desciption = desciption;
    }

    public int getId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(double baseCost) {
        this.baseCost = baseCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public void reduceNumberOfProducts(){
        numberOfProducts -= 1;
        if(numberOfProducts <= 0){
            setArchived(true);
        }
    }
}
