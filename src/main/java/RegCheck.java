import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegCheck {
    public  String regchecking (String correct) {

        Pattern pt = Pattern.compile("(.+jpg)");
        Matcher m = pt.matcher(correct);
        m.find();
        return m.group();
    }
}
