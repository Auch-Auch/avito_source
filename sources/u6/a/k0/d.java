package u6.a.k0;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
public final class d {
    public Object[] a;
    public int b;
    @NotNull
    public final CoroutineContext c;

    public d(@NotNull CoroutineContext coroutineContext, int i) {
        this.c = coroutineContext;
        this.a = new Object[i];
    }
}
