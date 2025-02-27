package shop.khj745700.blog.expirydate;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        return payData.billingDate().plusMonths(1);
    }
}
