package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Ignore;
import org.junit.Test;
@Deprecated
public class TestMethod {
    public final Method a;
    public TestClass b;

    public TestMethod(Method method, TestClass testClass) {
        this.a = method;
        this.b = testClass;
    }

    public Class<? extends Throwable> getExpectedException() {
        Test test = (Test) this.a.getAnnotation(Test.class);
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    public long getTimeout() {
        Test test = (Test) this.a.getAnnotation(Test.class);
        if (test == null) {
            return 0;
        }
        return test.timeout();
    }

    public void invoke(Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        this.a.invoke(obj, new Object[0]);
    }

    public boolean isIgnored() {
        return this.a.getAnnotation(Ignore.class) != null;
    }
}
