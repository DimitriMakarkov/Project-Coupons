package Facade;

import Java_Beans.Coupons;

import java.util.ArrayList;

public class CustomerFacade extends ClientFacade{
    private int CustomerID;

    public CustomerFacade(){

    }

    @Override
    public boolean Login(String Email, String Password) {
        if (customersDAO.isCustomerExists(Email,Password)){
            return true;
        }
        return false;
    }

    public void PurchaseCoupon(Coupons coupons){

    }


    public ArrayList<Coupons> getCustomerCoupons(){

    }

    public
}
