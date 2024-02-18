package DBDAO;

import DAO.CreateTablesDAO;
import DataBase.DB_Utilities;
import SQL_Commands.DB_TableCreation;

public class CreateTablesDBDAO implements CreateTablesDAO {


    public void createAllTables() {
        DB_Utilities.RunCommand(DB_TableCreation.createCompaniesTable);
        DB_Utilities.RunCommand(DB_TableCreation.createCategoriesTable);
        DB_Utilities.RunCommand(DB_TableCreation.createCustomersTable);
        DB_Utilities.RunCommand(DB_TableCreation.createCouponsTable);
        DB_Utilities.RunCommand(DB_TableCreation.createCustomers_vs_CouponsTable);
        DB_Utilities.RunCommand(DB_TableCreation.couponsForiegnKeys);
        DB_Utilities.RunCommand(DB_TableCreation.customer_vs_couponsForiegnKeys);
    }
}
