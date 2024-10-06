package lk.ijse.posbackendphase02.Util;

import java.util.UUID;

public class AppUtil {
    public String generateCustomerId(){
        return "CUSTOMER-" + UUID.randomUUID();
    }
    public String generateItemId(){
        return "ITEM-" + UUID.randomUUID();
    }
    public String generateOrderId(){
        return "ORDER-" + UUID.randomUUID();
    }

}
