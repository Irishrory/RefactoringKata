package dto;

public class Contract {

    String contractId;
    String clientId;
    Float amount;

    public Contract(String contractId, String clientId, Float amount) {
        this.contractId = contractId;
        this.clientId = clientId;
        this.amount = amount;
    }

    public String getContractId() {
        return contractId;
    }

    public String getClientId() {
        return clientId;
    }

    public Float getAmount() {
        return amount;
    }
}
