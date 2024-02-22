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

    public Customer(String firstName, String lastName, String email, String password) {

        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Password = password;
    }
}

