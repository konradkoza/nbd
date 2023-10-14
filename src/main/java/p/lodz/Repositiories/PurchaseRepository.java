package p.lodz.Repositiories;

import p.lodz.Model.Client;
import p.lodz.Model.Purchase;

import java.util.List;

public interface PurchaseRepository {
    Purchase savePurchase(Purchase purchase);
    List<Purchase> findAllClientPurchases(Client client);
}
