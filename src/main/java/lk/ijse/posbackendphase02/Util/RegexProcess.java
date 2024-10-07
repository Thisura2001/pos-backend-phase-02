package lk.ijse.posbackendphase02.Util;

import java.util.regex.Pattern;

public class RegexProcess {
    public static boolean CustomerIdMatcher(String customerId) {
        String regexForUserID = "^CUSTOMER -: [a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        return regexPattern.matcher(customerId).matches();
    }
    public static boolean ItemIdMatcher(String itemId) {
        String regexForUserID = "^ITEMS -: [a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        return regexPattern.matcher(itemId).matches();
    }
    public static boolean OrderIdMatcher(String orderId) {
        String regexForUserID = "^ORDER -: [a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
        Pattern regexPattern = Pattern.compile(regexForUserID);
        return regexPattern.matcher(orderId).matches();
    }
}
