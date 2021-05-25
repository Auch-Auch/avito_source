package org.hamcrest.core;

import a2.b.a.a.a;
import com.avito.android.BuildConfig;
import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
public class IsInstanceOf extends DiagnosingMatcher<Object> {
    public final Class<?> a;
    public final Class<?> b;

    public IsInstanceOf(Class<?> cls) {
        this.a = cls;
        if (Boolean.TYPE.equals(cls)) {
            cls = Boolean.class;
        } else if (Byte.TYPE.equals(cls)) {
            cls = Byte.class;
        } else if (Character.TYPE.equals(cls)) {
            cls = Character.class;
        } else if (Double.TYPE.equals(cls)) {
            cls = Double.class;
        } else if (Float.TYPE.equals(cls)) {
            cls = Float.class;
        } else if (Integer.TYPE.equals(cls)) {
            cls = Integer.class;
        } else if (Long.TYPE.equals(cls)) {
            cls = Long.class;
        } else if (Short.TYPE.equals(cls)) {
            cls = Short.class;
        }
        this.b = cls;
    }

    @Factory
    public static <T> Matcher<T> any(Class<T> cls) {
        return new IsInstanceOf(cls);
    }

    @Factory
    public static <T> Matcher<T> instanceOf(Class<?> cls) {
        return new IsInstanceOf(cls);
    }

    @Override // org.hamcrest.SelfDescribing
    public void describeTo(Description description) {
        description.appendText("an instance of ").appendText(this.a.getName());
    }

    @Override // org.hamcrest.DiagnosingMatcher
    public boolean matches(Object obj, Description description) {
        if (obj == null) {
            description.appendText(BuildConfig.ADJUST_DEFAULT_TRACKER);
            return false;
        } else if (this.b.isInstance(obj)) {
            return true;
        } else {
            Description appendValue = description.appendValue(obj);
            StringBuilder L = a.L(" is a ");
            L.append(obj.getClass().getName());
            appendValue.appendText(L.toString());
            return false;
        }
    }
}
