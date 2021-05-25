package kotlinx.coroutines.internal;

import a2.b.a.a.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.l;
import u6.a.k0.c;
@Metadata(bv = {1, 0, 3}, d1 = {"u6/a/k0/c"}, d2 = {}, k = 4, mv = {1, 4, 0})
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return c.a;
    }

    @Nullable
    public static final String systemProp(@NotNull String str) {
        int i = c.a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static /* synthetic */ int systemProp$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return systemProp(str, i, i2, i3);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return systemProp(str, j, j2, j3);
    }

    public static final boolean systemProp(@NotNull String str, boolean z) {
        String systemProp = systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z;
    }

    public static final int systemProp(@NotNull String str, int i, int i2, int i3) {
        return (int) systemProp(str, (long) i, (long) i2, (long) i3);
    }

    public static final long systemProp(@NotNull String str, long j, long j2, long j3) {
        String systemProp = systemProp(str);
        if (systemProp == null) {
            return j;
        }
        Long longOrNull = l.toLongOrNull(systemProp);
        if (longOrNull != null) {
            long longValue = longOrNull.longValue();
            if (j2 <= longValue && j3 >= longValue) {
                return longValue;
            }
            StringBuilder T = a.T("System property '", str, "' should be in range ", j2);
            a.l1(T, "..", j3, ", but is '");
            throw new IllegalStateException(a.k(T, longValue, '\'').toString());
        }
        throw new IllegalStateException(a.e("System property '", str, "' has unrecognized value '", systemProp, '\'').toString());
    }
}
