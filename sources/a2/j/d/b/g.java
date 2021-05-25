package a2.j.d.b;

import com.avito.android.remote.auth.AuthSource;
import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import sun.misc.Unsafe;
@GwtIncompatible
public abstract class g extends Number {
    public static final ThreadLocal<int[]> d = new ThreadLocal<>();
    public static final Random e = new Random();
    public static final int f = Runtime.getRuntime().availableProcessors();
    public static final Unsafe g;
    public static final long h;
    public static final long i;
    @NullableDecl
    public volatile transient b[] a;
    public volatile transient long b;
    public volatile transient int c;

    public static class a implements PrivilegedExceptionAction<Unsafe> {
        /* renamed from: a */
        public Unsafe run() throws Exception {
            Field[] declaredFields = Unsafe.class.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    public static final class b {
        public static final Unsafe b;
        public static final long c;
        public volatile long a;

        static {
            try {
                Unsafe e = g.e();
                b = e;
                c = e.objectFieldOffset(b.class.getDeclaredField(AuthSource.SEND_ABUSE));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        public b(long j) {
            this.a = j;
        }

        public final boolean a(long j, long j2) {
            return b.compareAndSwapLong(this, c, j, j2);
        }
    }

    static {
        try {
            Unsafe e2 = e();
            g = e2;
            h = e2.objectFieldOffset(g.class.getDeclaredField(AuthSource.BOOKING_ORDER));
            i = e2.objectFieldOffset(g.class.getDeclaredField("c"));
        } catch (Exception e3) {
            throw new Error(e3);
        }
    }

    public static Unsafe e() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException unused) {
            try {
                return (Unsafe) AccessController.doPrivileged(new a());
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }
    }

    public final boolean c(long j, long j2) {
        return g.compareAndSwapLong(this, h, j, j2);
    }

    public final boolean d() {
        return g.compareAndSwapInt(this, i, 0, 1);
    }
}
