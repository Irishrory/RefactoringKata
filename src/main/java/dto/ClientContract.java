package dto;

import java.util.List;

public class ClientContract {

    Client client;
    List<Contract> contracts;

    public Client getClient() {
        return client;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
