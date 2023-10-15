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
            em.getTransaction().commit();
        }
    }
}
