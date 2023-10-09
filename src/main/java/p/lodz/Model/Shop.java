package p.lodz.Model;

import p.lodz.Managers.ClientManager;
import p.lodz.Managers.ProductManager;
import p.lodz.Managers.PurchaseManager;

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
