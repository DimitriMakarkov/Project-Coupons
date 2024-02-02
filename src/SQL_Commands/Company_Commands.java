package SQL_Commands;

public class Company_Commands {
    public static final String isCompanyExists =
            "SELECT count(*) AS RESULT FROM `projectcoupons`.`companies` WHERE EMAIL = ? AND PASSWORD = ?;";
    public static final String addCompany =
            "INSERT INTO `projectcoupons`.`companies` VALUES(?,?,?,?);";
    public static final String updateCompany =
            "UPDATE `projectcoupons`.`companies` SET NAME = ?, EMAIL = ? ,PASSWORD=? WHERE EMAIL = ? AND PASSWORD = ?;";
    public static final String deleteComapny =
            "DELETE FROM `projectcoupons`.`companies` WHERE ID=?;";
    public static final String getAllCompanies =
            "SELECT * FROM `projectcoupons`.`companies`;";
    public static final String getOneCompany =
            "SELECT * FROM `projectcoupons`.`companies` WHERE ID=?;";

    public static final String getCompanyViaEmailAndPass=
            "SELECT ID FROM `projectcoupons`.`companies` WHERE EMAIL = ? AND PASSWORD = ?";
}
