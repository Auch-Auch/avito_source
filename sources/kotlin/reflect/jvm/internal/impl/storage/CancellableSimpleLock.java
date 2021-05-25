package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class CancellableSimpleLock extends DefaultSimpleLock {
    @NotNull
    public final Runnable b;
    @NotNull
    public final Function1<InterruptedException, Unit> c;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.InterruptedException, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(@NotNull Lock lock, @NotNull Runnable runnable, @NotNull Function1<? super InterruptedException, Unit> function1) {
        super(lock);
        Intrinsics.checkNotNullParameter(lock, "lock");
        Intrinsics.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics.checkNotNullParameter(function1, "interruptedExceptionHandler");
        this.b = runnable;
        this.c = function1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.DefaultSimpleLock, kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        while (!getLock().tryLock(50, TimeUnit.MILLISECONDS)) {
            try {
                this.b.run();
            } catch (InterruptedException e) {
                this.c.invoke(e);
                return;
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CancellableSimpleLock(@NotNull Runnable runnable, @NotNull Function1<? super InterruptedException, Unit> function1) {
        this(new ReentrantLock(), runnable, function1);
        Intrinsics.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics.checkNotNullParameter(function1, "interruptedExceptionHandler");
    }
}
