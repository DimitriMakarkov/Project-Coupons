package Facade;

import DAO.CompanyDAO;
import DAO.CouponsDAO;
import DAO.CustomersDAO;

public abstract class ClientFacade {

    public CompanyDAO companyDAO;
    public CustomersDAO customersDAO;
    public CouponsDAO couponsDAO;


    public boolean Login(String Email, String Password){

        return false;
    }
}
