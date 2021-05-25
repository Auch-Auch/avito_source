package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
public class IsNot<T> extends BaseMatcher<T> {
    public final Matcher<T> a;

    public IsNot(Matcher<T> matcher) {
        this.a = matcher;
    }

    @Factory
    public static <T> Matcher<T> not(Matcher<T> matcher) {
        return new IsNot(matcher);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("not ").appendDescriptionOf(this.a);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return !this.a.matches(obj);
    }

    @Factory
    public static <T> Matcher<T> not(T t) {
        return not(IsEqual.equalTo(t));
    }
}
