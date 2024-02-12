package Java_Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Customer {
    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;
//    private ArrayList<Coupons> Coupons;


    public Customer(String firstName, String lastName, String email, String password) {//removed id

        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Password = password;
    }
}
//
//    public int getID() {
//        return this.ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }
//
//    public String getFirstName() {
//        return this.FirstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.FirstName = firstName;
//    }
//
//    public String getLastName() {
//        return this.LastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.LastName = lastName;
//    }
//
//    public String getEmail() {
//        return this.Email;
//    }
//
//    public void setEmail(String email) {
//        this.Email = email;
//    }
//
//    public String getPassword() {
//        return this.Password;
//    }
//
//    public void setPassword(String password) {
//        this.Password = password;
//    }
//
//    public ArrayList<Coupons> getCoupons() {
//        return this.Coupons;
//    }
//
//    public void setCoupons(ArrayList<Coupons> coupons) {
//        this.Coupons = coupons;
//    }
//
//    public String toString() {
//        return "Customer{ID=" + this.ID + ", FirstName='" + this.FirstName + "', LastName='" + this.LastName + "', Email='" + this.Email + "', Password='" + this.Password + "', Coupons=" + this.Coupons + "}";
//    }
//}
