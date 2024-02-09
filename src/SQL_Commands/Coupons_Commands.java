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
                    "WHERE ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?);" +
                    "DELETE FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?;";

    public static final String deleteCustomerHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons`" +
                    "WHERE CUSTOMERS_ID IN (SELECT ID FROM `projectcoupons`.`customers` WHERE ID = ?);" +
                    "DELETE FROM `projectcoupons`.`customers` WHERE ID = ?";

    public static final String deleteCouponHistory =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons`" +
                    "WHERE COUPON_ID IN (SELECT ID FROM `projectcoupons`.`coupons` WHERE ID = ?);" +
                    "DELETE FROM `projectcoupons`.`coupons` WHERE ID = ?";
    public static final String getAllCoupons =
            "SELECT * FROM `projectcoupons`.`coupons`;";

    public static final String getAllCompanyCoupons =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE COMPANY_ID = ?;";
    public static final String getOneCoupon =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID=?;";

    public static final String addCuponPurchase =
            "INSERT INTO `projectcoupons`.`customers_vs_coupons` VALUES(?,?);";

    public static final String deleteCuponPurchase =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMERS_ID=? AND COUPON_ID=?";
}
