package p.lodz.model;

public class Client {
    private String firstName;
    private String lastName;
    private final int personalId;
    Address address;
    ClientType clientType;

    private boolean archived = false;

    private double moneySpent;

    public Client(String firstName, String lastName, int personalId, String city, String street, String number, ClientType clientType, double moneySpent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalId = personalId;
        this.address = new Address(city, street, number);
        this.clientType = clientType;
        this.moneySpent = moneySpent;
        //TODO EXCEPTIONS
    }

    public int getId() {
        return personalId;
    }

    public String getStreet(){
        return address.getStreet();
    }

    public String getCity(){
        return address.getCity();
    }

    public String getNumber(){
        return address.getNumber();
    }

    public double getClientDiscount(){
        return clientType.getClientDiscount();
    }

    public int getClientShorterDeliveryTime(){
        return clientType.getShorterDeliveryTime();
    }

    public String getFirstName() {
        return firstName;
    }

    //TODO sprawdzenie poprawnosci w setterach
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public void addMoneySpent(double value){
        moneySpent += value;
    }
}
