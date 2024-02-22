package DBDAO;

import DAO.CouponsDAO;
import DataBase.DB_Utilities;
import Java_Beans.Category;
import Java_Beans.Coupons;
import SQL_Commands.Coupons_Commands;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CouponsDBDAO implements CouponsDAO {

    public boolean isCompanyCouponExist(Coupons coupons, int CompanyID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        params.put(2, coupons.getTitle());
        ResultSet result = DB_Utilities.RunCommandWithResult(Coupons_Commands.isCompanyCouponExist, params);
        try {
            while (result.next()) {
                return result.getInt("RESULT") != 0;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String addCoupon(Coupons coupon) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, coupon.getID());
        params.put(2, coupon.getCompanyID());
        params.put(3, coupon.getCategoryID());
        params.put(4, coupon.getTitle());
        params.put(5, coupon.getDescription());
        params.put(6, coupon.getStartDate());
        params.put(7, coupon.getEndDate());
        params.put(8, coupon.getAmount());
        params.put(9, coupon.getPrice());
        params.put(10,"");
        DB_Utilities.RunCommand(Coupons_Commands.addCoupon, params);
        return null;
    }

    public String updateCoupon(Coupons coupon) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, coupon.getCategoryID());
        params.put(2, coupon.getTitle());
        params.put(3, coupon.getDescription());
        params.put(4, coupon.getStartDate());
        params.put(5, coupon.getEndDate());
        params.put(6, coupon.getAmount());
        params.put(7, coupon.getPrice());
        params.put(8,coupon.getImage());
        params.put(9,coupon.getID());
        DB_Utilities.RunCommand(Coupons_Commands.updateCoupon, params);
        return null;
    }

    public ArrayList<Coupons> getAllCoupons() {
        ArrayList<Coupons> coupons = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandFromResult(Coupons_Commands.getAllCoupons);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            coupons.forEach(System.out::println);
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getAllCompanyCoupons(int CompanyID) {
        ArrayList<Coupons> coupons = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandWithParameter(Coupons_Commands.getAllCompanyCoupons, CompanyID);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getCategoryCompanyCoupons(int CompanyID, Category category) {
        ArrayList<Coupons> coupons = new ArrayList();
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        params.put(2, category.name());
        ResultSet results = DB_Utilities.RunCommandWithResult(Coupons_Commands.getCategoryComapnyCoupons, params);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getMaxPriceCompanyCoupons(int CompanyID, double MaxPrice) {
        ArrayList<Coupons> coupons = new ArrayList();
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        params.put(2, MaxPrice);
        ResultSet results = DB_Utilities.RunCommandWithResult(Coupons_Commands.getMaxPriceCompanyCoupons, params);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getAllCutomerCoupons(int CustomerID) {
        ArrayList<Coupons> coupons = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandWithParameter(Coupons_Commands.getAllCustomerCoupons, CustomerID);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = 1;
                double Price = results.getDouble(8);
                String Image = results.getString(9);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            coupons.forEach(System.out::println);
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getCategoryCustomerCoupons(int CustomerID, Category category) {
        ArrayList<Coupons> coupons = new ArrayList();
        Map<Integer, Object> params = new HashMap();
        params.put(1, CustomerID);
        params.put(2, category.name());
        ResultSet results = DB_Utilities.RunCommandWithResult(Coupons_Commands.getCategoryCustomerCoupons, params);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getMaxPriceCustomerCoupons(int CustomerID, double MaxPrice) {
        ArrayList<Coupons> coupons = new ArrayList();
        Map<Integer, Object> params = new HashMap();
        params.put(1, CustomerID);
        params.put(2, MaxPrice);
        ResultSet results = DB_Utilities.RunCommandWithResult(Coupons_Commands.getMaxPriceCustomerCoupons, params);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coupons> getAllCouponsByCategory(Category category) {
        ArrayList<Coupons> coupons = new ArrayList();
        if (category.equals("Food")) {
        }
        ResultSet results = DB_Utilities.RunCommandFromResult(Coupons_Commands.getAllCoupons);
        try {
            while (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupons.add(new Coupons(ID, ComapnyID, CategoryID, Title,
                        Description, StartDate, EndDate, Amount, Price, Image));
            }
            coupons.forEach(System.out::println);
            return coupons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteCoupon(int CouponID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CouponID);
        if (DB_Utilities.RunCommand(Coupons_Commands.deleteCoupon, params)) {
            System.out.println("The Coupon Has Been Deleted");
        }
        System.out.println("The Coupon Has Not Been Deleted");
        return null;
    }

    public void deleteCompanyHistory(int CompanyID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        if (DB_Utilities.RunCommand(Coupons_Commands.deleteCompanyHistory, params)) {
            DB_Utilities.RunCommand(Coupons_Commands.deleteCompanyCoupons, params);
            System.out.println("The Company's Coupons And History Has Been Deleted");
        } else {
            System.out.println("The Company's Coupons And History Have Not Been Deleted");
        }
    }

    public void deleteCustomerHistory(int CustomerID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CustomerID);
        if (DB_Utilities.RunCommand(Coupons_Commands.deleteCustomerHistory, params)) {
            DB_Utilities.RunCommand(Coupons_Commands.deleteCustomerCoupons, params);
            System.out.println("The Customer's Coupons And History Has Been Deleted");

        } else {
            System.out.println("The Customer's Coupons And History Has Not Been Deleted");
        }
    }

    public void deleteCouponHistory(int CouponID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CouponID);
        if (DB_Utilities.RunCommand(Coupons_Commands.deleteCouponHistory, params)) {
            DB_Utilities.RunCommand(Coupons_Commands.deleteCoupon, params);
            System.out.println("The Coupon And Coupon History Has Been Deleted");
        } else {
            System.out.println("The Coupon And Coupon History Has Not Been Deleted");
        }
    }

    public void deleteExpiredCoupons() {
        DB_Utilities.RunCommand(Coupons_Commands.deleteExpiredCoupons);
        System.out.println("Expired Coupons Have Been Deleted");
    }

    public Coupons getOneCoupon(int CouponID) {
        Coupons coupon = null;
        try {
            ResultSet results = DB_Utilities.RunCommandWithParameter(Coupons_Commands.getOneCoupon, CouponID);
            if (results.next()) {
                int ID = results.getInt(1);
                int ComapnyID = results.getInt(2);
                int CategoryID = results.getInt(3);
                String Title = results.getString(4);
                String Description = results.getString(5);
                Date StartDate = results.getDate(6);
                Date EndDate = results.getDate(7);
                int Amount = results.getInt(8);
                double Price = results.getDouble(9);
                String Image = results.getString(10);
                coupon = new Coupons(ID, ComapnyID, CategoryID, Title, Description, StartDate, EndDate, Amount, Price, Image);
            }

            return coupon;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCouponPurchase(int CustomerID, int CouponID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CustomerID);
        params.put(2, CouponID);
        DB_Utilities.RunCommand(Coupons_Commands.addCouponPurchase, params);
        System.out.println("The Coupon Has Successfully Been Purchased!");
    }

    public void deleteCouponPurchase(int CustomerID, int CouponID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CustomerID);
        params.put(2, CouponID);
        DB_Utilities.RunCommand(Coupons_Commands.deleteCouponPurchase, params);
        System.out.println("The Coupon Purchase Has Successfully Been Deleted!");
    }

    public boolean customerPurchaseCoupon(int CouponID, int CustomerID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CustomerID);
        params.put(2, CouponID);
        ResultSet results = DB_Utilities.RunCommandWithResult(Coupons_Commands.isCustomerCouponDuplicate,params);
        try{
            if (results.next()) {
                int ID = results.getInt(1);
                if (ID != 0) {
                    System.out.println("The Coupon Is Already Purchased");
                    return false;
                }
            }
            results = DB_Utilities.RunCommandWithParameter(Coupons_Commands.isCouponExpiredOrEmpty, CouponID);
            if (results.next()) {
                int ID = results.getInt(1);
                if (ID != 0) {
                    System.out.println("The Coupon Is Expired Or Is Empty");
                    return false;
                }
            }
                DB_Utilities.RunCommand(Coupons_Commands.customerPurchaseCoupon, params);
                DB_Utilities.RunCommand(Coupons_Commands.addCustomerPurchase, params);
                System.out.println("The Coupon Has Successfully Been Purchased!");
                return true;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
