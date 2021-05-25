package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
public class Every<T> extends TypeSafeDiagnosingMatcher<Iterable<T>> {
    public final Matcher<? super T> c;

    public Every(Matcher<? super T> matcher) {
        this.c = matcher;
    }

    @Factory
    public static <U> Matcher<Iterable<U>> everyItem(Matcher<U> matcher) {
        return new Every(matcher);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("every item is ").appendDescriptionOf(this.c);
    }

    @Override // org.hamcrest.TypeSafeDiagnosingMatcher
    public /* bridge */ /* synthetic */ boolean matchesSafely(Object obj, Description description) {
        return matchesSafely((Iterable) ((Iterable) obj), description);
    }

    public boolean matchesSafely(Iterable<T> iterable, Description description) {
        for (T t : iterable) {
            if (!this.c.matches(t)) {
                description.appendText("an item ");
                this.c.describeMismatch(t, description);
                return false;
            }
        }
        return true;
    }
}
