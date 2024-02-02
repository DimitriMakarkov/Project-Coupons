package Facade;

public class LoginManager {

    public ClientFacade Login(String Email,String Password,ClientType Type){
        switch (Type){
            case Administrator :
                return new AdminFacade();

            case Company:
                return new CompanyFacade();

            case Customer:
                return new CustomerFacade();
        }
        return null;
    }
}
