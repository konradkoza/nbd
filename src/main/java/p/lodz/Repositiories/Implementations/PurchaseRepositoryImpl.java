package p.lodz.Repositiories.Implementations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import p.lodz.Model.Client;
import p.lodz.Model.Product;
import p.lodz.Model.Purchase;
import p.lodz.Repositiories.PurchaseRepository;

import java.util.List;

public class PurchaseRepositoryImpl implements PurchaseRepository {
    private final EntityManager em;
    public PurchaseRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Purchase findPurchaseById(Long id) {
        return em.find(Purchase.class, id);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        Query query = em.createQuery("SELECT p FROM Purchase p");
        return query.getResultList();
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {

         /*Product product = em.find(Product.class, purchase.getProduct().getId());
        if (product != null) {
            int nop = product.getNumberOfProducts();
            if(nop - purchase.getProductAmount() >= 0) {
                product.setNumberOfProducts(nop - purchase.getProductAmount());
                em.merge(product);
            } else {
                throw new RuntimeException("Liczba produktów nie moze byc mniejsza od 0");
            }
        } */


        purchase.getProduct().reduceNumberOfProducts(purchase.getProductAmount());
        if(purchase.getProduct().getNumberOfProducts() <0) {
            throw new RuntimeException("Liczba produktow nie moze byc <0");
        }
       if(purchase.getId() == null) {
           em.persist(purchase);
       }
       else {
           purchase = em.merge(purchase);
       }
       return purchase;
    }

    @Override
    public List<Purchase> findAllClientPurchases(Client client) {
        TypedQuery<Purchase> query = em.createQuery("SELECT p FROM Purchase p WHERE p.client = :client", Purchase.class);
        query.setParameter("client", client);
        return query.getResultList();
    }
}
