package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;
public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {
    public static final ReflectiveTypeFinder b = new ReflectiveTypeFinder("matchesSafely", 1, 0);
    public final Class<?> a;

    public TypeSafeMatcher() {
        this(b);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public final void describeMismatch(Object obj, Description description) {
        if (obj == 0) {
            super.describeMismatch(obj, description);
        } else if (!this.a.isInstance(obj)) {
            description.appendText("was a ").appendText(obj.getClass().getName()).appendText(" (").appendValue(obj).appendText(")");
        } else {
            describeMismatchSafely(obj, description);
        }
    }

    public void describeMismatchSafely(T t, Description description) {
        super.describeMismatch(t, description);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.Matcher
    public final boolean matches(Object obj) {
        return obj != 0 && this.a.isInstance(obj) && matchesSafely(obj);
    }

    public abstract boolean matchesSafely(T t);

    public TypeSafeMatcher(Class<?> cls) {
        this.a = cls;
    }

    public TypeSafeMatcher(ReflectiveTypeFinder reflectiveTypeFinder) {
        this.a = reflectiveTypeFinder.findExpectedType(getClass());
    }
}
