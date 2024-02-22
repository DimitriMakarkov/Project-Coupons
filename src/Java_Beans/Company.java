package Java_Beans;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Company {
    private int ID;
    private String Name;
    private String Email;
    private String Password;
    private ArrayList<Coupons> Coupons;

    public Company(String name, String email, String password) {
        this.Name = name;
        this.Email = email;
        this.Password = password;
    }

    public Company(int id, String name, String email, String password, ArrayList<Coupons> coupons) {
        this.ID = id;
        this.Name = name;
        this.Email = email;
        this.Password = password;
        this.Coupons = coupons;
    }
}
