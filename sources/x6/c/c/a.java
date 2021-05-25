package x6.c.c;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.matchers.JUnitMatchers;
public class a {
    public final List<Matcher<?>> a = new ArrayList();

    public Matcher<Throwable> a() {
        Matcher<?> matcher;
        if (this.a.size() == 1) {
            matcher = this.a.get(0);
        } else {
            matcher = CoreMatchers.allOf(new ArrayList(this.a));
        }
        return JUnitMatchers.isThrowable(matcher);
    }
}
