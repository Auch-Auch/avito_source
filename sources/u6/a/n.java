package u6.a;

import java.util.concurrent.Executor;
import kotlinx.coroutines.ExecutorCoroutineDispatcherBase;
import org.jetbrains.annotations.NotNull;
public final class n extends ExecutorCoroutineDispatcherBase {
    @NotNull
    public final Executor b;

    public n(@NotNull Executor executor) {
        this.b = executor;
        initFutureCancellation$kotlinx_coroutines_core();
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    @NotNull
    public Executor getExecutor() {
        return this.b;
    }
}
