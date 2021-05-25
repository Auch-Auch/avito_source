package u6.a.j0.y0;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import org.jetbrains.annotations.NotNull;
public final class d implements Continuation<Object> {
    @NotNull
    public static final CoroutineContext a = EmptyCoroutineContext.INSTANCE;
    public static final d b = new d();

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
    }
}
