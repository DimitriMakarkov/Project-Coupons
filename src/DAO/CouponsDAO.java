package DAO;

import Java_Beans.Coupons;

import java.util.ArrayList;

public interface CouponsDAO {
    ArrayList<Coupons> getAllCoupons();

    String addCoupon(Coupons coupon);

    String updateCoupon(Coupons coupon);

    String deleteCoupon(int CouponID);

    void deleteCompanyHistory(int CompanyID);

    void deleteCustomerHistory(int CustomerID);

    Coupons getOneCoupon(int CouponID);

    void addCouponPurchase(int CustomerID, int CouponID);

    void deleteCouponPurchase(int CustomerID, int CouponID);
}
