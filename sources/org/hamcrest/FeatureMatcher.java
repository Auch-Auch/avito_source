package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;
public abstract class FeatureMatcher<T, U> extends TypeSafeDiagnosingMatcher<T> {
    public static final ReflectiveTypeFinder f = new ReflectiveTypeFinder("featureValueOf", 1, 0);
    public final Matcher<? super U> c;
    public final String d;
    public final String e;

    public FeatureMatcher(Matcher<? super U> matcher, String str, String str2) {
        super(f);
        this.c = matcher;
        this.d = str;
        this.e = str2;
    }

    @Override // org.hamcrest.SelfDescribing
    public final void describeTo(Description description) {
        description.appendText(this.d).appendText(" ").appendDescriptionOf(this.c);
    }

    public abstract U featureValueOf(T t);

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public boolean matchesSafely(T t, Description description) {
        U featureValueOf = featureValueOf(t);
        if (this.c.matches(featureValueOf)) {
            return true;
        }
        description.appendText(this.e).appendText(" ");
        this.c.describeMismatch(featureValueOf, description);
        return false;
    }
}
