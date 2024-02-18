package DAO;

import Java_Beans.Category;
import Java_Beans.Coupons;

import java.util.ArrayList;

public interface CouponsDAO {

    boolean isCompanyCouponExist(Coupons coupons, int CompanyID);

    String addCoupon(Coupons coupon);

    String updateCoupon(Coupons coupon);

    String deleteCoupon(int CouponID);

    void deleteCompanyHistory(int CompanyID);

    void deleteCustomerHistory(int CustomerID);

    void deleteCouponHistory(int CouponID);

    void deleteExpiredCoupons();

    ArrayList<Coupons> getAllCoupons();

    ArrayList<Coupons> getAllCompanyCoupons(int CompanyID);

    ArrayList<Coupons> getCategoryCompanyCoupons(int CompanyID, Category category);

    ArrayList<Coupons> getMaxPriceCompanyCoupons(int CompanyID, double MaxPrice);

    ArrayList<Coupons> getAllCutomerCoupons(int CustomerID);

    ArrayList<Coupons> getCategoryCustomerCoupons(int CustomerID, Category category);

    ArrayList<Coupons> getMaxPriceCustomerCoupons(int CustomerID, double MaxPrice);

    Coupons getOneCoupon(int CouponID);

    void addCouponPurchase(int CustomerID, int CouponID);

    void deleteCouponPurchase(int CustomerID, int CouponID);

    void customerPurchaseCoupon(int CouponID, int CustomerID);
}
