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

    public boolean isCustomerDuplicate(String Email) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, Email);
        ResultSet result = DB_Utilities.RunCommandWithResult(Customer_Commands.isCustomerDuplicate, params);
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
        return null;
    }

    public String updateCustomer(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> params = new HashMap();
        params.put(1, customer.getFirstName());
        params.put(2, customer.getLastName());
        params.put(3, customer.getEmail());
        params.put(4, customer.getPassword());
        params.put(5, customer.getEmail());
        params.put(6, customer.getPassword());
        DB_Utilities.RunCommand(Customer_Commands.updateCustomer, params);
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
        params.put(1, CustomerID);
        if (DB_Utilities.RunCommand(Customer_Commands.deleteCustomer, params)) {
            System.out.println("The Customer Has Been Deleted");
        } else {
            System.out.println("The Customer Has Not Been Deleted");
        }
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
            System.out.println(customer);
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCustomerViaEmailAndPass(String Email, String Password) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, Email);
        params.put(2, Password);
        ResultSet results = DB_Utilities.RunCommandWithResult(Customer_Commands.getCustomerID, params);
        try {
            while (results.next()) {
                int ID = results.getInt("ID");
                return ID;
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
