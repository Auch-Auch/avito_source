package u6.a.j0;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
public final class r0<T> {
    @JvmField
    @NotNull
    public final Flow<T> a;
    @JvmField
    public final int b;
    @JvmField
    @NotNull
    public final BufferOverflow c;
    @JvmField
    @NotNull
    public final CoroutineContext d;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlinx.coroutines.flow.Flow<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public r0(@NotNull Flow<? extends T> flow, int i, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineContext coroutineContext) {
        this.a = flow;
        this.b = i;
        this.c = bufferOverflow;
        this.d = coroutineContext;
    }
}
