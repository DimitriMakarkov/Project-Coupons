package Job;

import DataBase.DB_Utilities;
import SQL_Commands.Coupons_Commands;

public class CouponExpirationDaily implements Runnable {
    private boolean quit;

    public CouponExpirationDaily() {
    }

    public void run() {
        try {
            while (!quit) {
                DB_Utilities.RunCommand(Coupons_Commands.deleteExpiredCouponsFromCustomers);
                DB_Utilities.RunCommand(Coupons_Commands.deleteExpiredCoupons);
                System.out.println("Expired Coupons Have Been Deleted");
                Thread.sleep(24 * 60 * 60 * 1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        quit = true;
    }
}


