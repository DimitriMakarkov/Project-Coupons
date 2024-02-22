package Java_Beans;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Coupons {
    private int ID;
    private int CompanyID;
    private int CategoryID;
    private String Title;
    private String Description;
    private Date StartDate;
    private Date EndDate;
    private int Amount;
    private double Price;
    private String Image;

    public Coupons(int companyID, int categoryID, String title, String description, Date startDate, Date endDate, int amount, double price,String image) {
        this.CompanyID = companyID;
        this.CategoryID = categoryID;
        this.Title = title;
        this.Description = description;
        this.StartDate = startDate;
        this.EndDate = endDate;
        this.Amount = amount;
        this.Price = price;
        this.Image = image;
    }

    public Coupons(int ID, int companyID, int categoryID, String title, String description, Date startDate, Date endDate, int amount, double price, String image) {
        this.ID = ID;
        CompanyID = companyID;
        CategoryID = categoryID;
        Title = title;
        Description = description;
        StartDate = startDate;
        EndDate = endDate;
        Amount = amount;
        Price = price;
        Image = image;
    }
}
