package p.lodz;


import org.junit.jupiter.api.Test;
import p.lodz.Model.Client;
import p.lodz.Model.Product;
import p.lodz.Model.Purchase;
import p.lodz.Model.Shop;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
//    Shop sklep = new Shop();
//    Product test = sklep.getProductManager().registerProduct("test", 100, 10, "test");
//    Client jan = sklep.getClientManager().registerClient("Jan", "Kowalski", "Warszawa", "burakowska", "32B");
//    Purchase zakup =  sklep.getPurchaseManager().registerPurchase(jan, test);
//
//    @Test
//    public void clientOrderTest() {
//        assertEquals(sklep.getPurchaseManager().findAllPurchases().size() ,1);
//        Product test2 = sklep.getProductManager().registerProduct("test2", 20, 10, "test2");
//        Client zbyniu = sklep.getClientManager().registerClient("Zbyniu", "Laskowski", "Lodz", "burakowska", "32A");
//        sklep.getPurchaseManager().registerPurchase(zbyniu,test2);
//        assertEquals(sklep.getPurchaseManager().findAllPurchases().size() ,2);
//        assertEquals(sklep.getPurchaseManager().checkClientMoneySpent(zbyniu),20);
//        assertEquals(sklep.getPurchaseManager().checkClientMoneySpent(jan),100);
//        sklep.getPurchaseManager().registerPurchase(zbyniu,test2);
//        assertEquals(sklep.getPurchaseManager().checkClientMoneySpent(zbyniu),40);
//    }
//    @Test
//    public void productLimitTest() {
//        Product test2 = sklep.getProductManager().registerProduct("test2", 20, 3, "test2");
//        Client zbyniu = sklep.getClientManager().registerClient("Zbyniu", "Laskowski", "Lodz", "burakowska", "32A");
//        sklep.getPurchaseManager().registerPurchase(zbyniu,test2);
//        sklep.getPurchaseManager().registerPurchase(zbyniu,test2);
//        sklep.getPurchaseManager().registerPurchase(zbyniu,test2);
//        assertEquals(sklep.getPurchaseManager().findAllPurchases().size() ,4);
//        assertEquals(test2.getNumberOfProducts(),0);
//        try {
//            sklep.getPurchaseManager().registerPurchase(zbyniu, test2);
//            fail("Expected RuntimeException, but no exception was thrown.");
//        } catch (RuntimeException e) {
//            assertTrue(true, "Expected exception message or additional assertions");
//        }
//        assertEquals(sklep.getPurchaseManager().findAllPurchases().size() ,4);
//    }
}
