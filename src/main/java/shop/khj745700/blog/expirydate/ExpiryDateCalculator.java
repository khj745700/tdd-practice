package shop.khj745700.blog.expirydate;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payment) {
        return billingDate.plusMonths(1);
    }
}
