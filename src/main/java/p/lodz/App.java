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


//        Product test2 = sklep.getProductManager().registerProduct("test2", 100, 10, "test");
        Address address = new Address("Warszawa", "aaa", "777");
//        ClientType clientType = new Standard();
//        ClientType clientType1 = new Premium();

//        Client jan1 = new Client("Jan", "Kowalski", address, clientType1);

//        List<Product> products1 = new ArrayList<>();
//        products1.add(test2);
//        Purchase zakup =  sklep.getPurchaseManager().registerPurchase(jan, products);
//        Purchase zakup1 =  sklep.getPurchaseManager().registerPurchase(jan, products1);
//        System.out.println(zakup.toString());
//
       try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("test")) {
           EntityManager em = emf.createEntityManager();
           Shop sklep = new Shop(em);
           ClientType clientType = new Premium();
           Product test = sklep.getProductManager().registerProduct("test", 100, 10, "test");
           Product test2 = sklep.getProductManager().registerProduct("jablko", 100, 10, "test");

           Client jan = new Client("Jan", "Kowalski", address, clientType);
           em.getTransaction().begin();
            em.merge(clientType);
            em.merge(jan);
            sklep.getPurchaseManager().registerPurchase(jan,test,9);
            sklep.getPurchaseManager().registerPurchase(jan,test2,3);
            em.getTransaction().commit();
//
        }
    }
}
