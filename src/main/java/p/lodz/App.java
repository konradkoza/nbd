package p.lodz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.A;
import p.lodz.Model.*;
import p.lodz.Model.Type.ClientType;
import p.lodz.Model.Type.Standard;

public class App {
    public static void main(String[] args) {
        Shop sklep = new Shop();
        Product test = sklep.getProductManager().registerProduct("test", 100, 1, "test");
        Product test1 = sklep.getProductManager().registerProduct("test1", 100, 10, "test");
        Product test2 = sklep.getProductManager().registerProduct("test2", 100, 10, "test");
        Address address = new Address("Warszawa", "aaa", "777");
        ClientType clientType = new Standard();
        Client jan = new Client(1L, "Jan", "Kowalski", address, clientType);
        Purchase zakup =  sklep.getPurchaseManager().registerPurchase(jan, test);
        Purchase zakup1 = sklep.getPurchaseManager().registerPurchase(jan, test1);
        Purchase zakup2 = sklep.getPurchaseManager().registerPurchase(jan, test1);
        System.out.println(zakup.toString());
        System.out.println(zakup1.toString());
        System.out.println(zakup2.toString());

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("test")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(test);
            em.merge(clientType);
            em.merge(jan);
            em.getTransaction().commit();
        }
    }
}
