package Java_Beans;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class Company {
    private int ID;
    private String Name;
    private String Email;
    private String Password;
    private ArrayList<Coupons> Coupons;

    public Company(int ID, String name, String email, String password) {
        this.ID = ID;
        this.Name = name;
        this.Email = email;
        this.Password = password;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public ArrayList<Coupons> getCoupons() {
        return this.Coupons;
    }

    public void setCoupons(ArrayList<Coupons> coupons) {
        this.Coupons = coupons;
    }

    public String toString() {
        return "Company{ID=" + this.ID + ", Name='" + this.Name + "', Email='" + this.Email + "', Password='" + this.Password + "', Coupons=" + this.Coupons + "}";
    }
}
