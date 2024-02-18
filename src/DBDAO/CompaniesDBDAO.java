package DBDAO;

import DAO.CompanyDAO;
import DataBase.ConnectionPool;
import DataBase.DB_Utilities;
import Java_Beans.Company;
import Java_Beans.Coupons;
import SQL_Commands.Company_Commands;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CompaniesDBDAO implements CompanyDAO {
    private ConnectionPool connectionPool;

    public CompaniesDBDAO() {
    }

    public boolean isCompanyExists(String Email, String Password) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, Email);
        params.put(2, Password);
        ResultSet result = DB_Utilities.RunCommandWithResult(Company_Commands.isCompanyExists, params);
        try {
            while (result.next()) {
                return result.getInt("RESULT") == 1;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isCompanyDuplicate(String Name, String Email) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, Name);
        params.put(2, Email);
        ResultSet result = DB_Utilities.RunCommandWithResult(Company_Commands.isCompanyDuplicate, params);
        try {
            while (result.next()) {
                return result.getInt("RESULT") == 1;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String addCompany(Company company) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, company.getID());
        params.put(2, company.getName());
        params.put(3, company.getEmail());
        params.put(4, company.getPassword());
        DB_Utilities.RunCommand(Company_Commands.addCompany, params);
        return null;
    }

    public String updateCompany(Company company) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, company.getName());
        params.put(2, company.getEmail());
        params.put(3, company.getPassword());
        params.put(4, company.getEmail());
        params.put(5, company.getPassword());
        DB_Utilities.RunCommand(Company_Commands.updateCompany, params);
        return null;
    }

    public void updateCompanyEP(Company company) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, company.getEmail());
        params.put(2, company.getPassword());
        params.put(3, company.getName());
        DB_Utilities.RunCommand(Company_Commands.updateCompanyEP, params);
    }

    public ArrayList<Company> getAllCompanies() {
        ArrayList<Company> companies = new ArrayList();
        CouponsDBDAO couponsDBDAO = new CouponsDBDAO();
        ResultSet results = DB_Utilities.RunCommandFromResult(Company_Commands.getAllCompanies);
        try {
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String email = results.getString(3);
                String password = results.getString(4);
                ArrayList<Coupons> coup = new ArrayList<>();
                coup = couponsDBDAO.getAllCompanyCoupons(id);
                companies.add(new Company(id, name, email, password, coup));
            }
            companies.forEach(System.out::println);
            return companies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteCompany(int CompanyID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        DB_Utilities.RunCommand(Company_Commands.deleteComapny, params);
        return null;
    }

    public Company getOneCompany(int CompanyID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        Company company = null;
        CouponsDBDAO couponsDBDAO = new CouponsDBDAO();
        try {
            ResultSet results = DB_Utilities.RunCommandWithResult(Company_Commands.getOneCompany, params);
            if (results.next()) {
                int ID = results.getInt("ID");
                String Name = results.getString("Name");
                String Email = results.getString("Email");
                String Password = results.getString("Password");
                ArrayList<Coupons> coup = new ArrayList<>();
                coup = couponsDBDAO.getAllCompanyCoupons(CompanyID);
                company = new Company(ID, Name, Email, Password, coup);//removed id
            }
            System.out.println(company);
            return company;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCompanyID(String Email, String Password) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, Email);
        params.put(2, Password);
        try {
            ResultSet results = DB_Utilities.RunCommandWithResult(Company_Commands.getCompanyViaEmailAndPass, params);
            while (results.next()) {
                return results.getInt("ID");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
