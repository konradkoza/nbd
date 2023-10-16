package p.lodz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.A;
import p.lodz.Managers.ClientManager;
import p.lodz.Model.*;
import p.lodz.Model.Type.ClientType;
import p.lodz.Model.Type.Premium;
import p.lodz.Model.Type.Standard;
import p.lodz.Repositiories.ClientRepository;
import p.lodz.Repositiories.Implementations.ClientRepositoryImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("test")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Shop shop = new Shop(em);
            shop.getProductManager().registerProduct("aaa", 10, 1, "aabb");
            shop.getClientManager().registerClient("aaa", "bbbb", "wwa", "ullica", "10", new Standard());
            shop.getPurchaseManager().registerPurchase(shop.getClientManager().getClient(1L), shop.getProductManager().getAllProducts());
            System.out.println(shop.getPurchaseManager().getAllClientPurchases(shop.getClientManager().getClient(0L)));
            shop.getProductManager().registerProduct("bbb", 10, 1, "ccdd");
            shop.getClientManager().registerClient("bbb", "cccc", "wwa", "ullica", "10", new Standard());
            shop.getPurchaseManager().registerPurchase(shop.getClientManager().getClient(2L), shop.getProductManager().getProduct(2L));
            System.out.println(shop.getPurchaseManager().getAllClientPurchases(shop.getClientManager().getClient(2L)));
            System.out.println(shop.getClientManager().getClient(2L));
            em.getTransaction().commit();
        }
    }
}
