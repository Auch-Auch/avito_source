package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
public class IsAnything<T> extends BaseMatcher<T> {
    public final String a;

    public IsAnything() {
        this("ANYTHING");
    }

    @Factory
    public static Matcher<Object> anything() {
        return new IsAnything();
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText(this.a);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return true;
    }

    public IsAnything(String str) {
        this.a = str;
    }

    @Factory
    public static Matcher<Object> anything(String str) {
        return new IsAnything(str);
    }
}
