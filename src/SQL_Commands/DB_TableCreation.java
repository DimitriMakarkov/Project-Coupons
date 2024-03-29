package SQL_Commands;

import DataBase.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static String couponsForiegnKeysPart1 =
            "ALTER TABLE `projectcoupons`.`coupons` " +
                    "ADD INDEX `Company_ID_idx` (`COMPANY_ID` ASC) VISIBLE," +
                    "ADD INDEX `Category_ID_idx` (`CATEGORY_ID` ASC) VISIBLE;";


    public static String couponsForiegnKeysPart2 =
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

    public static String customer_vs_couponsForiegnKeysPart1 =
            "ALTER TABLE `projectcoupons`.`customers_vs_coupons` " +
                    "ADD INDEX `Coupon_ID_idx` (`COUPON_ID` ASC) VISIBLE;";


    public static String customer_vs_couponsForiegnKeysPart2 =
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

    public static void SQL_Batch() {
        Connection Hibur = null;
        try {
            Hibur = ConnectionPool.getInstance().getConnection();
            Statement SQL_Commands = Hibur.createStatement();
            SQL_Commands = Hibur.createStatement();
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`categories` (`ID`, `NAME`) VALUES ('1', 'Food');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`categories` (`ID`, `NAME`) VALUES ('2', 'Electricity');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`categories` (`ID`, `NAME`) VALUES ('3', 'Restaurant');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`categories` (`ID`, `NAME`) VALUES ('4', 'Vacation');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`companies` (`NAME`, `EMAIL`, `PASSWORD`) VALUES ('test company num1', 'test1@gmail.com', '12345678');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`companies` (`NAME`, `EMAIL`, `PASSWORD`) VALUES ('test company num2', 'test2@gmail.com', '87654321');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`companies` (`NAME`, `EMAIL`, `PASSWORD`) VALUES ('test company num2', 'test2@gmail.com', '87654321');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`companies` (`NAME`, `EMAIL`, `PASSWORD`) VALUES ('test company num3', 'test3@gmail.com', '12345678');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`companies` (`NAME`, `EMAIL`, `PASSWORD`) VALUES ('test company num4', 'test4@gmail.com', '09876543');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`coupons` (`COMPANY_ID`, `CATEGORY_ID`, `TITLE`, `DESCRIPTION`, `START_DATE`, `END_DATE`, `AMOUNT`, `PRICE`) VALUES ('1', '1', 'Food', '15% off', '2024-01-01', '2025-01-01', '5', '20');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`coupons` (`COMPANY_ID`, `CATEGORY_ID`, `TITLE`, `DESCRIPTION`, `START_DATE`, `END_DATE`, `AMOUNT`, `PRICE`) VALUES ('1', '2', 'Electricity', '20% off', '2024-01-01', '2025-01-01', '6', '25');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`coupons` (`COMPANY_ID`, `CATEGORY_ID`, `TITLE`, `DESCRIPTION`, `START_DATE`, `END_DATE`, `AMOUNT`, `PRICE`) VALUES ('2', '2', 'Electricity', '20% off', '2024-01-01', '2025-01-01', '8', '25')");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`coupons` (`COMPANY_ID`, `CATEGORY_ID`, `TITLE`, `DESCRIPTION`, `START_DATE`, `END_DATE`, `AMOUNT`, `PRICE`) VALUES ('3', '4', 'Vacation', '10% off', '2024-01-01', '2024-12-01', '3', '30');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`coupons` (`COMPANY_ID`, `CATEGORY_ID`, `TITLE`, `DESCRIPTION`, `START_DATE`, `END_DATE`, `AMOUNT`, `PRICE`) VALUES ('1', '3', 'Restaurant', '15%off', '2024-01-01', '2024-02-01', '1', '20');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers` (`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`) VALUES ('tester1', 'project', 'tester1@gmail.com', '12345678');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers` (`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`) VALUES ('tester2', 'project', 'tester2@gmail.com', '12345678');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers` (`FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PASSWORD`) VALUES ('tester3', 'project', 'tester3@gmail.com', '12345678');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers_vs_coupons` (`CUSTOMER_ID`, `COUPON_ID`) VALUES ('1', '1');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers_vs_coupons` (`CUSTOMER_ID`, `COUPON_ID`) VALUES ('1', '2');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers_vs_coupons` (`CUSTOMER_ID`, `COUPON_ID`) VALUES ('2', '4');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers_vs_coupons` (`CUSTOMER_ID`, `COUPON_ID`) VALUES ('2', '3');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers_vs_coupons` (`CUSTOMER_ID`, `COUPON_ID`) VALUES ('3', '3');");
            SQL_Commands.addBatch("INSERT INTO `projectcoupons`.`customers_vs_coupons` (`CUSTOMER_ID`, `COUPON_ID`) VALUES ('3', '1');");
            SQL_Commands.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
