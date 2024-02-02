package Facade;

public class CustomerFacade extends ClientFacade{
    private int CustomerID;

    @Override
    public boolean Login(String Email, String Password) {
        if (customersDAO.isCustomerExists(Email,Password)){
            return true;
        }
        return false;
    }
}
