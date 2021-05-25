package org.junit.internal.management;

import java.lang.reflect.InvocationTargetException;
import org.junit.internal.Classes;
import x6.c.b.c.d;
public class ManagementFactory {

    public static final class a {
        public static final Class<?> a;

        static {
            Class<?> cls;
            try {
                cls = Classes.getClass("java.lang.management.ManagementFactory");
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            a = cls;
        }

        public static Object a(String str) {
            Class<?> cls = a;
            if (cls != null) {
                try {
                    return cls.getMethod(str, new Class[0]).invoke(null, new Object[0]);
                } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
                }
            }
            return null;
        }
    }

    public static final class b {
        public static final RuntimeMXBean a;

        static {
            Object a3 = a.a("getRuntimeMXBean");
            a = a3 != null ? new x6.c.b.c.c(a3) : new x6.c.b.c.a();
        }
    }

    public static final class c {
        public static final ThreadMXBean a;

        static {
            Object a3 = a.a("getThreadMXBean");
            a = a3 != null ? new d(a3) : new x6.c.b.c.b();
        }
    }

    public static RuntimeMXBean getRuntimeMXBean() {
        return b.a;
    }

    public static ThreadMXBean getThreadMXBean() {
        return c.a;
    }
}
