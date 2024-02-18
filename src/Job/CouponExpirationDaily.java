package Job;

import DAO.CouponsDAO;
import DBDAO.CouponsDBDAO;

public class CouponExpirationDaily implements Runnable {
    private CouponsDAO couponsDAO = new CouponsDBDAO();
    private boolean quit;

    public CouponExpirationDaily() {
    }

    public void run() {
        try {
            while (!quit) {
                couponsDAO = null;
                couponsDAO.deleteExpiredCoupons();
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


