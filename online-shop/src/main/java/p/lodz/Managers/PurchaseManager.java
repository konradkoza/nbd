package p.lodz.Managers;

import p.lodz.Model.*;
import p.lodz.Model.Type.ClientType;
import p.lodz.Model.Type.Premium;
import p.lodz.Model.Type.PremiumDeluxe;
import p.lodz.Repositiories.Repository;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PurchaseManager {
    private Repository<Purchase> purchaseRepository;

    public PurchaseManager() {
        this.purchaseRepository = new Repository<Purchase>();
    }

    public Purchase getPurchase(int id){
        return purchaseRepository.find(purchase -> purchase.getId() == id).get(0);
    }

    public Purchase registerPurchase(Client customer, Product product){
        int nextID;
        if(purchaseRepository.size() == 0){
            nextID = 0;
        }else {
            int last = purchaseRepository.size() - 1 ;
            nextID = purchaseRepository.getElement(last).getId() + 1 ;

        }
        Purchase newPurchase = new Purchase(nextID, customer, product);
        purchaseRepository.addElement(newPurchase);
        changeClientType(customer);
        return newPurchase;

    }

    public ArrayList<Purchase> findPurchases(Predicate<Purchase> predicate){
        return purchaseRepository.find(predicate);
    }

    public ArrayList<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase getPurchaseByNumber(int number){
        return purchaseRepository.getElement(number);
    }

    public ArrayList<Purchase> getAllClientPurchases(Client client){
        Predicate<Purchase> purchasePredicate = purchase -> {
            return purchase.getClient() == client;
        };
        return purchaseRepository.find(purchasePredicate);
    }

    public ArrayList<Purchase> getAllProductPurchases(Product product){
        Predicate<Purchase> purchasePredicate = purchase -> {
            return purchase.getProduct() == product;
        };
        return purchaseRepository.find(purchasePredicate);
    }

    public double checkClientMoneySpent(Client client){
        return client.getMoneySpent();
    }

    private void changeClientType(Client client){
        double money = client.getMoneySpent();
//        if(money <= 500.0  ) {
//            ClientType standard = new Standard();
//            client.setClientType(standard);
//        } else
        if(money <= 1000.0 && money > 500) {
            ClientType premium = new Premium();
           client.setClientType(premium);
        } else if(money > 1000.0 ) {
            ClientType premiumDeluxe = new PremiumDeluxe();
            client.setClientType(premiumDeluxe);
        }
    }
}
