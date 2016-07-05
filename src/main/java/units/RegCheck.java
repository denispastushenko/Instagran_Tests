package units;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegCheck {
    public static String regchecking (String correct) {

        Pattern pt = Pattern.compile("(.+jpg)");
        Matcher m = pt.matcher(correct);
        m.find();
        return m.group();
    }
}
