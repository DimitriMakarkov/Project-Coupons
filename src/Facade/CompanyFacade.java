package Facade;
import Java_Beans.Category;
import Java_Beans.Coupons;
import Java_Beans.Company;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class CompanyFacade extends ClientFacade{

    private int CompanyID;
    public CompanyFacade() {

    }


    @Override
    public boolean Login(String Email, String Password) {
        if (companiesDBDAO.isCompanyExists(Email,Password)){
            CompanyID=companiesDBDAO.getCompanyID(Email,Password);
            return true;
        }
        return false;
    }
//
//    public void addCoupon(Coupons coupons){
//        if  (couponsDAO.isCompanyCouponExist(coupons,CompanyID)) {
//            couponsDAO.addCoupon(coupons);
//        }
//    }
//
//    public void updateCoupon(Coupons coupons){
//        couponsDAO.updateCoupon(coupons);
//    }
//
//    public void deleteCoupon(int CouponID){
//        couponsDAO.deleteCouponHistory(CouponID);
//    }
//
//    public ArrayList<Coupons> getCompanyCoupons(){
//        return couponsDAO.getAllCompanyCoupons(CompanyID);
//    }
//
//    public ArrayList<Coupons> getCompanyCoupons(Category category){
//        ArrayList<Coupons> coupons=couponsDAO.getAllCoupons();
//        ArrayList<Coupons> CategoryCoupons = new ArrayList<>();
//        CategoryCoupons = coupons.stream().filter(FilterCoupons -> category.equals(FilterCoupons.getCategoryID()))
//                .collect(Collectors.toCollection(ArrayList::new));
//        return CategoryCoupons;
//        }
//    public ArrayList<Coupons> getCompanyCoupons(double maxPrice){
//        ArrayList<Coupons> coupons=couponsDAO.getAllCoupons();
//        ArrayList<Coupons> PriceCoupons = new ArrayList<>();
//        PriceCoupons = coupons.stream().filter(FilterCoupons -> FilterCoupons.getPrice()<=maxPrice)
//                .collect(Collectors.toCollection(ArrayList::new));
//        return PriceCoupons;
//    }
//
//    public Company getCompanyDetails(){
//       return companyDAO.getOneCompany(CompanyID);
//    }
    }

