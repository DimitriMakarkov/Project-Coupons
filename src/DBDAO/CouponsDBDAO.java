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

    public boolean isCompanyCouponExist(Coupons coupons,int CompanyID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, CompanyID);
        params.put(2, coupons.getTitle());
        ResultSet result = DB_Utilities.RunCommandWithResult(Coupons_Commands.isCompanyCouponExist,params);
        try {
            while (result.next()) {
                return result.getInt("RESULT") == 1;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String addCoupon(Coupons coupon) {
        Map<Integer, Object> params = new HashMap();
        params.put(1, coupon.getCompanyID());
        params.put(2, coupon.getCategoryID());
        params.put(3, coupon.getTitle());
        params.put(4, coupon.getDescription());
        params.put(5, coupon.getStartDate());
        params.put(6, coupon.getEndDate());
        params.put(7, coupon.getAmount());
        params.put(8, coupon.getPrice());
        params.put(9, coupon.getImage());
        DB_Utilities.RunCommand(Coupons_Commands.addCoupon, params);
        System.out.println("The Coupon Has Successfully Been Added!");
        return null;
    }

    public String updateCoupon(Coupons coupon) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> params = new HashMap();
        System.out.println("Please Enter A New CategoryID: ");
        System.out.print("> ");
        String CategoryID = scanner.next();
        System.out.println("Please Enter A New Title: ");
        System.out.print("> ");
        String Title = scanner.next();
        System.out.println("Please Enter A New Description: ");
        System.out.print("> ");
        String Description = scanner.next();
        System.out.println("Please Enter A New Start Date: ");
        System.out.print("> ");
        String StartDate = scanner.next();
        System.out.println("Please Enter A New End Date: ");
        System.out.print("> ");
        String EndDate = scanner.next();
        System.out.println("Please Enter A New Amount: ");
        System.out.print("> ");
        String Amount = scanner.next();
        System.out.println("Please Enter A New Price: ");
        System.out.print("> ");
        String Price = scanner.next();
        System.out.println("Please Enter A New Image: ");
        System.out.print("> ");
        String Image = scanner.next();
        params.put(1, CategoryID);
        params.put(2, Title);
        params.put(3, Description);
        params.put(4, StartDate);
        params.put(5, EndDate);
        params.put(6, Amount);
        params.put(7, Price);
        params.put(8, Image);
//        params.put(9, coupon.getID());
        DB_Utilities.RunCommand(Coupons_Commands.updateCoupon, params);
        System.out.println("The Coupon Has Been Updated!");
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

    public ArrayList<Coupons> getAllCompanyCoupons(int CompanyID){
        ArrayList<Coupons> coupons = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandWithParameter(Coupons_Commands.getAllCompanyCoupons,CompanyID);
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

    public ArrayList<Coupons> getAllCutomerCoupons(int CustomerID) {
        ArrayList<Coupons> coupons = new ArrayList();
        ResultSet results = DB_Utilities.RunCommandWithParameter(Coupons_Commands.getAllCustomerCoupons,CustomerID);
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

    public ArrayList<Coupons> getAllCouponsByCategory(Category category) {
        ArrayList<Coupons> coupons = new ArrayList();
        if (category.equals("Food")){
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
//        Map<Integer, Object> params = new HashMap();
        DB_Utilities.RunCommandWithParameter(Coupons_Commands.deleteCoupon, CouponID);
        System.out.println("The Coupon Has Been Deleted");
        return null;
    }

        public void deleteCompanyHistory(int CompanyID){
            Map<Integer, Object> params = new HashMap();
            params.put(1,CompanyID);
//            params.put(2,CompanyID);
            if(DB_Utilities.RunCommand(Coupons_Commands.deleteCompanyHistory,params)){
                DB_Utilities.RunCommand(Coupons_Commands.deleteCompanyCoupons,params);
                System.out.println("The Company's Coupons And History Has Been Deleted");
            }
            else {
                System.out.println("The Company's Coupons And History Have Not Been Deleted");
            }
        }

        public void deleteCustomerHistory(int CustomerID){
            Map<Integer, Object> params = new HashMap();
            params.put(1,CustomerID);
            if(DB_Utilities.RunCommand(Coupons_Commands.deleteCustomerHistory,params)){
                DB_Utilities.RunCommand(Coupons_Commands.deleteCustomerCoupons,params);
                System.out.println("The Customer's Coupons And History Has Been Deleted");

            }
            else {
                System.out.println("The Customer's Coupons And History Has Not Been Deleted");
            }
        }

        public void deleteCouponHistory(int CouponID){
                Map<Integer, Object> params = new HashMap();
                params.put(1,CouponID);
                params.put(2,CouponID);
                DB_Utilities.RunCommandWithParameter(Coupons_Commands.deleteCouponHistory,params);
            System.out.println("The Coupon And Coupon History Has Been Deleted");
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
        params.put(1,CustomerID);
        params.put(2,CouponID);
        DB_Utilities.RunCommand(Coupons_Commands.addCouponPurchase,params);
        System.out.println("The Coupon Has Successfully Been Purchased!");
    }

    public void deleteCouponPurchase(int CustomerID, int CouponID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1,CustomerID);
        params.put(2,CouponID);
        DB_Utilities.RunCommand(Coupons_Commands.deleteCouponPurchase,params);
        System.out.println("The Coupon Purchase Has Successfully Been Deleted!");
    }

    public void customerPurchaseCoupon(int CouponID,int CustomerID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1,CustomerID);
        params.put(2,CouponID);
        params.put(3,CustomerID);
        params.put(4,CouponID);
        DB_Utilities.RunCommand(Coupons_Commands.customerPurchaseCoupon,params);
        System.out.println("The Coupon Has Successfully Been Purchased!");
    }
}
