package a2.j.b.a.c.m.d;

import a2.b.a.a.a;
import com.google.auto.value.AutoValue;
@AutoValue
public abstract class c {
    public static final c a;

    static {
        Long l = 10485760L;
        Integer num = 200;
        Integer num2 = 10000;
        Long l2 = 604800000L;
        Integer num3 = 81920;
        String str = l == null ? " maxStorageSizeInBytes" : "";
        if (num == null) {
            str = a.c3(str, " loadBatchSize");
        }
        if (num2 == null) {
            str = a.c3(str, " criticalSectionEnterTimeoutMs");
        }
        if (l2 == null) {
            str = a.c3(str, " eventCleanUpAge");
        }
        if (num3 == null) {
            str = a.c3(str, " maxBlobByteSizePerRow");
        }
        if (str.isEmpty()) {
            a = new a(l.longValue(), num.intValue(), num2.intValue(), l2.longValue(), num3.intValue(), null);
            return;
        }
        throw new IllegalStateException(a.c3("Missing required properties:", str));
    }

    public abstract int a();

    public abstract long b();

    public abstract int c();

    public abstract int d();

    public abstract long e();
}
