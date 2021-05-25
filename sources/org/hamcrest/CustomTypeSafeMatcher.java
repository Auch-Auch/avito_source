package org.hamcrest;
public abstract class CustomTypeSafeMatcher<T> extends TypeSafeMatcher<T> {
    public final String c;

    public CustomTypeSafeMatcher(String str) {
        if (str != null) {
            this.c = str;
            return;
        }
        throw new IllegalArgumentException("Description must be non null!");
    }

    @Override // org.hamcrest.SelfDescribing
    public final void describeTo(Description description) {
        description.appendText(this.c);
    }
}
