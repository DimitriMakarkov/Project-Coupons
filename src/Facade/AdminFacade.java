package Facade;

import Java_Beans.Company;
import Java_Beans.Customer;
import java.util.ArrayList;

public class AdminFacade extends ClientFacade{

    public AdminFacade() {
    }

    @Override
    public boolean Login(String Email, String Password) {
        if (Email.equals("admin@admin.com") && Password.equals("admin")){
            return true;
        }
        return false;
    }

    public void addCompany(Company company){
        if (companyDAO.isCompanyDuplicate(company.getName(),company.getEmail())){
            System.out.println("Please enter a different name or email ");
        }
        else {
            companyDAO.addCompany(company);
        }
    }

    public void updateCompany(Company company){
        companyDAO.updateCompany(company);
    }

    public void deleteCompany(int CompanyID){
        couponsDAO.deleteCompanyCoupons(CompanyID);
    }

    public ArrayList<Company> getAllCompanies(){
        return companyDAO.getAllCompanies();
    }

    public Company getOneCompany(int CompanyID){
        return companyDAO.getOneCompany(CompanyID);
    }

    public void addCustomer(Customer customer){       //todo
        customersDAO.addCustomer(customer);
    }

    public void updateCustomer(Customer customer){
        customersDAO.updateCustomer(customer);
    }

    public void deleteCustomer(int CustomerID){
        customersDAO.deleteCustomer(CustomerID);
    }

    public ArrayList<Customer> getAllCustomers(){
        return customersDAO.getAllCustomers();
    }

    public Customer getOneCustomer(int CustomerID){
        return customersDAO.getOneCustomer(CustomerID);
    }
}
