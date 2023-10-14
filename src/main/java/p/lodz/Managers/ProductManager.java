package p.lodz.Managers;


import p.lodz.Model.Product;
import p.lodz.Repositiories.Repository;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ProductManager {
    private final Repository<Product> productRepository;

    public ProductManager() {
        this.productRepository = new Repository<Product>();
    }

    public Product getProduct(int id){
        return productRepository.find(product -> product.getId() == id).get(0);
    }

    public Product registerProduct(String productName, double baseCost, int numberOfProducts, String desciption){
        long nextID;
        if(productRepository.size() == 0){
            nextID = 0L;
        }else {
            int last = productRepository.size() - 1 ;
            nextID = productRepository.getElement(last).getId() + 1 ;

        }
        Product newProduct = new Product(productName, baseCost, numberOfProducts, desciption);
        productRepository.addElement(newProduct);

        return newProduct;

    }

    public ArrayList<Product> findAllProducts(Predicate<Product> predicate){
        Predicate<Product> productPredicate = product -> {
            return predicate.test(product) && !product.isArchived();
        };
        return productRepository.find(productPredicate);
    }

    public ArrayList<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void unregister(int id){
        getProduct(id).setArchived(true);
    }

    public Product getProductByNumber(int number){
        return productRepository.getElement(number);
    }

}
