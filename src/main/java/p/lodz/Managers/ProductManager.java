package p.lodz.Managers;


import jakarta.persistence.EntityManager;
import p.lodz.Model.Product;
import p.lodz.Repositiories.Implementations.ProductRepositoryImpl;
import p.lodz.Repositiories.ProductRepository;

import java.util.List;

public class ProductManager {
    private final ProductRepository productRepository;
    public ProductManager(EntityManager em) {
        this.productRepository = new ProductRepositoryImpl(em);
    }

    public Product getProduct(Long id){
        return productRepository.findProductById(id);
    }

    public Product registerProduct(String productName, double baseCost, int numberOfProducts, String desciption){
        Product product = new Product(productName, baseCost, numberOfProducts, desciption);
        return productRepository.saveProduct(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.findAllProducts();
    }

    public Product unregister(Long id){
        return productRepository.archiveProduct(id);
    }

}
