package Java_Beans;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Company {
    private int ID;
    private String Name;
    private String Email;
    private String Password;
    private ArrayList<Coupons> Coupons;

    public Company(String name, String email, String password) {//removed int id
        this.Name = name;
        this.Email = email;
        this.Password = password;
    }
    public Company (int id,String name, String email, String password,ArrayList<Coupons> coupons){
        this.ID = id;
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Coupons = coupons;
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
//    public String getName() {
//        return this.Name;
//    }
//
//    public void setName(String name) {
//        this.Name = name;
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
//        return "Company{ID=" + this.ID + ", Name='" + this.Name + "', Email='" + this.Email + "', Password='" + this.Password + "', Coupons=" + this.Coupons + "}";
//    }
}
