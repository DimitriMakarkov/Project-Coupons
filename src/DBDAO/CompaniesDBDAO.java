package DBDAO;

import DAO.CompanyDAO;
import DataBase.ConnectionPool;
import DataBase.DB_Utilities;
import Java_Beans.Company;
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

    public String addCompany(Company company) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, company.getID());
        params.put(2, company.getName());
        params.put(3, company.getEmail());
        params.put(4, company.getPassword());
        DB_Utilities.RunCommand(Company_Commands.addCompany, params);
        System.out.println("The Company Has Successfully Been Added!");
        return null;
    }

    public String updateCompany(Company company) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> params = new HashMap();
        System.out.println("Please Enter A New Name: ");
        System.out.print("> ");
        String Name = scanner.next();
        System.out.println("Please Enter A New Email: ");
        System.out.print("> ");
        String Email = scanner.next();
        System.out.println("Please Enter A New Password: ");
        System.out.print("> ");
        String Password = scanner.next();
        params.put(1, Name);
        params.put(2, Email);
        params.put(3, Password);
        params.put(4, company.getEmail());
        params.put(5, company.getPassword());
        DB_Utilities.RunCommand(Company_Commands.updateCompany, params);
        System.out.println("The Company Has Been Updated!");
        return null;
    }

    public ArrayList<Company> getAllCompanies() {
        ArrayList<Company> companies = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandFromResult(Company_Commands.getAllCompanies);
        try {
            while (results.next()) {
                int id = results.getInt(1);
                String name = results.getString(2);
                String email = results.getString(3);
                String password = results.getString(4);
                companies.add(new Company(id, name, email, password));
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
        System.out.println("The Company Has Been Deleted");
        return null;
    }

    public Company getOneCompany(int CompanyID) {
        Company company = null;
        try {
            ResultSet results = DB_Utilities.RunCommandWithParameter(Company_Commands.getOneCompany, CompanyID);
            if (results.next()) {
                int ID = results.getInt("ID");
                String Name = results.getString("Name");
                String Email = results.getString("Email");
                String Password = results.getString("Password");
                company = new Company(ID, Name, Email, Password);
            }
            return company;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getCompanyID(String Email,String Password){
        Map<Integer, Object> params = new HashMap();
        params.put(1, Email);
        params.put(2, Password);
        try {
            ResultSet results = DB_Utilities.RunCommandWithParameter(Company_Commands.getCompanyViaEmailAndPass,params);
                int ID = results.getInt("ID");
                return ID;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
