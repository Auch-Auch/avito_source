package x6.c.b.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.junit.internal.Classes;
import org.junit.internal.management.RuntimeMXBean;
public final class c implements RuntimeMXBean {
    public final Object a;

    public static final class a {
        public static final Method a;

        static {
            Method method;
            try {
                method = Classes.getClass("java.lang.management.RuntimeMXBean").getMethod("getInputArguments", new Class[0]);
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
                method = null;
            }
            a = method;
        }
    }

    public c(Object obj) {
        this.a = obj;
    }

    @Override // org.junit.internal.management.RuntimeMXBean
    public List<String> getInputArguments() {
        Method method = a.a;
        if (method != null) {
            try {
                return (List) method.invoke(this.a, new Object[0]);
            } catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
        return Collections.emptyList();
    }
}
