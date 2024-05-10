import java.util.*;

public class VirtualAssistant {
    List<Client> clients = new ArrayList<>();
    List<Service> services = new ArrayList<>();
    List<Invoice> invoices = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addClient(String name, String email) {
        Client client = new Client(name, email);
        clients.add(client);
    }

    public void viewClients() {
        for (Client client : clients) {
            System.out.println("Name: " + client.name + ", Email: " + client.email);
        }
    }

    public void addService(String name, String rateString) {
        double rate = Double.parseDouble(rateString.replaceAll("[^\\d.]", ""));
        Service service = new Service(name, rate);
        services.add(service);
    }

    public void viewServices() {
        for (Service service : services) {
            System.out.println("Name: " + service.name + ", Rate: $" + service.rate);
        }
    }

    public void deleteService(String name) {
        for (Iterator<Service> iterator = services.iterator(); iterator.hasNext(); ) {
            Service service = iterator.next();
            if (service.name.equals(name)) {
                iterator.remove();
                System.out.println("Service deleted successfully.");
                return;
            }
        }
        System.out.println("Service not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VirtualAssistant assistant = new VirtualAssistant();

        while (true) {
            System.out.println("1. Add Client");
            System.out.println("2. View Clients");
            System.out.println("3. Add Service");
            System.out.println("4. View Services");
            System.out.println("5. Delete Service");

            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter client name: ");
                    String name = scanner.next();
                    System.out.print("Enter client email: ");
                    String email = scanner.next();
                    assistant.addClient(name, email);
                    break;
                case 2:
                    assistant.viewClients();
                    break;
                case 3:
                    System.out.print("Enter service name: ");
                    String serviceName = scanner.next();
                    System.out.print("Enter service rate: ");
                    String rateString = scanner.next();
                    assistant.addService(serviceName, rateString);
                    break;
                case 4:
                    assistant.viewServices();
                    break;
                case 5:
                    System.out.print("Enter service name to delete: ");
                    String serviceToDelete = scanner.next();
                    assistant.deleteService(serviceToDelete);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
