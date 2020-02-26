package functionalinterface;

import java.util.function.BiConsumer;

public class _BiConsumer {

    public static void main(String[] args) {
        // Normal java function
        Customer severo = new Customer("Severo", "999999999");
        greetCustomer(severo, true);
        greetCustomer(severo, false);

        // Consumer Functional Interface
        greetCustomerBiConsumer.accept(severo, true);
        greetCustomerBiConsumer.accept(severo, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number " +
                    (showPhoneNumber ? customer.customerPhoneNumber : "***********"));

    static void greetCustomer(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number " +
                (showPhoneNumber ? customer.customerPhoneNumber : "***********"));
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
