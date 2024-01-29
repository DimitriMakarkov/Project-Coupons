import DBDAO.CompaniesDBDAO;
import Java_Beans.Company;

public class Tester {

    public static void main(String[] args) {
        CompaniesDBDAO company = new CompaniesDBDAO();
        Company hevra = new Company(8,"test","Nothing@gmail.com","87654321");
        System.out.println(company.isCompanyExists(hevra.getEmail(), hevra.getPassword()));
    }
}
