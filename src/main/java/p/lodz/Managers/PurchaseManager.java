package p.lodz.Managers;

import jakarta.persistence.EntityManager;
import p.lodz.Model.*;
import p.lodz.Repositiories.Implementations.PurchaseRepositoryImpl;
import p.lodz.Repositiories.PurchaseRepository;

import java.util.List;

public class PurchaseManager {
    private final PurchaseRepository purchaseRepository;

    public PurchaseManager(EntityManager em) {
        this.purchaseRepository = new PurchaseRepositoryImpl(em);
    }

    public Purchase getPurchase(Long id){
        return purchaseRepository.findPurchaseById(id);
    }

    public Purchase registerPurchase(Client customer, List<Product> products){
        Purchase purchase = new Purchase(customer, products);
        return purchaseRepository.savePurchase(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    public List<Purchase> getAllClientPurchases(Client client){
        return purchaseRepository.findAllClientPurchases(client);
    }

    public double checkClientMoneySpent(Client client){
        return client.getMoneySpent();
    }
}
