
import Facade.AdminFacade;
import Facade.ClientFacade;
import Java_Beans.Company;
import Java_Beans.Customer;
import Login.ClientType;
import Login.LoginManager;

public class Tester {

    public static void main(String[] args) {
    testAll();

    }





    public static void testAll(){
//        CouponExpirationDaily Thread = new CouponExpirationDaily();
//        Thread.run();
        Company company = new Company("test Company","test@gmail.com","12345678");
        Customer customer = new Customer("Dima","Makarkov","dima@gmail.com","211");
        ClientFacade userTest = LoginManager.getInstance().Login("admin@admin.com", "admin", ClientType.Administrator);
        if (userTest instanceof AdminFacade){

//            ((AdminFacade) userTest).addCompany(company);
//            ((AdminFacade) userTest).updateCompany(company);
            ((AdminFacade) userTest).deleteCompany(11);
//            ((AdminFacade) userTest).getAllCompanies();
//            ((AdminFacade) userTest).getOneCompany(company.getID());
//
//            ((AdminFacade) userTest).addCustomer(customer);
//            ((AdminFacade) userTest).updateCustomer(customer);
//            ((AdminFacade) userTest).deleteCustomer(customer.getID());
//            ((AdminFacade) userTest).getAllCustomers();
//            ((AdminFacade) userTest).getOneCustomer(customer.getID());
        }
    }
}
