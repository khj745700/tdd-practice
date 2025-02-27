package shop.khj745700.blog.password;

public class PasswordStrengthMeter {

    public PasswordStrengthMeter() {}

    public PasswordStrength meter(String s) {

        if(s == null || s.isEmpty()) {
            return PasswordStrength.INVALID;
        }

        boolean lengthEnough = meetsLengthCriteria(s);
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUppercase = meetsContainingUppercaseCriteria(s);

        if(lengthEnough && !containsNum && !containsUppercase) {
            return PasswordStrength.WEAK;
        }

        if(!lengthEnough && !containsNum && containsUppercase) {
            return PasswordStrength.WEAK;
        }

        if(!lengthEnough && containsNum && !containsUppercase) {
            return PasswordStrength.WEAK;
        }

        if(!lengthEnough) {
            return PasswordStrength.NORMAL;
        }

        if(!containsNum) {
            return PasswordStrength.NORMAL;
        }

        if(!containsUppercase) {
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
