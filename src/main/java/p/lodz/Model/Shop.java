package p.lodz.Model;

import jakarta.persistence.EntityManager;
import p.lodz.Managers.ClientManager;
import p.lodz.Managers.ProductManager;
import p.lodz.Managers.PurchaseManager;

public class Shop {
    private final ClientManager clientManager;
    private final ProductManager productManager;
    private final PurchaseManager purchaseManager;

    public Shop(EntityManager em) {
        clientManager = new ClientManager(em);
        productManager = new ProductManager(em);
        purchaseManager = new PurchaseManager(em);
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

    public PurchaseManager getPurchaseManager() {
        return purchaseManager;
    }
}
