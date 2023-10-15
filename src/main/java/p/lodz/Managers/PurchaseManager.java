package p.lodz.Managers;

import jakarta.persistence.EntityManager;
import p.lodz.Model.*;
import p.lodz.Repositiories.Implementations.ProductRepositoryImpl;
import p.lodz.Repositiories.Implementations.PurchaseRepositoryImpl;
import p.lodz.Repositiories.ProductRepository;
import p.lodz.Repositiories.PurchaseRepository;

import java.util.List;

public class PurchaseManager {
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;

    public PurchaseManager(EntityManager em) {
        this.purchaseRepository = new PurchaseRepositoryImpl(em);
        this.productRepository = new ProductRepositoryImpl(em);
    }

    public Purchase getPurchase(Long id){
        return purchaseRepository.findPurchaseById(id);
    }

    public Purchase registerPurchase(Client customer, List<Product> products){
        Purchase purchase = new Purchase(customer, products);
        products.forEach(e -> {
            e = productRepository.decrementNumberOfProducts(e.getId());
            if (e.getNumberOfProducts() == 0) productRepository.archiveProduct(e.getId());
        });
        return purchaseRepository.savePurchase(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    public List<Purchase> getAllClientPurchases(Client client){
        return purchaseRepository.findAllClientPurchases(client);
    }
}
