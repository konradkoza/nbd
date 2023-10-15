package p.lodz.RepositoryTests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import p.lodz.Model.Address;
import p.lodz.Model.Client;
import p.lodz.Model.Type.ClientType;
import p.lodz.Model.Type.Premium;
import p.lodz.Repositiories.ClientRepository;
import p.lodz.Repositiories.Implementations.ClientRepositoryImpl;
import static org.junit.jupiter.api.Assertions.*;

public class ClientRepositoryTest {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ClientRepository clientRepository;

    @BeforeAll
    static void initTest() {
        emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
        clientRepository = new ClientRepositoryImpl(em);
    }

    @Test
    void saveClientTest() {
        ClientType clientType = new Premium();
        Address address = new Address("aaa", "bbb", "ccc");
        Client client = new Client("Adam", "Fajny", address, clientType);
        assertEquals(client, clientRepository.saveClient(client));
    }

    @Test
    void archiveClientTest() {
        ClientType clientType = new Premium();
        Address address = new Address("aaa", "bbb", "ccc");
        Client client = new Client("Adam", "Fajny", address, clientType);
        Client savedClient = clientRepository.saveClient(client);
        Client client1 = clientRepository.archiveClient(savedClient.getId());
        assertTrue(client1.isArchived());
    }

    @AfterAll
    static void endTest() {
        if(emf != null) emf.close();
    }
}
