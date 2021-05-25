package u6.a;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
public final class x implements Runnable {
    public final CoroutineDispatcher a;
    public final CancellableContinuation<Unit> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public x(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        this.a = coroutineDispatcher;
        this.b = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.resumeUndispatched(this.a, Unit.INSTANCE);
    }
}
