
import shop.khj745700.blog.expirydate.ExpiryDateCalculator;
import org.junit.jupiter.api.Test;
import shop.khj745700.blog.expirydate.PayData;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    private ExpiryDateCalculator calc = new ExpiryDateCalculator();

    /**
     * <h1>요구사항</h1>
     * 1. 서비스를 사용하려면 매달 1만 원을 선불로 납부한다. 납부일 기준으로 한 달 뒤가 서비스 만료일이 된다.
     * 2. 2개월 이상 요금을 납부할 수 있다.
     * 3. 10만 원을 납부하면 서비스를 1년 제공한다.
     */

    @Test
    void 만원_납부_시_한달_뒤_만료일() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 1))
                        .payment(10_000)
                        .build(),
                LocalDate.of(2020, 2, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 5, 1))
                        .payment(10_000)
                        .build(),
                LocalDate.of(2020, 6, 1));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 5, 5))
                        .payment(10_000)
                        .build(),
                LocalDate.of(2020, 6, 5));

    }

    @Test
    void 만원_납부_시_한달_뒤_만료일이_같지_않음() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payment(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29));
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 3, 31))
                        .payment(10_000)
                        .build(),
                LocalDate.of(2020, 4, 30));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2020,1,30))
                        .billingDate(LocalDate.of(2020,2,28))
                        .payment(10_000)
                        .build(),
                LocalDate.of(2020,3,30));
    }


    private void assertExpiryDate(PayData payData, LocalDate expiredDate) {
        LocalDate actualDate = calc.calculateExpiryDate(payData);
        assertEquals(expiredDate, actualDate);
    }
}
