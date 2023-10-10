package p.lodz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import p.lodz.Model.Client;
import p.lodz.Model.Product;
import p.lodz.Model.Purchase;
import p.lodz.Model.Shop;

public class App
{
    public static void main( String[] args )
    {
        Shop sklep = new Shop();
        Product test = sklep.getProductManager().registerProduct("test", 100, 1, "test");
        Product test1 = sklep.getProductManager().registerProduct("test1", 100, 10, "test");
        Product test2 = sklep.getProductManager().registerProduct("test2", 100, 10, "test");
        Client jan = sklep.getClientManager().registerClient("Jan", "Kowalski", "Warszawa", "burakowska", "32B");
        Purchase zakup =  sklep.getPurchaseManager().registerPurchase(jan, test);
        Purchase zakup1 = sklep.getPurchaseManager().registerPurchase(jan, test1);
        Purchase zakup2 = sklep.getPurchaseManager().registerPurchase(jan, test1);
        System.out.println(zakup.toString());
        System.out.println(zakup1.toString());
        System.out.println(zakup2.toString());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(test);
        em.getTransaction().commit();
        emf.close();
    }
}
