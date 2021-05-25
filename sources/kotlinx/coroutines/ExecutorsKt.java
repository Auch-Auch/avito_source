package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import u6.a.j;
import u6.a.n;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0005*\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "from", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "asCoroutineDispatcher", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "asExecutor", "(Lkotlinx/coroutines/CoroutineDispatcher;)Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class ExecutorsKt {
    @NotNull
    public static final Executor asExecutor(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Executor executor;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = (ExecutorCoroutineDispatcher) (!(coroutineDispatcher instanceof ExecutorCoroutineDispatcher) ? null : coroutineDispatcher);
        return (executorCoroutineDispatcher == null || (executor = executorCoroutineDispatcher.getExecutor()) == null) ? new j(coroutineDispatcher) : executor;
    }

    @JvmName(name = "from")
    @NotNull
    public static final ExecutorCoroutineDispatcher from(@NotNull ExecutorService executorService) {
        return new n(executorService);
    }

    @JvmName(name = "from")
    @NotNull
    public static final CoroutineDispatcher from(@NotNull Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        j jVar = (j) (!(executor instanceof j) ? null : executor);
        return (jVar == null || (coroutineDispatcher = jVar.a) == null) ? new n(executor) : coroutineDispatcher;
    }
}
