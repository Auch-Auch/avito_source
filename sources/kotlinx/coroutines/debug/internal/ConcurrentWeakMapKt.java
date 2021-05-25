package kotlinx.coroutines.debug.internal;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;
import u6.a.i0.a.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0016\u0010\u0003\u001a\u00020\u00008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/internal/Symbol;", "REHASH", "Lu6/a/i0/a/c;", AuthSource.BOOKING_ORDER, "Lu6/a/i0/a/c;", "MARKED_NULL", "c", "MARKED_TRUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class ConcurrentWeakMapKt {
    public static final Symbol a = new Symbol("REHASH");
    public static final c b = new c(null);
    public static final c c = new c(Boolean.TRUE);

    public static final c access$mark(Object obj) {
        if (obj == null) {
            return b;
        }
        if (Intrinsics.areEqual(obj, Boolean.TRUE)) {
            return c;
        }
        return new c(obj);
    }

    public static final Void access$noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }
}
