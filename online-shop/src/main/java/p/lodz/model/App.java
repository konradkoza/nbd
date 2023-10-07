package p.lodz.model;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Shop sklep = new Shop();
       Product test = sklep.getProductManager().registerProduct("test", 100, 10, "test");
       Client jan = sklep.getClientManager().registerClient("Jan", "Kowalski", "Warszawa", "burakowska", "32B");
       Purchase zakup =  sklep.getPurchaseManager().registerPurchase(jan, test);
       System.out.println(zakup.toString());
    }
}
