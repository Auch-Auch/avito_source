package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
public class IsSame<T> extends BaseMatcher<T> {
    public final T a;

    public IsSame(T t) {
        this.a = t;
    }

    @Factory
    public static <T> Matcher<T> sameInstance(T t) {
        return new IsSame(t);
    }

    @Factory
    public static <T> Matcher<T> theInstance(T t) {
        return new IsSame(t);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("sameInstance(").appendValue(this.a).appendText(")");
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return obj == this.a;
    }
}
