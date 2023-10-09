package p.lodz;

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
    }
}
