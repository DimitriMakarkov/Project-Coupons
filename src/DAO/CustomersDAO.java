package DAO;

import Java_Beans.Customer;

import java.util.ArrayList;

public interface CustomersDAO {
    ArrayList<Customer> getAllCustomers();

    boolean isCustomerExists(String Email, String Password);

    boolean isCustomerDuplicate(String Email);

    String addCustomer(Customer customer);

    String updateCustomer(Customer customer);

    String deleteCustomer(int CustomerID);

    Customer getOneCustomer(int CustomerID);
}
