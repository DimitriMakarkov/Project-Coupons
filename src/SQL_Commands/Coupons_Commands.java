package SQL_Commands;

public class Coupons_Commands {

    public static final String isCompanyCouponExist =
            "SELECT count(*) AS RESULT FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ? AND TITLE = ?;";
    public static final String addCoupon =
            "INSERT INTO `projectcoupons`.`coupons` VALUES(?,?,?,?,?,?,?,?,?,?);";
    public static final String updateCoupon =
            "UPDATE `projectcoupons`.`coupons` SET CATEGORY_ID = ?, TITLE = ? ," +
                    "DESCRIPTION=?,START_DATE = ?,END_DATE = ?,AMOUNT = ?,PRICE = ?,IMAGE = ? WHERE ID = ? ;";
    public static final String deleteCoupon =
            "DELETE FROM `projectcoupons`.`coupons` WHERE ID=?;";

    public static final String deleteCompanyCoupons =
            "DELETE FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?;";

    public static final String deleteCompanyHistory =
    "DELETE FROM `projectcoupons`.`customers_vs_coupons` WHERE COUPON_ID IN " +
            "(SELECT ID FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?);";

    public static final String deleteCustomerCoupons =
            "DELETE FROM `projectcoupons`.`customers` WHERE ID = ?";

    public static final String deleteCustomerHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons`" +
                    "WHERE CUSTOMER_ID IN (SELECT ID FROM `projectcoupons`.`customers` WHERE ID = ?);";

    public static final String deleteCouponHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons`" +
                    "WHERE COUPON_ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE ID = ?);";
    public static final String deleteExpiredCoupons =
                    "DELETE FROM `projectcoupons`.`coupons` WHERE END_DATE< now();";

    public static final String deleteExpiredCouponsFromCustomers =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` " +
                    "WHERE COUPON_ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE END_DATE < NOW());";
    public static final String getAllCoupons =
            "SELECT * FROM `projectcoupons`.`coupons`;";

    public static final String getAllCompanyCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?;";

    public static final String getCategoryComapnyCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ? AND TITLE =?;";

    public static final String getMaxPriceCompanyCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ? AND PRICE<?;";

    public static final String getAllCustomerCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID IN" +
                    "(SELECT COUPON_ID FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMER_ID=?);";

    public static final String getCategoryCustomerCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID IN" +
                    "(SELECT COUPON_ID FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMER_ID=?) AND TITLE=?;";

    public static final String getMaxPriceCustomerCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID IN" +
                    "(SELECT COUPON_ID FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMER_ID=?) AND PRICE<?;";
    public static final String getOneCoupon =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID=?;";

    public static final String addCouponPurchase =
            "INSERT INTO `projectcoupons`.`customers_vs_coupons` VALUES(?,?);";

    public static final String deleteCouponPurchase =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMERS_ID=? AND COUPON_ID=?";

    public static final String isCustomerCouponDuplicate =
            "SELECT count(*) AS RESULT FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMER_ID =? AND COUPON_ID=?";

    public static final String isCouponExpiredOrEmpty =
            "SELECT count(*)" +
                    "FROM `projectcoupons`.`coupons`" +
                    "WHERE (END_DATE < CURRENT_DATE OR AMOUNT = 0)" +
                    "AND ID = ?;";

    public static final String customerPurchaseCoupon =
            "UPDATE `projectcoupons`.`coupons` " +
                    "SET AMOUNT = AMOUNT - 1 " +
                    "WHERE AMOUNT > 0 " +
                    "AND END_DATE >= CURDATE() " +
                    "AND ID NOT IN (SELECT COUPON_ID " +
                    "FROM `projectcoupons`.`customers_vs_coupons` " +
                    "WHERE CUSTOMER_ID = ?) " +
                    "AND ID = ?;";

    public static final String addCustomerPurchase =
            "INSERT INTO `projectcoupons`.`customers_vs_coupons` SET CUSTOMER_ID = ?,COUPON_ID =?;";
}
