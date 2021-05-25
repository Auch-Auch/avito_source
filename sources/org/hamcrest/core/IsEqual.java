package org.hamcrest.core;

import java.lang.reflect.Array;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
public class IsEqual<T> extends BaseMatcher<T> {
    public final Object a;

    public IsEqual(T t) {
        this.a = t;
    }

    public static boolean a(Object obj, Object obj2) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            if (!b(Array.get(obj, i), Array.get(obj2, i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null || !obj.getClass().isArray()) {
            return obj.equals(obj2);
        }
        if (obj2.getClass().isArray()) {
            if ((Array.getLength(obj) == Array.getLength(obj2)) && a(obj, obj2)) {
                return true;
            }
        }
        return false;
    }

    @Factory
    public static <T> Matcher<T> equalTo(T t) {
        return new IsEqual(t);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendValue(this.a);
    }

    @Override // org.hamcrest.Matcher
    public boolean matches(Object obj) {
        return b(obj, this.a);
    }
}
