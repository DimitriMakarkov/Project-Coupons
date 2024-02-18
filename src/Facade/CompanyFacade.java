package Facade;
import Java_Beans.Category;
import Java_Beans.Coupons;
import Java_Beans.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CompanyFacade extends ClientFacade{

    private int CompanyID;
    public CompanyFacade() {

    }

    @Override
    public boolean Login(String Email, String Password) {
        if (companyDAO.isCompanyExists(Email,Password)){
            CompanyID=companyDAO.getCompanyID(Email,Password);
            return true;
        }
        return false;
    }

    public void addCoupon(Coupons coupons){
        if  (couponsDAO.isCompanyCouponExist(coupons,CompanyID)) {
            couponsDAO.addCoupon(coupons);
        }
    }

    public void updateCoupon(Coupons coupons){
        couponsDAO.updateCoupon(coupons);
    }

    public void deleteCoupon(int CouponID){
        couponsDAO.deleteCouponHistory(CouponID);
    }

    public ArrayList<Coupons> getCompanyCoupons(){
        ArrayList<Coupons> coupons = couponsDAO.getAllCompanyCoupons(CompanyID);
        coupons.forEach(System.out::println);
        return coupons;
    }

    public ArrayList<Coupons> getCompanyCoupons(Category category){
        ArrayList<Coupons> coupons = couponsDAO.getCategoryCompanyCoupons(CompanyID,category);
        coupons.forEach(System.out::println);
        return coupons;
        }
    public ArrayList<Coupons> getCompanyCoupons(double maxPrice){
        ArrayList<Coupons> coupons = couponsDAO.getMaxPriceCompanyCoupons(CompanyID,maxPrice);
        coupons.forEach(System.out::println);
        return coupons;
    }

    public Company getCompanyDetails(){
       return companyDAO.getOneCompany(CompanyID);
    }
    }

