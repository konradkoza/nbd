package p.lodz.managers;


import p.lodz.model.Product;
import p.lodz.repositiories.Repository;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ProductManager {
    private Repository<Product> productRepository;

    public Product getProduct(int id){
        return productRepository.find(product -> product.getId() == id).get(0);
    }

    public Product registerClient(String productName, double baseCost, int numberOfProducts, String desciption){
        int nextID;
        if(productRepository.size() == 0){
            nextID = 0;
        }else {
            int last = productRepository.size() - 1 ;
            nextID = productRepository.getElement(last).getId() + 1 ;

        }
        Product newProduct = new Product(productName, nextID, baseCost, numberOfProducts, desciption);
        productRepository.addElement(newProduct);

        return newProduct;

    }

    public ArrayList<Product> findAllClients(Predicate<Product> predicate){
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
