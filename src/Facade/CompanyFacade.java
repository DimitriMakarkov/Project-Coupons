package Facade;

public class CompanyFacade extends ClientFacade{

    private int CompanyID;

    public CompanyFacade() {
    }

    @Override
    public boolean Login(String Email, String Password) {
        return super.Login(Email, Password);
    }
}
