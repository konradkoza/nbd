package p.lodz.RepositoryTests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import p.lodz.Model.Address;
import p.lodz.Model.Client;
import p.lodz.Model.Product;
import p.lodz.Model.Purchase;
import p.lodz.Model.Type.ClientType;
import p.lodz.Model.Type.Premium;
import p.lodz.Repositiories.ClientRepository;
import p.lodz.Repositiories.Implementations.ClientRepositoryImpl;
import p.lodz.Repositiories.Implementations.ProductRepositoryImpl;
import p.lodz.Repositiories.Implementations.PurchaseRepositoryImpl;
import p.lodz.Repositiories.ProductRepository;
import p.lodz.Repositiories.PurchaseRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseRepositoryTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static PurchaseRepository purchaseRepository;
    private static ClientRepository clientRepository;
    private static ProductRepository productRepository;

    @BeforeAll
    static void initTest() {
        emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        purchaseRepository = new PurchaseRepositoryImpl(em);
        clientRepository = new ClientRepositoryImpl(em);
        productRepository = new ProductRepositoryImpl(em);
    }

    @Test
    void savePurchaseTest() {
        ClientType clientType = new Premium();
        Address address = new Address("aaa", "bbb", "ccc");
        Client client = new Client("Adam", "Fajny", address, clientType);
        Client savedClient = clientRepository.saveClient(client);
        Product product = new Product("aaa", 1, 1, "aaa");
        Product savedProduct = productRepository.saveProduct(product);
        Purchase purchase = new Purchase(savedClient, savedProduct,3);

        Purchase savedPurchase = purchaseRepository.savePurchase(purchase);
        assertEquals(purchase, savedPurchase);
    }

    @Test
    void findAllClientPurchasesTest() {
        ClientType clientType = new Premium();
        Address address = new Address("aaa", "bbb", "ccc");
        Client client = new Client("Adam", "Fajny", address, clientType);
        Client savedClient = clientRepository.saveClient(client);

        Product product = new Product("aaa", 1, 20, "aaa");
        Product savedProduct = productRepository.saveProduct(product);

        Purchase purchase = new Purchase(savedClient, savedProduct, 1);
        Purchase savedPurchase = purchaseRepository.savePurchase(purchase);

        //assertEquals(1, purchaseRepository.findAllClientPurchases(savedClient).size());

    }

    @AfterAll
    static void endTest() {
        if (emf != null) emf.close();
    }
}
