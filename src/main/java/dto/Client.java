package dto;

public class Client {

    String clientId;
    String first_name;
    String last_name;
    String address;
    String country;

    public Client(String clientId, String first_name, String last_name, String address, String country) {
        this.clientId = clientId;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.country = country;
    }

    public String getClientId() {
        return clientId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }
}
