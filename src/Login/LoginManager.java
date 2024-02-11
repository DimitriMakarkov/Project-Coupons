package Login;

import Facade.AdminFacade;
import Facade.ClientFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;


public class LoginManager {

    private static LoginManager instance;

    private LoginManager() {
    }

    public static LoginManager getInstance() {
        if (instance == null) {
            synchronized (LoginManager.class) {
                if (instance == null) {
                    instance = new LoginManager();
                }
            }
        }
        return instance;
    }

    public ClientFacade Login(String Email, String Password, ClientType Type) {
        switch (Type) {
            case Administrator:
                return new AdminFacade();

            case Company:
                return new CompanyFacade();

            case Customer:
                return new CustomerFacade();
        }
        return null;
    }
}
