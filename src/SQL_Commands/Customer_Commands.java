package SQL_Commands;

public class Customer_Commands {
    public static final String isCustomerExists =
            "SELECT EXISTS(SELECT * FROM `projectcoupons`.`customers` WHERE EMAIL = ? AND PASSWORD = ?);";
    public static final String addCustomer =
            "INSERT INTO `projectcoupons`.`customers` VALUES(?,?,?,?,?);";
    public static final String updateCustomer =
            "UPDATE `projectcoupons`.`customers` SET FIRST_NAME = ?,LAST_NAME = ?, EMAIL = ? ,PASSWORD=? WHERE EMAIL = ? AND PASSWORD = ?;";
    public static final String deleteCustomer =
            "DELETE FROM `projectcoupons`.`customers` WHERE ID=?;";
    public static final String getAllCustomers =
            "SELECT * FROM `projectcoupons`.`customers`;";
    public static final String getOneCustomer =
            "SELECT * FROM `projectcoupons`.`customers` WHERE ID=?;";
}
