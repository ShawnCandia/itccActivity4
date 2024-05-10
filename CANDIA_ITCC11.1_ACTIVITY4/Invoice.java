public class Invoice {
    Client client;
    Service service;
    double hours;

    Invoice(Client client, Service service, double hours) {
        this.client = client;
        this.service = service;
        this.hours = hours;
    }
}
