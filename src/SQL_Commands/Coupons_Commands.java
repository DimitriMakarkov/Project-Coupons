package SQL_Commands;

public class Coupons_Commands {
    public static final String addCoupon =
            "INSERT INTO `projectcoupons`.`coupons` VALUES(?,?,?,?,?,?,?,?,?,?);";
    public static final String updateCoupon =
            "UPDATE `projectcoupons`.`coupons` SET COMPANY_ID = ?,CATEGORY_ID = ?, TITLE = ? ," +
                    "DESCRIPTION=?,START_DATE = ?,END_DATE = ?,AMOUNT = ?,PRICE = ?,IMAGE = ? WHERE ID = ? ;";
    public static final String deleteCoupon =
            "DELETE FROM `projectcoupons`.`coupons` WHERE ID=?;";
    public static final String getAllCoupons =
            "SELECT * FROM `projectcoupons`.`coupons`;";
    public static final String getOneCoupon =
            "SELECT * FROM `projectcoupons`.`coupons` WHERE ID=?;";

    public static final String addCuponPurchase =
            "INSERT INTO `projectcoupons`.`customers_vs_coupons` VALUES(?,?);";

    public static final String deleteCuponPurchase =
            "DELETE FROM `projectcoupons`.`customers_vs_coupons` WHERE CUSTOMERS_ID=? AND COUPON_ID=?";
}
