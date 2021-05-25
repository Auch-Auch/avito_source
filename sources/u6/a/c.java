package u6.a;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.EventLoop;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class c<T> extends AbstractCoroutine<T> {
    public final Thread c;
    public final EventLoop d;

    public c(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable EventLoop eventLoop) {
        super(coroutineContext, true);
        this.c = thread;
        this.d = eventLoop;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        if (!Intrinsics.areEqual(Thread.currentThread(), this.c)) {
            LockSupport.unpark(this.c);
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean isScopedCoroutine() {
        return true;
    }
}
