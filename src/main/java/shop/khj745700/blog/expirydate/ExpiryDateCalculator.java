package shop.khj745700.blog.expirydate;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    private static final int PAY_PER_MONTH = 10_000;

    public LocalDate calculateExpiryDate(PayData payData) {
        LocalDate expectedDate = payData.billingDate().plusMonths(getPayPerMonth(payData.payment()));
        if(payData.firstBillingDate() == null) {
            return expectedDate;
        }

        if(expectedDate.getDayOfMonth() < payData.firstBillingDate().getDayOfMonth()) {
            return expectedDate.plusDays(payData.firstBillingDate().getDayOfMonth() - expectedDate.getDayOfMonth());
        }
        return expectedDate;
    }


    private int getPayPerMonth(int payment) {
        return payment / PAY_PER_MONTH;
    }
}
