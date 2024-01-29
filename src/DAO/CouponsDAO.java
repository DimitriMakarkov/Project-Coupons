package DAO;

import Java_Beans.Coupons;

import java.util.ArrayList;

public interface CouponsDAO {
    ArrayList<Coupons> getAllCoupons();

    String addCoupon(Coupons coupon);

    String updateCoupon(Coupons coupon);

    String deleteCoupon(int CouponID);

    Coupons getOneCoupon(int CouponID);

    String addCouponPurchase(int var1, int var2);

    String deleteCouponPurchase(int var1, int var2);
}