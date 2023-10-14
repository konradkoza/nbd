package p.lodz.Repositiories;

import p.lodz.Model.Client;

public interface ClientRepository {
    Client saveClient(Client client);
    Client archiveClient(Long id);
}
