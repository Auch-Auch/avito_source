package org.hamcrest;
public abstract class DiagnosingMatcher<T> extends BaseMatcher<T> {
    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public final void describeMismatch(Object obj, Description description) {
        matches(obj, description);
    }

    @Override // org.hamcrest.Matcher
    public final boolean matches(Object obj) {
        return matches(obj, Description.NONE);
    }

    public abstract boolean matches(Object obj, Description description);
}
