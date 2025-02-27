package shop.khj745700.blog.password;

public class PasswordStrengthMeter {

    public PasswordStrengthMeter() {}

    public PasswordStrength meter(String s) {

        if(s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        int meetsCount = 0;
        if(meetsLengthCriteria(s)) {
            meetsCount++;
        }
        if(meetsContainingNumberCriteria(s)) {
            meetsCount++;
        }
        if(meetsContainingUppercaseCriteria(s)) {
            meetsCount++;
        }

        if(meetsCount <= 1) {
            return PasswordStrength.WEAK;
        }

        if(meetsCount == 2) {
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

    private boolean meetsContainingUppercaseCriteria(String s) {
        for(char c : s.toCharArray()) {
            if('A' <= c && c <= 'Z') {
                return true;
            }
        }
        return false;
    }
}
