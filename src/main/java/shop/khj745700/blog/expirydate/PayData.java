package shop.khj745700.blog.expirydate;

import java.time.LocalDate;

public record PayData(LocalDate firstBillingDate, LocalDate billingDate, int payment) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private LocalDate firstBillingDate;
        private LocalDate billingDate;
        private int payment;

        public Builder firstBillingDate(LocalDate firstBillingDate) {
            this.firstBillingDate = firstBillingDate;
            return this;
        }
        public Builder billingDate(LocalDate billingDate) {
            this.billingDate = billingDate;
            return this;
        }
        public Builder payment(int payment) {
            this.payment = payment;
            return this;
        }

        public PayData build() {
            return new PayData(firstBillingDate, billingDate, payment);
        }
    }
}
