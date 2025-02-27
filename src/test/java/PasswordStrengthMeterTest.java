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
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("ab12!@C", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
    }

    /**
     * <h1>지속적인 리팩토링</h1>
     *
     * 테스트 통과한 후에는 리팩토링을 진행한다. 매번 리팩토링을 진행해야 하는 것은 아니지만, 적당한 후보가 보이면 리팩토링을 진행한다.
     * 코드 중복은 대표적인 리팩토링 대상이다. 코드가 길어지면 메서드 추출과 같은 기법을 사용해서 메서드 이름으로 코드의 의미를 표현할 수 있다.
     *
     *
     * <h1>테스트 대상 코드의 리팩토링 시점</h1>
     * <ul>
     *     <li>테스트 대상 코드에서 상수를 변수로 바꾸거나 변수 이름을 변경하는 것과 같은 작은 리팩토링은 발견하면 바로 실행한다.</li>
     *     <li>메서드 추출과 같이 메서드의 구조에 영향을 주는 리팩토링은 큰 틀에서 구현 흐름이 눈에 들어오기 시작한 뒤에 진행한다.</li>
     * </ul>
     *
     */
    private void assertStrength(String password, PasswordStrength expected){
        PasswordStrength result = meter.meter(password);
        assertEquals(expected, result);
    }
}
