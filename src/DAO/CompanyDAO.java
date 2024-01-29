package DAO;

import Java_Beans.Company;
import java.util.ArrayList;

public interface CompanyDAO {
    ArrayList<Company> getAllCompanies();

    boolean isCompanyExists(String Email, String Password);

    String addCompany(Company company);

    String updateCompany(Company company);

    String deleteCompany(int CompanyID);

    Company getOneCompany(int CompanyID);
}