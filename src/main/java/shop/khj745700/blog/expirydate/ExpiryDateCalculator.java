package shop.khj745700.blog.expirydate;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        LocalDate expectedDate = payData.billingDate().plusMonths(1);
        if(payData.firstBillingDate() == null) {
            return expectedDate;
        }
        if(expectedDate.getDayOfMonth() < payData.firstBillingDate().getDayOfMonth()) {
            return expectedDate.plusDays(payData.firstBillingDate().getDayOfMonth() - expectedDate.getDayOfMonth());
        }
        return expectedDate;
    }

}
