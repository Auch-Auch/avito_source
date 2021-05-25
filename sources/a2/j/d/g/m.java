package a2.j.d.g;

import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;
public final class m {
    public static final c a;

    public enum b implements c {
        INSTANCE {
            @Override // a2.j.d.g.m.c
            public long a(byte[] bArr, int i) {
                return Longs.fromBytes(bArr[i + 7], bArr[i + 6], bArr[i + 5], bArr[i + 4], bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
            }
        };

        /* access modifiers changed from: public */
        b(a aVar) {
        }
    }

    public interface c {
        long a(byte[] bArr, int i);
    }

    public enum d implements c {
        UNSAFE_LITTLE_ENDIAN {
            @Override // a2.j.d.g.m.c
            public long a(byte[] bArr, int i) {
                return d.c.getLong(bArr, ((long) i) + ((long) d.d));
            }
        },
        UNSAFE_BIG_ENDIAN {
            @Override // a2.j.d.g.m.c
            public long a(byte[] bArr, int i) {
                return Long.reverseBytes(d.c.getLong(bArr, ((long) i) + ((long) d.d)));
            }
        };
        
        public static final Unsafe c;
        public static final int d;

        public static class c implements PrivilegedExceptionAction<Unsafe> {
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

        /* access modifiers changed from: public */
        static {
            Unsafe b2 = b();
            c = b2;
            d = b2.arrayBaseOffset(byte[].class);
            if (b2.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: public */
        d(a aVar) {
        }

        public static Unsafe b() {
            try {
                return Unsafe.getUnsafe();
            } catch (SecurityException unused) {
                try {
                    return (Unsafe) AccessController.doPrivileged(new c());
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            }
        }
    }

    static {
        c cVar = b.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                cVar = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? d.UNSAFE_LITTLE_ENDIAN : d.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        a = cVar;
    }

    public static int a(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long b(byte[] bArr, int i) {
        return a.a(bArr, i);
    }
}
