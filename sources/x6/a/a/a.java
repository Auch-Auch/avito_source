package x6.a.a;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
public abstract class a<T> extends BaseMatcher<T> {
    public final Iterable<Matcher<? super T>> a;

    public a(Iterable<Matcher<? super T>> iterable) {
        this.a = iterable;
    }

    @Override // org.hamcrest.SelfDescribing
    public abstract void describeTo(Description description);

    public void describeTo(Description description, String str) {
        description.appendList("(", a2.b.a.a.a.e3(" ", str, " "), ")", this.a);
    }

    @Override // org.hamcrest.Matcher
    public abstract boolean matches(Object obj);

    public boolean matches(Object obj, boolean z) {
        for (Matcher<? super T> matcher : this.a) {
            if (matcher.matches(obj) == z) {
                return z;
            }
        }
        return !z;
    }
}
