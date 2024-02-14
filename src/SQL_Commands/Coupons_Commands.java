package SQL_Commands;

public class Coupons_Commands {

    public static final String isCompanyCouponExist =
            "SELECT count(*) FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ? AND TITLE = ?;";
    public static final String addCoupon =
            "INSERT INTO `projectcoupons`.`coupons` VALUES(?,?,?,?,?,?,?,?,?,?);";
    public static final String updateCoupon =
            "UPDATE `projectcoupons`.`coupons` SET COMPANY_ID = ?,CATEGORY_ID = ?, TITLE = ? ," +
                    "DESCRIPTION=?,START_DATE = ?,END_DATE = ?,AMOUNT = ?,PRICE = ?,IMAGE = ? WHERE ID = ? ;";
    public static final String deleteCoupon =
            "DELETE FROM `projectcoupons`.`coupons` WHERE ID=?;";

    public static final String deleteCompanyHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` " +
                    "WHERE ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?); " +
                    "DELETE FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?;";

    public static final String deleteCustomerHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons`" +
                    "WHERE CUSTOMERS_ID IN (SELECT ID FROM `projectcoupons`.`customers` WHERE ID = ?);" +
                    "DELETE FROM `projectcoupons`.`customers` WHERE ID = ?";

    public static final String deleteCouponHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons`" +
                    "WHERE COUPON_ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE ID = ?);" +
                    "DELETE FROM `projectcoupons`.`coupons` WHERE ID = ?";

    public static final String deleteExpiredCoupons =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` " +
                    "WHERE COUPON_ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE END_DATE < NOW()); " +
                    "DELETE FROM `projectcoupons`.`coupons` WHERE END_DATE< now();";
    public static final String getAllCoupons =
            "SELECT * FROM `projectcoupons`.`coupons`;";

    public static final String getAllCompanyCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?;";

    public static final String getAllCustomerCoupons =
            "SELECT ID,COMPANY_ID,CATEGORY_ID,TITLE,DESCRIPTION,START_DATE,END_DATE,PRICE,IMAGE FROM `projectcoupons`.`customers_vs_coupons` as CVSC " +
                    "JOIN `projectcoupons`.`coupons` as CS " +
                    "ON CVSC.COUPON_ID=CS.ID " +
                    "WHERE CVSC.CUSTOMERS_ID =?;";
    public static final String getOneCoupon =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID=?;";

    public static final String addCouponPurchase =
            "INSERT INTO `projectcoupons`.`customers_vs_coupons` VALUES(?,?);";

    public static final String deleteCouponPurchase =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMERS_ID=? AND COUPON_ID=?";

    public static final String customerPurchaseCoupon =
            "UPDATE `projectcoupons`.`coupons` " +
                    "SET AMOUNT = AMOUNT - 1 " +
                    "WHERE " +
                    "AMOUNT > 0 " +
                    "AND END_DATE >= CURDATE() " +
                    "AND ID NOT IN (SELECT COUPON_ID " +
                    "FROM `projectcoupons`.`customers_vs_coupons` " +
                    "WHERE CUSTOMER_ID = ?) " +
                    "AND ID = ?;" +
                    "INSERT INTO `projectcoupons`.`customers_vs_coupons` SET CUSTOMER_ID = ?,COUPON_ID =?;";
}
