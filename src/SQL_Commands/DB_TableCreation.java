package SQL_Commands;

public class DB_TableCreation {

    public static String createCompaniesTable =
            "CREATE TABLE IF NOT EXISTS `projectcoupons`.`companies` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `NAME` VARCHAR(45) NULL," +
                    "  `EMAIL` VARCHAR(45) NULL," +
                    "  `PASSWORD` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`));";

    public static String createCustomersTable =
            "CREATE TABLE IF NOT EXISTS `projectcoupons`.`customers` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `FIRST_NAME` VARCHAR(45) NULL," +
                    "  `LAST_NAME` VARCHAR(45) NULL," +
                    "  `EMAIL` VARCHAR(45) NULL," +
                    "  `PASSWORD` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`));";

    public static String createCouponsTable =
            "CREATE TABLE IF NOT EXISTS `projectcoupons`.`coupons` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `COMPANY_ID` INT NULL," +
                    "  `CATEGORY_ID` INT NULL," +
                    "  `TITLE` VARCHAR(45) NULL," +
                    "  `DESCRIPTION` VARCHAR(45) NULL," +
                    "  `START_DATE` DATE NULL," +
                    "  `END_DATE` DATE NULL," +
                    "  `AMOUNT` INT NULL," +
                    "  `PRICE` DOUBLE NULL," +
                    "  `IMAGE` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`));";

    public static String createCategoriesTable =
            "CREATE TABLE IF NOT EXISTS `projectcoupons`.`categories` (" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT," +
                    "  `NAME` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`ID`));";

    public static String createCustomers_vs_CouponsTable =
            "CREATE TABLE IF NOT EXISTS `projectcoupons`.`customers_vs_coupons` (" +
                    "  `CUSTOMER_ID` INT NOT NULL," +
                    "  `COUPON_ID` INT NOT NULL," +
                    "  PRIMARY KEY (`CUSTOMER_ID`, `COUPON_ID`));";

    public static String couponsForiegnKeys =
            "ALTER TABLE `projectcoupons`.`coupons` " +
                    "ADD INDEX `Company_ID_idx` (`COMPANY_ID` ASC) VISIBLE," +
                    "ADD INDEX `Category_ID_idx` (`CATEGORY_ID` ASC) VISIBLE;" +
                    ";" +
                    "ALTER TABLE `projectcoupons`.`coupons` " +
                    "ADD CONSTRAINT `Company_ID`" +
                    "  FOREIGN KEY (`COMPANY_ID`)" +
                    "  REFERENCES `projectcoupons`.`companies` (`ID`)" +
                    "  ON DELETE NO ACTION" +
                    "  ON UPDATE NO ACTION," +
                    "ADD CONSTRAINT `Category_ID`" +
                    "  FOREIGN KEY (`CATEGORY_ID`)" +
                    "  REFERENCES `projectcoupons`.`categories` (`ID`)" +
                    "  ON DELETE NO ACTION" +
                    "  ON UPDATE NO ACTION;";

public static String customer_vs_couponsForiegnKeys =
        "ALTER TABLE `projectcoupons`.`customers_vs_coupons` " +
                "ADD INDEX `Coupon_ID_idx` (`COUPON_ID` ASC) VISIBLE;" +
                ";" +
                "ALTER TABLE `projectcoupons`.`customers_vs_coupons` " +
                "ADD CONSTRAINT `Customer_ID`" +
                "  FOREIGN KEY (`CUSTOMER_ID`)" +
                "  REFERENCES `projectcoupons`.`customers` (`ID`)" +
                "  ON DELETE NO ACTION" +
                "  ON UPDATE NO ACTION," +
                "ADD CONSTRAINT `Coupon_ID`" +
                "  FOREIGN KEY (`COUPON_ID`)" +
                "  REFERENCES `projectcoupons`.`coupons` (`ID`)" +
                "  ON DELETE NO ACTION" +
                "  ON UPDATE NO ACTION;";
}
