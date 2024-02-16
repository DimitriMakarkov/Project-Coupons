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
                AdminFacade admin = new AdminFacade();
                if(admin.Login(Email,Password)){
                    System.out.println("Admin Logged in Successfully!");
                    return admin;
                }
                else {
                    System.out.println("Login ERROR");
                }
            case Company:
                CompanyFacade company = new CompanyFacade();
                if(company.Login(Email,Password)){
                    System.out.println("Company Logged in Successfully!");
                    return company;
                }
                else {
                    System.out.println("Login ERROR");
                }
            case Customer:
                CustomerFacade customer = new CustomerFacade();
                if (customer.Login(Email,Password)){
                    System.out.println("Customer Logged in Successfully!");
                    return customer;
                }
                else {
                    System.out.println("Login ERROR");
                }
        }
        return null;
    }
}
