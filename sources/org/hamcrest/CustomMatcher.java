package org.hamcrest;
public abstract class CustomMatcher<T> extends BaseMatcher<T> {
    public final String a;

    public CustomMatcher(String str) {
        if (str != null) {
            this.a = str;
            return;
        }
        throw new IllegalArgumentException("Description should be non null!");
    }

    @Override // org.hamcrest.SelfDescribing
    public final void describeTo(Description description) {
        description.appendText(this.a);
    }
}
