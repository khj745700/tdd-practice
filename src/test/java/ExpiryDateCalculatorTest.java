
import shop.khj745700.blog.expirydate.ExpiryDateCalculator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {

    private ExpiryDateCalculator calc = new ExpiryDateCalculator();

    @Test
    void 만원_납부_시_한달_뒤_만료일() {
        assertExpiryDate(
                LocalDate.of(2020, 1, 1), 10_000,
                LocalDate.of(2020, 2, 1));
        assertExpiryDate(
                LocalDate.of(2020, 5, 1), 10_000,
                LocalDate.of(2020, 6, 1));
    }


    private void assertExpiryDate(LocalDate billingDate, int payment, LocalDate expiredDate) {
        LocalDate actualDate = calc.calculateExpiryDate(billingDate, payment);
        assertEquals(expiredDate, actualDate);
    }
}
