package p.lodz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.A;
import p.lodz.Model.*;
import p.lodz.Model.Type.ClientType;
import p.lodz.Model.Type.Premium;
import p.lodz.Model.Type.Standard;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Shop sklep = new Shop();
        Product test = sklep.getProductManager().registerProduct("test", 100, 1, "test");
        Product test1 = sklep.getProductManager().registerProduct("test1", 100, 10, "test");
        Product test2 = sklep.getProductManager().registerProduct("test2", 100, 10, "test");
        Address address = new Address("Warszawa", "aaa", "777");
        ClientType clientType = new Standard();
        ClientType clientType1 = new Premium();
        Client jan = new Client(1L, "Jan", "Kowalski", address, clientType);
        Client jan1 = new Client(2L, "Jan", "Kowalski", address, clientType1);
        List<Product> products = new ArrayList<>();
        products.add(test);
        products.add(test1);
        List<Product> products1 = new ArrayList<>();
        products1.add(test2);
        Purchase zakup =  sklep.getPurchaseManager().registerPurchase(jan, products);
        Purchase zakup1 =  sklep.getPurchaseManager().registerPurchase(jan, products1);
        System.out.println(zakup.toString());

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("test")) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(test);
            em.merge(test1);
            em.merge(test2);
            em.merge(clientType);
            em.merge(clientType1);
            em.merge(jan);
            em.merge(jan1);
            em.merge(zakup1);
            em.merge(zakup);
            em.getTransaction().commit();
        }
    }
}
