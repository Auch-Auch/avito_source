package u6.a.j0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class x0 implements FlowCollector<Object> {
    public final Throwable a;

    public x0(@NotNull Throwable th) {
        this.a = th;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        throw this.a;
    }
}
