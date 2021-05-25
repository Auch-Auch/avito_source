package u6.a;

import java.util.concurrent.Executor;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
public final class j implements Executor {
    @JvmField
    @NotNull
    public final CoroutineDispatcher a;

    public j(@NotNull CoroutineDispatcher coroutineDispatcher) {
        this.a = coroutineDispatcher;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        this.a.dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return this.a.toString();
    }
}
