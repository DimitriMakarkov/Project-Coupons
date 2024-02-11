package Job;

import DAO.CouponsDAO;

public class CouponExpirationDaily implements Runnable {
    private CouponsDAO couponsDAO;
    private boolean quit;

//    public CouponExpirationDaily(CouponsDAO couponsDAO) {
//        this.couponsDAO = couponsDAO;
//    }

    public CouponExpirationDaily() {
        this.couponsDAO=couponsDAO;
    }

    public void run() {
        try {
            while (!quit) {
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


