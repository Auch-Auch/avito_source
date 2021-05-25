package n6.c.a;

import arrow.syntax.internal.Platform;
import kotlin.jvm.internal.Intrinsics;
import n6.c.a.u8;
import org.jetbrains.annotations.NotNull;
public final class v8<F, K extends u8<? super F, ? extends R>, R> {
    public final Platform.ConcurrentMap<K, R> a = Platform.INSTANCE.newConcurrentMap();
    public final F b;

    public v8(F f) {
        this.b = f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: arrow.syntax.internal.Platform$ConcurrentMap<K extends n6.c.a.u8<? super F, ? extends R>, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public final R a(@NotNull K k) {
        Intrinsics.checkParameterIsNotNull(k, "k");
        R r = this.a.get(k);
        return r != null ? r : (R) this.a.putSafely(k, k.invoke(this.b));
    }
}
