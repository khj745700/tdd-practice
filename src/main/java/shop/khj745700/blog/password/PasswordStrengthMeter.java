package shop.khj745700.blog.password;

public class PasswordStrengthMeter {

    public PasswordStrengthMeter() {}

    public PasswordStrength meter(String s) {

        boolean lengthIsSufficient = meetsLengthCriteria(s);
        boolean containsNum = meetsContainingNumberCriteria(s);
        if(!lengthIsSufficient) {
            return PasswordStrength.NORMAL;
        }

        if(!containsNum) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private boolean meetsLengthCriteria(String s) {
        return s.length() >= 8;
    }


    private boolean meetsContainingNumberCriteria(String s) {
        for(char c : s.toCharArray()) {
            if('0' <= c && c <= '9') {
                return true;
            }
        }

        return false;
    }
}
