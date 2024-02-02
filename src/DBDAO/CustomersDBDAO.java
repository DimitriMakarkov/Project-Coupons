package DBDAO;

import DAO.CustomersDAO;
import DataBase.DB_Utilities;
import Java_Beans.Customer;
import SQL_Commands.Customer_Commands;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomersDBDAO implements CustomersDAO {
    public CustomersDBDAO() {
    }

    public boolean isCustomerExists(String Email, String Password) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, Email);
        params.put(2, Password);
        ResultSet result = DB_Utilities.RunCommandWithResult(Customer_Commands.isCustomerExists, params);
        try {
            while (result.next()) {
                return result.getInt("RESULT") == 1;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String addCustomer(Customer customer) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, customer.getID());
        params.put(2, customer.getFirstName());
        params.put(3, customer.getLastName());
        params.put(4, customer.getEmail());
        params.put(5, customer.getPassword());
        DB_Utilities.RunCommand(Customer_Commands.addCustomer, params);
        System.out.println("The Customer Has Successfully Been Added!");
        return null;
    }

    public String updateCustomer(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> params = new HashMap();
        System.out.println("Please Enter A New First Name: ");
        System.out.print("> ");
        String FirstName = scanner.next();
        System.out.println("Please Enter A New Last Name: ");
        System.out.print("> ");
        String LastName = scanner.next();
        System.out.println("Please Enter A New Email: ");
        System.out.print("> ");
        String Email = scanner.next();
        System.out.println("Please Enter A New Password: ");
        System.out.print("> ");
        String Password = scanner.next();
        params.put(1, FirstName);
        params.put(2, LastName);
        params.put(3, Email);
        params.put(4, Password);
        params.put(5, customer.getEmail());
        params.put(6, customer.getPassword());
        DB_Utilities.RunCommand(Customer_Commands.updateCustomer, params);
        System.out.println("The Customer Has Been Updated!");
        return null;
    }

    public ArrayList<Customer> getAllCustomers() {
        ArrayList<Customer> customers = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandFromResult(Customer_Commands.getAllCustomers);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                String FirstName = results.getString(2);
                String LastName = results.getString(3);
                String Email = results.getString(4);
                String Password = results.getString(5);
                customers.add(new Customer(ID, FirstName, LastName, Email, Password));
            }

            customers.forEach(System.out::println);
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public String deleteCustomer(int CustomerID) {
        Map<Integer, Object> params = new HashMap();
        DB_Utilities.RunCommand(Customer_Commands.deleteCustomer, params);
        System.out.println("The Customer Has Been Deleted");
        return null;
    }

    public Customer getOneCustomer(int CustomerID) {
        Customer customer = null;
        try {
            ResultSet results = DB_Utilities.RunCommandWithParameter(Customer_Commands.getOneCustomer, CustomerID);
            if (results.next()) {
                int ID = results.getInt(1);
                String FirstName = results.getString(2);
                String LastName = results.getString(3);
                String Email = results.getString(4);
                String Password = results.getString(5);
                customer = new Customer(ID, FirstName, LastName, Email, Password);
            }
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
