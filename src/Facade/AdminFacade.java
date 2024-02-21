package Facade;

import Java_Beans.Company;
import Java_Beans.Customer;

import java.util.ArrayList;
import java.util.SortedMap;

public class AdminFacade extends ClientFacade {

    public AdminFacade() {
    }

    @Override
    public boolean Login(String Email, String Password) {
        if (Email.equals("admin@admin.com") && Password.equals("admin")) {
            return true;
        }
        return false;
    }

    public void addCompany(Company company) {
        System.out.println(company);
        if (!companyDAO.isCompanyDuplicate(company.getName(), company.getEmail())) {
            companyDAO.addCompany(company);
            System.out.println("The Company Has Successfully Been Added!");
            System.out.println();
        } else {
            System.out.println("A Company With The Same Email Or Name Already Exists");
        }
    }

    public void updateCompany(Company company) {
        System.out.println(company);
        companyDAO.updateCompanyEP(company);
        System.out.println("The Company's Email And Password Have Been Updated!");
    }

    public void deleteCompany(int CompanyID) {
        couponsDAO.deleteCompanyHistory(CompanyID);
        companyDAO.deleteCompany(CompanyID);
        System.out.println("The Company Has Been Deleted");
    }

    public ArrayList<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    public Company getOneCompany(int CompanyID) {
        return companyDAO.getOneCompany(CompanyID);
    }

    public void addCustomer(Customer customer) {
        System.out.println(customer);
        if (customersDAO.isCustomerDuplicate(customer.getEmail())) {
            System.out.println("Customer With The Same Email Exists");
        } else {
            customersDAO.addCustomer(customer);
            System.out.println("The Customer Has Been Added!");
        }
    }

    public void updateCustomer(Customer customer) {
        System.out.println(customer);
        customersDAO.updateCustomer(customer);
        System.out.println("The Customer Has Been Updated!");
    }

    public void deleteCustomer(int CustomerID) {
        couponsDAO.deleteCustomerHistory(CustomerID);
        customersDAO.deleteCustomer(CustomerID);
    }

    public ArrayList<Customer> getAllCustomers() {
        return customersDAO.getAllCustomers();
    }

    public Customer getOneCustomer(int CustomerID) {
        return customersDAO.getOneCustomer(CustomerID);
    }
}
