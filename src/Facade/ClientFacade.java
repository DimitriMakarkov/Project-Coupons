package Facade;

import DAO.CompanyDAO;
import DAO.CouponsDAO;
import DAO.CustomersDAO;
import DBDAO.CompaniesDBDAO;
import DBDAO.CouponsDBDAO;
import DBDAO.CustomersDBDAO;

public abstract class ClientFacade {
    protected CompanyDAO companyDAO = new CompaniesDBDAO();
    protected CustomersDAO customersDAO = new CustomersDBDAO();
    protected CouponsDAO couponsDAO = new CouponsDBDAO();


    public abstract boolean Login(String Email, String Password);

}
