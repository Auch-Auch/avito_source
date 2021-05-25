package org.junit.internal.matchers;

import java.lang.Throwable;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
public class ThrowableMessageMatcher<T extends Throwable> extends TypeSafeMatcher<T> {
    public final Matcher<String> c;

    public ThrowableMessageMatcher(Matcher<String> matcher) {
        this.c = matcher;
    }

    @Factory
    public static <T extends Throwable> Matcher<T> hasMessage(Matcher<String> matcher) {
        return new ThrowableMessageMatcher(matcher);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.junit.internal.matchers.ThrowableMessageMatcher<T extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.TypeSafeMatcher
    public /* bridge */ /* synthetic */ void describeMismatchSafely(Object obj, Description description) {
        describeMismatchSafely((ThrowableMessageMatcher<T>) ((Throwable) obj), description);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("exception with message ");
        description.appendDescriptionOf(this.c);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.junit.internal.matchers.ThrowableMessageMatcher<T extends java.lang.Throwable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.TypeSafeMatcher
    public /* bridge */ /* synthetic */ boolean matchesSafely(Object obj) {
        return matchesSafely((ThrowableMessageMatcher<T>) ((Throwable) obj));
    }

    public void describeMismatchSafely(T t, Description description) {
        description.appendText("message ");
        this.c.describeMismatch(t.getMessage(), description);
    }

    public boolean matchesSafely(T t) {
        return this.c.matches(t.getMessage());
    }
}
