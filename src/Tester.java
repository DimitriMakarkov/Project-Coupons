
import Facade.AdminFacade;
import Facade.ClientFacade;
import Facade.CompanyFacade;
import Java_Beans.Company;
import Java_Beans.Coupons;
import Java_Beans.Customer;
import Login.ClientType;
import Login.LoginManager;

import java.time.LocalDate;
import java.util.Date;

public class Tester {

    public static void main(String[] args) {
    testAll();
//        LocalDate date = new LocalDate();
//        System.out.println(date);
    }





    public static void testAll(){
//        CouponExpirationDaily Thread = new CouponExpirationDaily();
//        Thread.run();
        Company company = new Company("test Company","test@gmail.com","12345678");
        Customer customer = new Customer("firsttttttt","last","email@gmail.com","211");
//        Coupons coupons = new Coupons(11,3,"Restaurant","20% off","2024-02-01",2025-01-01,3,55,null);
        ClientFacade userAdminTest = LoginManager.getInstance().Login("admin@admin.com", "admin", ClientType.Administrator);
        ClientFacade userCompanyTest = LoginManager.getInstance().Login("test@gmail.com", "12345678", ClientType.Company);
//
//            ((AdminFacade) userAdminTest).addCompany(company);
//            ((AdminFacade) userAdminTest).updateCompany(company);
//            ((AdminFacade) userAdminTest).deleteCompany(3);
//            ((AdminFacade) userAdminTest).getAllCompanies();
//            ((AdminFacade) userAdminTest).getOneCompany(11);
//
//            ((AdminFacade) userAdminTest).addCustomer(customer);
//            ((AdminFacade) userAdminTest).updateCustomer(customer);
//            ((AdminFacade) userAdminTest).deleteCustomer(3);
//            ((AdminFacade) userAdminTest).getAllCustomers();
//            ((AdminFacade) userAdminTest).getOneCustomer(4);

//        ((CompanyFacade) userCompanyTest).addCoupon();

        }

    }

