
import Facade.ClientFacade;
import Job.CouponExpirationDaily;
import Login.ClientType;
import Login.LoginManager;

public class Tester {

    public static void main(String[] args) {
    testAll();

    }





    public static void testAll(){
        CouponExpirationDaily Thread = new CouponExpirationDaily();
        Thread.run();

        ClientFacade adminTest = LoginManager.getInstance().Login("admin@admin.com", "admin", ClientType.Administrator);

    }

}
