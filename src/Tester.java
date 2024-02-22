
import DBDAO.CreateTablesDBDAO;
import Exceptions.ClientException;
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

        CreateTablesDBDAO createTablesDBDAO = new CreateTablesDBDAO();
        createTablesDBDAO.createAllTables();

        CouponExpirationDaily couponExpirationDaily = new CouponExpirationDaily();
        Thread dailyTask = new Thread(new CouponExpirationDaily());
        dailyTask.start();
        try {
            String StartDate = "2024/01/01";
            String EndDate = "2025/01/01";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date Startdate = sdf.parse(StartDate);
            Date Enddate = sdf.parse(EndDate);
            long StartDateMilli = Startdate.getTime();
            long EndDatemilli = Enddate.getTime();
            java.sql.Date CouponStartDate = new java.sql.Date(StartDateMilli);
            java.sql.Date CouponEndDate = new java.sql.Date(EndDatemilli);

            Company company = new Company("fina", "finaltest@gmail.co", "123");


            Customer customer = new Customer("final", "test", "finaltest@gmail.com", "12345678");
            Coupons coupons = new Coupons(1, 4, "Vacatio", "20% off", CouponStartDate, CouponEndDate, 2, 55, "");
            ClientFacade userCompanyTest = LoginManager.getInstance().Login("test1@gmail.com", "12345678", ClientType.Company);
            ClientFacade userCustomerTest = LoginManager.getInstance().Login("tester1@gmail.com", "12345678", ClientType.Customer);
            ClientFacade userAdminTest = LoginManager.getInstance().Login("admin@admin.com", "admin", ClientType.Administrator);


            ((AdminFacade) userAdminTest).addCompany(company);
            company.setPassword("87654321");
            ((AdminFacade) userAdminTest).updateCompany(company);
            ((AdminFacade) userAdminTest).deleteCompany(3);
            ((AdminFacade) userAdminTest).getAllCompanies();
            ((AdminFacade) userAdminTest).getOneCompany(4);
            ((AdminFacade) userAdminTest).addCustomer(customer);
            customer.setPassword("87654321");
            ((AdminFacade) userAdminTest).updateCustomer(customer);
            ((AdminFacade) userAdminTest).deleteCustomer(3);
            ((AdminFacade) userAdminTest).getAllCustomers();
            ((AdminFacade) userAdminTest).getOneCustomer(4);

            ((CompanyFacade) userCompanyTest).addCoupon(coupons);
            coupons.setID(5);
            coupons.setDescription("30% off");
            ((CompanyFacade) userCompanyTest).updateCoupon(coupons);
            ((CompanyFacade) userCompanyTest).deleteCoupon(3);
            ((CompanyFacade) userCompanyTest).getCompanyCoupons();
            ((CompanyFacade) userCompanyTest).getCompanyCoupons(Category.Electricity);
            ((CompanyFacade) userCompanyTest).getCompanyCoupons(34);
            ((CompanyFacade) userCompanyTest).getCompanyDetails();

            coupons.setID(4);
            ((CustomerFacade) userCustomerTest).PurchaseCoupon(coupons);
            ((CustomerFacade) userCustomerTest).getCustomerCoupons();
            ((CustomerFacade) userCustomerTest).getCustomerCoupons(Category.Electricity);
            ((CustomerFacade) userCustomerTest).getCustomerCoupons(36);
            ((CustomerFacade) userCustomerTest).getCustomerDetails();
            couponExpirationDaily.stop();
        } catch (ParseException e) {
            System.out.println("Error: Unable to parse the date");

        } catch (
                ClientException.InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());

        } catch (
                ClientException.CouponNotFoundException e) {
            System.out.println("Coupon not found: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");

        }
    }
}



