package Facade;

import Java_Beans.Category;
import Java_Beans.Coupons;
import Java_Beans.Customer;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CustomerFacade extends ClientFacade {
    private int CustomerID;

    public CustomerFacade() {

    }

    @Override
    public boolean Login(String Email, String Password) {
        if (customersDAO.isCustomerExists(Email, Password)) {
            CustomerID = customersDAO.getCustomerViaEmailAndPass(Email, Password);
            return true;
        }
        return false;
    }

    public void PurchaseCoupon(Coupons coupons) {
        couponsDAO.customerPurchaseCoupon(coupons.getID(), CustomerID);
    }


    public ArrayList<Coupons> getCustomerCoupons() {
        return couponsDAO.getAllCutomerCoupons(CustomerID);
    }

    public ArrayList<Coupons> getCustomerCoupons(Category category) {
        ArrayList<Coupons> coupons = couponsDAO.getCategoryCustomerCoupons(CustomerID, category);
        coupons.forEach(System.out::println);
        return coupons;
    }

    public ArrayList<Coupons> getCustomerCoupons(double maxPrice) {
        ArrayList<Coupons> coupons = couponsDAO.getMaxPriceCustomerCoupons(CustomerID, maxPrice);
        coupons.forEach(System.out::println);
        return coupons;
    }

    public Customer getCustomerDetails() {
        return customersDAO.getOneCustomer(CustomerID);
    }
}
