import org.junit.jupiter.api.Test;
import shop.khj745700.blog.password.PasswordStrength;
import shop.khj745700.blog.password.PasswordStrengthMeter;


import static org.junit.jupiter.api.Assertions.*;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    /**
     * TDD 방식을 사용할 때 고려해야 할 것
     *
     *
     * 1. 모든 규칙을 충족하는 경우
     * 2. 모든 조건을 충족하지 않는 경우
     *
     * 1. 경우는 각각의 규칙들을 red-green-blue 방식으로 차근히 개발할 수 있음.
     * 2. 경우는 모든 규칙들을 일단 구현해야 함.
     *  - 규칙 n개가 있다고 했을 때, 특정 값 x가 모든 조건을 충족하지 않고, 특정 값 y또한 모든 조건을 충족하지 않았다고 하자.
     *  - 그러면 그 조건들을 반드시 구현해야 모든 조건을 충족하지 않는다고 할 수 있다.
     *  왜? 서로 다른 x, y의 상관관계에 대해 정의해야 하기 때문이다.
     *
     * 따라서 모든 규칙을 충족하는 경우부터 작성하는 것이 좋다.
     */
    @Test
    void MeetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void MeetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("ab12!@C", PasswordStrength.NORMAL);
    }


    private void assertStrength(String password, PasswordStrength expected){
        PasswordStrength result = meter.meter(password);
        assertEquals(expected, result);
    }
}
