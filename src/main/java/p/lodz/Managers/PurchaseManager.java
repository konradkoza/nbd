package p.lodz.Managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import p.lodz.Model.*;
import p.lodz.Repositiories.Implementations.ProductRepositoryImpl;
import p.lodz.Repositiories.Implementations.PurchaseRepositoryImpl;
import p.lodz.Repositiories.ProductRepository;
import p.lodz.Repositiories.PurchaseRepository;

import java.util.Iterator;
import java.util.List;

public class PurchaseManager {
    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private EntityManager em;

    public PurchaseManager(EntityManager em) {
        this.purchaseRepository = new PurchaseRepositoryImpl(em);
        this.productRepository = new ProductRepositoryImpl(em);
        this.em = em;
    }

    public Purchase getPurchase(Long id){
        return purchaseRepository.findPurchaseById(id);
    }

    public Purchase registerPurchase(Client customer, List<Product> products){
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            Product lockedProduct = em.find(Product.class,product.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            productRepository.decrementNumberOfProducts(lockedProduct.getId());
            if(lockedProduct.isArchived()) {
                iterator.remove();
            }
            else if (lockedProduct.getNumberOfProducts() == 0) {
                productRepository.archiveProduct(lockedProduct.getId());
            }
        }
            if (products.isEmpty()) {
                throw new RuntimeException("Nie można zrealizować zamówienia.");
            }
            Purchase purchase = new Purchase(customer, products);
            return purchaseRepository.savePurchase(purchase);
        }

    public Purchase registerPurchase(Client customer, Product product){
        Product lockedProduct = em.find(Product.class,product.getId(),LockModeType.OPTIMISTIC_FORCE_INCREMENT);
        productRepository.decrementNumberOfProducts(lockedProduct.getId());
        if(lockedProduct.isArchived()) {
            throw new RuntimeException("Nie mozna zrealizowac zamowienia");
        }
        else if (lockedProduct.getNumberOfProducts() == 0) {
            productRepository.archiveProduct(lockedProduct.getId());
        }
        Purchase purchase = new Purchase(customer,lockedProduct);
        return purchaseRepository.savePurchase(purchase);
    }

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAllPurchases();
    }

    public List<Purchase> getAllClientPurchases(Client client){
        return purchaseRepository.findAllClientPurchases(client);
    }
}