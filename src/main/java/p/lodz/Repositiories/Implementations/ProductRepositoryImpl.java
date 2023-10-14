package p.lodz.Repositiories.Implementations;

import jakarta.persistence.EntityManager;
import p.lodz.Model.Product;
import p.lodz.Repositiories.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManager em;
    public ProductRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product saveProduct(Product product) {
        if (product.getId() == null) em.persist(product);
        else product = em.merge(product);
        return product;
    }

    @Override
    public Product archiveProduct(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            product.setArchived(true);
            em.merge(product);
        }
        return product;
    }

    @Override
    public Product decrementNumberOfProducts(Long id) {
        Product product = em.find(Product.class, id);
        if (product != null) {
            int nop = product.getNumberOfProducts();
            if(nop > 0) {
                product.setNumberOfProducts(nop - 1);
                em.merge(product);
            } else {
                throw new RuntimeException("Liczba produktów nie moze byc mniejsza od 0");
            }
        }
        return product;
    }
}
