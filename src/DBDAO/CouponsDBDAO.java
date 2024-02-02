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
        params.put(10, coupon.getImage());
        DB_Utilities.RunCommand(Coupons_Commands.addCoupon, params);
        System.out.println("The Coupon Has Successfully Been Added!");
        return null;
    }

    public String updateCoupon(Coupons coupon) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Object> params = new HashMap();
        System.out.println("Please Enter A New CompanyID: ");    //todo-move to somewhere else
        System.out.print("> ");
        String CompanyID = scanner.next();
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
        params.put(1, CompanyID);
        params.put(2, CategoryID);
        params.put(3, Title);
        params.put(4, Description);
        params.put(5, StartDate);
        params.put(6, EndDate);
        params.put(7, Amount);
        params.put(8, Price);
        params.put(9, Image);
        params.put(10, coupon.getID());
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

    public ArrayList<Coupons> getAllCoupons(Category category) {
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
        Map<Integer, Object> params = new HashMap();
        DB_Utilities.RunCommand(Coupons_Commands.deleteCoupon, params);
        System.out.println("The Coupon Has Been Deleted");
        return null;
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
        DB_Utilities.RunCommand(Coupons_Commands.addCuponPurchase,params);
        System.out.println("The Coupon Has Successfully Been Purchased!");
    }

    public void deleteCouponPurchase(int CustomerID, int CouponID) {
        Map<Integer, Object> params = new HashMap();
        params.put(1,CustomerID);
        params.put(2,CouponID);
        DB_Utilities.RunCommand(Coupons_Commands.deleteCuponPurchase,params);
        System.out.println("The Coupon Purchase Has Successfully Been Deleted!");
    }
}
