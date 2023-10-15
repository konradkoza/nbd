package p.lodz.RepositoryTests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import p.lodz.Model.Product;
import p.lodz.Repositiories.Implementations.ProductRepositoryImpl;
import p.lodz.Repositiories.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ProductRepository productRepository;

    @BeforeAll
    static void initTest() {
        emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        productRepository = new ProductRepositoryImpl(em);
    }

    @Test
    void saveProductTest() {
        Product product = new Product("aaa", 1, 1, "aaa");
        assertEquals(product, productRepository.saveProduct(product));
    }

    @Test
    void archiveProductTest() {
        Product savedProduct = productRepository.saveProduct(new Product("aaa", 1, 1, "aaa"));
        Product product1 = productRepository.archiveProduct(savedProduct.getId());
        assertTrue(product1.isArchived());
    }

    @Test
    void decrementNumberOfProductTest() {
        Product savedProduct = productRepository.saveProduct(new Product("aaa", 1, 1, "aaa"));
        Product productAfterDecrement = productRepository.decrementNumberOfProducts(savedProduct.getId());
        assertEquals(0, productAfterDecrement.getNumberOfProducts());
        assertThrows(RuntimeException.class, () -> {productRepository.decrementNumberOfProducts(savedProduct.getId());});
    }

    @AfterAll
    static void endTest() {
        if(emf != null) emf.close();
    }
}