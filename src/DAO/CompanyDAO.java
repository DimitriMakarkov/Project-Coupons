package DAO;

import Java_Beans.Company;
import java.util.ArrayList;

public interface CompanyDAO {
    ArrayList<Company> getAllCompanies();

    boolean isCompanyExists(String Email, String Password);

    boolean isCompanyDuplicate(String Name,String Email);

    String addCompany(Company company);

    String updateCompany(Company company);

    String deleteCompany(int CompanyID);

    Company getOneCompany(int CompanyID);

    int getCompanyID(String Email,String Password);
}