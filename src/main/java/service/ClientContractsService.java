package service;

import dto.Client;
import dto.ClientContract;
import dto.Contract;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class ClientContractsService {

    private final JdbcTemplate jdbcTemplate;

    public ClientContractsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ClientContract> getClientContracts() {

        List<Client> clients = jdbcTemplate.query("select * from CLIENTS", (rs, i) -> {
            return new Client(
                    rs.getString("CLIENT_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"),
                    rs.getString("ADDRESS"),
                    rs.getString("COUNTRY"));
        });

        List<Contract> contracts = jdbcTemplate.query("select * from CONTRACTS", (rs, i) -> {
            return new Contract(
                    rs.getString("CONTRACT_D"),
                    rs.getString("CLIENT_ID"),
                    rs.getFloat("AMOUNT")
            );
        });

        return buildClientContracts(clients, contracts);
    }

    private List<ClientContract> buildClientContracts(List<Client> clients, List<Contract> contracts) {

        List<ClientContract> clientContracts = new ArrayList<>();

        for (Client client : clients) {

            List<Contract> contracts1 = new ArrayList<>();

            for (Contract contract : contracts) {
                if (contract.getClientId().equals(client.getClientId())) {
                    contracts1.add(contract);
                }
            }

            ClientContract clientContract = new ClientContract();
            clientContract.setContracts(contracts1);
            clientContract.setClient(client);

            clientContracts.add(clientContract);
        }

        return clientContracts;
    }
}
