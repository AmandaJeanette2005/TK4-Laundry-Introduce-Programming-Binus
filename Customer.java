import java.util.Scanner;

public class Customer {
    private String id;
    private String name;
    private String phoneNumber;

    static Scanner scanner = new Scanner(System.in);
    static Repository repository = new Repository();

    public Customer(String id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ID Customer: " + id + "\nCustomer Name: " + name + "\nPhone Number: " + phoneNumber;
    }
    


public static void customerMenu() {
        while (true) {
            System.out.println("\n============================== Customer Menu ==============================");
            System.out.println("1. Add Customer");
            System.out.println("2. Delete Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. View Customers");
            System.out.print("Choose an option [0:Exit Application]: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.println("Enter customer name : ");
                    String custName = scanner.nextLine();

                    System.out.println("Enter customer phone number : ");
                    String custPhoneNumber = scanner.nextLine();

                    repository.addCustomer(custName, custPhoneNumber);
                    break;
                case 2:
                    System.out.println("Enter customer id : ");
                    String custId = scanner.nextLine();

                    repository.deleteCustomer(custId);
                    break;
                case 3:
                    System.out.println("Enter customer id");
                    String idCustUpdate = scanner.nextLine();

                    Customer findCust = repository.findCustById(idCustUpdate);
                    if (findCust != null) {
                        System.out.println("Enter customer name : ");
                        String custNewName = scanner.nextLine();

                        System.out.println("Enter customer phone number : ");
                        String custNewPhoneNumber = scanner.nextLine();

                        repository.updateCustomer(idCustUpdate, custNewName, custNewPhoneNumber);
                    } else {
                        System.out.println("Customer not found");
                    }
                    break;
                case 4:
                    repository.displayCustomer();
                    break;
                default:
                    break;
            }
        }
    }
}
// class CustomerService {
// private ArrayList<Customer> customers = new ArrayList<>();
// private int nextId = 1;

// public void addCustomer(String name) {
// customers.add(new Customer(nextId++, name));
// }

// public ArrayList<Customer> getCustomers() {
// return customers;
// }

// public Customer getCustomerById(int id) {
// for (Customer customer : customers) {
// if (customer.getId() == id) {
// return customer;
// }
// }
// return null;
// }

// public void updateCustomer(int id, String name) {
// Customer customer = getCustomerById(id);
// if (customer != null) {
// customer.setName(name);
// }
// }

// public void deleteCustomer(int id) {
// customers.removeIf(customer -> customer.getId() == id);
// }
// }
