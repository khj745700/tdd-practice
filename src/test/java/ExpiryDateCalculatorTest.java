
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ExpiryDateCalculatorTest {
    @Test
    void 만원_납부_시_한달_뒤_만료일() {
        LocalDate billingDate = LocalDate.of(2020, 1, 1);
        int payment = 10_000;

        ExpiryDateCalculator calc = new ExpiryDateCalculator();
        LocalDate expiredDate = calc.cal(billingDate, payment);

        assertEquals(expiredDate, LocalDate.of(2020, 2, 1));
    }
}
