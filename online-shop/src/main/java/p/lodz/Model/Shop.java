package p.lodz.model;

import p.lodz.managers.ClientManager;
import p.lodz.managers.ProductManager;
import p.lodz.managers.PurchaseManager;

public class Shop {
    private final ClientManager clientManager = new ClientManager();
    private final ProductManager productManager = new ProductManager();
    private final PurchaseManager purchaseManager = new PurchaseManager();

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
