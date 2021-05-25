package x6.c.b.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.internal.Classes;
import org.junit.internal.management.ThreadMXBean;
public final class d implements ThreadMXBean {
    public final Object a;

    public static final class a {
        public static final Method a;
        public static final Method b;

        static {
            Method method;
            Method method2 = null;
            try {
                Class<?> cls = Classes.getClass("java.lang.management.ThreadMXBean");
                method = cls.getMethod("getThreadCpuTime", Long.TYPE);
                try {
                    method2 = cls.getMethod("isThreadCpuTimeSupported", new Class[0]);
                } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
                }
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused2) {
                method = null;
            }
            a = method;
            b = method2;
        }
    }

    public d(Object obj) {
        this.a = obj;
    }

    @Override // org.junit.internal.management.ThreadMXBean
    public long getThreadCpuTime(long j) {
        Method method = a.a;
        if (method != null) {
            try {
                return ((Long) method.invoke(this.a, Long.valueOf(j))).longValue();
            } catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new UnsupportedOperationException("Unable to access ThreadMXBean", e);
            }
        } else {
            throw new UnsupportedOperationException("Unable to access ThreadMXBean");
        }
    }

    @Override // org.junit.internal.management.ThreadMXBean
    public boolean isThreadCpuTimeSupported() {
        Method method = a.b;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(this.a, new Object[0])).booleanValue();
            } catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
        return false;
    }
}
