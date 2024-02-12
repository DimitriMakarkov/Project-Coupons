package Facade;

import DAO.CompanyDAO;
import DAO.CouponsDAO;
import DAO.CustomersDAO;

public abstract class ClientFacade {
    protected CompanyDAO companyDAO;
    protected CustomersDAO customersDAO;
    protected CouponsDAO couponsDAO;

    public abstract boolean Login(String Email, String Password);

}
