
import DBDAO.CreateTablesDBDAO;
import Facade.AdminFacade;
import Facade.ClientFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;
import Java_Beans.Category;
import Java_Beans.Company;
import Java_Beans.Customer;
import Job.CouponExpirationDaily;
import Login.ClientType;
import Login.LoginManager;


public class Tester {

    public static void main(String[] args) {
        testAll();
    }


    public static void testAll() {
//        CouponExpirationDaily Thread = new CouponExpirationDaily();
//        Thread.run();
        CreateTablesDBDAO createTablesDBDAO = new CreateTablesDBDAO();
        createTablesDBDAO.createAllTables();
//        Company company = new Company("test Company", "test@gmail.com", "12345678");
//        Customer customer = new Customer("firsttttttt", "last", "email@gmail.com", "211");
//        Coupons coupons = new Coupons(3,3,"Restaurant","20% off",Startdate,Enddate,2,55,null);
//        ClientFacade userAdminTest = LoginManager.getInstance().Login("admin@admin.com", "admin", ClientType.Administrator);
//        ClientFacade userCompanyTest = LoginManager.getInstance().Login("test@gmail.com", "12345678", ClientType.Company);
//        ClientFacade userCustomerYest = LoginManager.getInstance().Login("email@gmail.com", "211", ClientType.Customer);

//        ((AdminFacade) userAdminTest).addCompany(company);
//        ((AdminFacade) userAdminTest).updateCompany(company);
//        ((AdminFacade) userAdminTest).deleteCompany(11);
//        ((AdminFacade) userAdminTest).getAllCompanies();
//        ((AdminFacade) userAdminTest).getOneCompany(16);
//
//        ((AdminFacade) userAdminTest).addCustomer(customer);
//        ((AdminFacade) userAdminTest).updateCustomer(customer);
//        ((AdminFacade) userAdminTest).deleteCustomer(3);
//        ((AdminFacade) userAdminTest).getAllCustomers();
//        ((AdminFacade) userAdminTest).getOneCustomer(4);

//        ((CompanyFacade) userCompanyTest).addCoupon();
//        ((CompanyFacade) userCompanyTest).updateCoupon();

//        ((CompanyFacade) userCompanyTest).deleteCoupon(7);
//        ((CompanyFacade) userCompanyTest).getCompanyCoupons();
//        ((CompanyFacade) userCompanyTest).getCompanyCoupons(Category.Electricity);
//        ((CompanyFacade) userCompanyTest).getCompanyCoupons(34);
//        ((CompanyFacade) userCompanyTest).getCompanyDetails();

//        ((CustomerFacade) userCustomerYest).PurchaseCoupon();

//        ((CustomerFacade) userCustomerYest).getCustomerCoupons();
//        ((CustomerFacade) userCustomerYest).getCustomerCoupons(Category.Electricity);
//        ((CustomerFacade) userCustomerYest).getCustomerCoupons(36);
//        ((CustomerFacade) userCustomerYest).getCustomerDetails();

    }

}

