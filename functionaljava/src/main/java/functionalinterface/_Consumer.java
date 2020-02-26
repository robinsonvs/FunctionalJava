package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        // Normal java function
        Customer severo = new Customer("Severo", "999999999");
        greetCustomer(severo);

        // Consumer Functional Interface
        greetCustomerConsumer.accept(severo);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " +
                    customer.customerPhoneNumber);

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                customer.customerPhoneNumber);
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
