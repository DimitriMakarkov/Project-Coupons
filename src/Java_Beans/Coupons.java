package Java_Beans;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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

    public Coupons( int companyID, int categoryID, String title, String description, Date startDate, Date endDate, int amount, double price, String image) {
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
//
//    public int getID() {
//        return this.ID;
//    }
//
//    public void setID(int ID) {
//        this.ID = ID;
//    }
//
//    public int getCompanyID() {
//        return this.CompanyID;
//    }
//
//    public void setCompanyID(int companyID) {
//        this.CompanyID = companyID;
//    }
//
//    public int getCategoryID() {
//        return this.CategoryID;
//    }
//
//    public void setCategoryID(int categoryID) {
//        this.CategoryID = categoryID;
//    }
//
//    public String getTitle() {
//        return this.Title;
//    }
//
//    public void setTitle(String title) {
//        this.Title = title;
//    }
//
//    public String getDescription() {
//        return this.Description;
//    }
//
//    public void setDescription(String description) {
//        this.Description = description;
//    }
//
//    public Date getStartDate() {
//        return this.StartDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.StartDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return this.EndDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.EndDate = endDate;
//    }
//
//    public int getAmount() {
//        return this.Amount;
//    }
//
//    public void setAmount(int amount) {
//        this.Amount = amount;
//    }
//
//    public double getPrice() {
//        return this.Price;
//    }
//
//    public void setPrice(double price) {
//        this.Price = price;
//    }
//
//    public String getImage() {
//        return this.Image;
//    }
//
//    public void setImage(String image) {
//        this.Image = image;
//    }
//
//    public String toString() {
//        return "Coupon{ID=" + this.ID + ", CompanyID=" + this.CompanyID + ", CategoryID=" + this.CategoryID + ", Title='" + this.Title + "', Description='" + this.Description + "', StartDate=" + this.StartDate + ", EndDate=" + this.EndDate + ", Amount=" + this.Amount + ", Price=" + this.Price + ", Image='" + this.Image + "'}";
//    }
}
