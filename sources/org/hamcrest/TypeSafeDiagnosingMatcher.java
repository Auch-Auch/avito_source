package org.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.internal.ReflectiveTypeFinder;
public abstract class TypeSafeDiagnosingMatcher<T> extends BaseMatcher<T> {
    public static final ReflectiveTypeFinder b = new ReflectiveTypeFinder("matchesSafely", 2, 0);
    public final Class<?> a;

    public TypeSafeDiagnosingMatcher(Class<?> cls) {
        this.a = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.BaseMatcher, org.hamcrest.Matcher
    public final void describeMismatch(Object obj, Description description) {
        if (obj == 0 || !this.a.isInstance(obj)) {
            super.describeMismatch(obj, description);
        } else {
            matchesSafely(obj, description);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.hamcrest.Matcher
    public final boolean matches(Object obj) {
        return obj != 0 && this.a.isInstance(obj) && matchesSafely(obj, new Description.NullDescription());
    }

    public abstract boolean matchesSafely(T t, Description description);

    public TypeSafeDiagnosingMatcher(ReflectiveTypeFinder reflectiveTypeFinder) {
        this.a = reflectiveTypeFinder.findExpectedType(getClass());
    }

    public TypeSafeDiagnosingMatcher() {
        this(b);
    }
}
