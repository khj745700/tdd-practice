package shop.khj745700.blog.expirydate;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    private static final int PAY_PER_MONTH = 10_000;
    private static final int PAY_PER_YEAR = 100_000;

    public LocalDate calculateExpiryDate(PayData payData) {
        LocalDate expectedDate = payData.billingDate().plusMonths(getPayPerMonth(payData.payment()));
        if(payData.firstBillingDate() == null) {
            return expectedDate;
        }

        if(expectedDate.getDayOfMonth() < payData.firstBillingDate().getDayOfMonth()) {
            return expectedDate.withDayOfMonth(Math.min(expectedDate.getMonth().length(expectedDate.isLeapYear()), payData.firstBillingDate().getDayOfMonth()));
        }
        return expectedDate;
    }


    private int getPayPerMonth(int payment) {
        if(payment >= PAY_PER_YEAR) {
            return (payment / PAY_PER_YEAR) * 12;
        }
        return payment / PAY_PER_MONTH;
    }
}
