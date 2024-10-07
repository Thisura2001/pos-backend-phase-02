package lk.ijse.posbackendphase02.Util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUSTOMER -: " + UUID.randomUUID();
    }
    public static String generateItemId(){
        return "ITEMS -: " + UUID.randomUUID();
    }
    public static String generateOrderId(){
        return "ORDER -: " + UUID.randomUUID();
    }

}
