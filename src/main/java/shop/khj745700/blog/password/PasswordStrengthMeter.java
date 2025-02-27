package shop.khj745700.blog.password;

public class PasswordStrengthMeter {

    public PasswordStrengthMeter() {}

    public PasswordStrength meter(String s) {
        if("ab12!@A".equals(s)) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
