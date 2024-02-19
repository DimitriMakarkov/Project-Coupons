
import DBDAO.CreateTablesDBDAO;
import Facade.AdminFacade;
import Facade.ClientFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;
import Java_Beans.Category;
import Java_Beans.Company;
import Java_Beans.Coupons;
import Java_Beans.Customer;
import Job.CouponExpirationDaily;
import Login.ClientType;
import Login.LoginManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tester {

    public static void main(String[] args) {
        testAll();
    }















    public static void testAll() {
//       Thread dailyTask = new Thread(new CouponExpirationDaily());
//       dailyTask.start();
        CreateTablesDBDAO createTablesDBDAO = new CreateTablesDBDAO();
        createTablesDBDAO.createAllTables();
//          try{
//        String StartDate = "2024/01/01";
//        String EndDate = "2025/01/01";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//        Date Startdate = sdf.parse(StartDate);
//        Date Enddate = sdf.parse(EndDate);
//        long StartDateMilli = Startdate.getTime();
//        long EndDatemilli = Enddate.getTime();




//        Company company = new Company("test Company", "test@gmail.com", "12345678");
//        Customer customer = new Customer("firsttttttt", "last", "email@gmail.com", "211");
//        Coupons coupons = new Coupons(3,3,"Restaurant","20% off",Startdate,Enddate,2,55,null);
//        ClientFacade userAdminTest = LoginManager.getInstance().Login("admin@admin.com", "admin", ClientType.Administrator);
//        ClientFacade userCompanyTest = LoginManager.getInstance().Login("test1@gmail.com", "12345678", ClientType.Company);
//        ClientFacade userCustomerYest = LoginManager.getInstance().Login("email@gmail.com", "211", ClientType.Customer);

//        ((AdminFacade) userAdminTest).addCompany(company);
//        ((AdminFacade) userAdminTest).updateCompany(company);
//        ((AdminFacade) userAdminTest).deleteCompany(11);
//        ((AdminFacade) userAdminTest).getAllCompanies();
//        ((AdminFacade) userAdminTest).getOneCompany(16);
////
//        ((AdminFacade) userAdminTest).addCustomer(customer);
//        ((AdminFacade) userAdminTest).updateCustomer(customer);
//        ((AdminFacade) userAdminTest).deleteCustomer(3);
//        ((AdminFacade) userAdminTest).getAllCustomers();
//        ((AdminFacade) userAdminTest).getOneCustomer(4);

//        ((CompanyFacade) userCompanyTest).addCoupon(coupons);
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

//          } catch (ParseException e) {
//              throw new RuntimeException(e);
//          }
    }

}

