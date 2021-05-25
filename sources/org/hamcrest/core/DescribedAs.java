package org.hamcrest.core;

import java.util.regex.Pattern;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
public class DescribedAs<T> extends BaseMatcher<T> {
    public static final Pattern d = Pattern.compile("%([0-9]+)");
    public final String a;
    public final Matcher<T> b;
    public final Object[] c;

    public DescribedAs(String str, Matcher<T> matcher, Object[] objArr) {
        this.a = str;
        this.b = matcher;
        this.c = (Object[]) objArr.clone();
    }

    @Factory
    public static <T> Matcher<T> describedAs(String str, Matcher<T> matcher, Object... objArr) {
        return new DescribedAs(str, matcher, objArr);
    }

    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public void describeMismatch(Object obj, Description description) {
        this.b.describeMismatch(obj, description);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        java.util.regex.Matcher matcher = d.matcher(this.a);
        int i = 0;
        while (matcher.find()) {
            description.appendText(this.a.substring(i, matcher.start()));
            description.appendValue(this.c[Integer.parseInt(matcher.group(1))]);
            i = matcher.end();
        }
        if (i < this.a.length()) {
            description.appendText(this.a.substring(i));
        }
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return this.b.matches(obj);
    }
}
