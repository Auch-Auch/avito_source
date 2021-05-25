package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.internal.Throwables;
public class StacktracePrintingMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    public final Matcher<T> c;

    public StacktracePrintingMatcher(Matcher<T> matcher) {
        this.c = matcher;
    }

    @Factory
    public static <T extends Exception> Matcher<T> isException(Matcher<T> matcher) {
        return new StacktracePrintingMatcher(matcher);
    }

    @Factory
    public static <T extends Throwable> Matcher<T> isThrowable(Matcher<T> matcher) {
        return new StacktracePrintingMatcher(matcher);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.junit.internal.matchers.StacktracePrintingMatcher<T extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.TypeSafeMatcher
    public /* bridge */ /* synthetic */ void describeMismatchSafely(Object obj, Description description) {
        describeMismatchSafely((StacktracePrintingMatcher<T>) ((Throwable) obj), description);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        this.c.describeTo(description);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.junit.internal.matchers.StacktracePrintingMatcher<T extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.TypeSafeMatcher
    public /* bridge */ /* synthetic */ boolean matchesSafely(Object obj) {
        return matchesSafely((StacktracePrintingMatcher<T>) ((Throwable) obj));
    }

    public void describeMismatchSafely(T t, Description description) {
        this.c.describeMismatch(t, description);
        description.appendText("\nStacktrace was: ");
        description.appendText(Throwables.getStacktrace(t));
    }

    public boolean matchesSafely(T t) {
        return this.c.matches(t);
    }
}
