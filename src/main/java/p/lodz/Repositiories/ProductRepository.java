package p.lodz.Repositiories;

import p.lodz.Model.Product;

public interface ProductRepository {
    Product saveProduct(Product product);
    Product archiveProduct(Long id);
    Product decrementNumberOfProducts(Long id);
}
