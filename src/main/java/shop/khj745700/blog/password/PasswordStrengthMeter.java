package shop.khj745700.blog.password;

public class PasswordStrengthMeter {

    public PasswordStrengthMeter() {}

    public PasswordStrength meter(String s) {
        if(s.length() < 8) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }
}
