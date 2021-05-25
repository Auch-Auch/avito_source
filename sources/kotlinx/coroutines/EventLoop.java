package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlinx.coroutines.internal.ArrayQueue;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0019\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00058T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00028T@\u0014X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0004R\u0013\u0010\u001c\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0007R\u0016\u0010\u001f\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0013\u0010$\u001a\u00020\u00058F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010\u0007¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "processNextEvent", "()J", "", "processUnconfinedEvent", "()Z", "shouldBeProcessedFromContext", "Lkotlinx/coroutines/DispatchedTask;", "task", "", "dispatchUnconfined", "(Lkotlinx/coroutines/DispatchedTask;)V", "unconfined", "incrementUseCount", "(Z)V", "decrementUseCount", "shutdown", "()V", AuthSource.SEND_ABUSE, "(Z)J", "isUnconfinedQueueEmpty", "J", "useCount", "isEmpty", "getNextTime", "nextTime", "isActive", AuthSource.BOOKING_ORDER, "Z", "shared", "Lkotlinx/coroutines/internal/ArrayQueue;", "c", "Lkotlinx/coroutines/internal/ArrayQueue;", "unconfinedQueue", "isUnconfinedLoopActive", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public abstract class EventLoop extends CoroutineDispatcher {
    public long a;
    public boolean b;
    public ArrayQueue<DispatchedTask<?>> c;

    public static /* synthetic */ void decrementUseCount$default(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eventLoop.decrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    public static /* synthetic */ void incrementUseCount$default(EventLoop eventLoop, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            eventLoop.incrementUseCount(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final long a(boolean z) {
        return z ? 4294967296L : 1;
    }

    public final void decrementUseCount(boolean z) {
        long a3 = this.a - a(z);
        this.a = a3;
        if (a3 <= 0 && this.b) {
            shutdown();
        }
    }

    public final void dispatchUnconfined(@NotNull DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.c;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.c = arrayQueue;
        }
        arrayQueue.addLast(dispatchedTask);
    }

    public long getNextTime() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.c;
        if (arrayQueue == null || arrayQueue.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0;
    }

    public final void incrementUseCount(boolean z) {
        this.a = a(z) + this.a;
        if (!z) {
            this.b = true;
        }
    }

    public final boolean isActive() {
        return this.a > 0;
    }

    public boolean isEmpty() {
        return isUnconfinedQueueEmpty();
    }

    public final boolean isUnconfinedLoopActive() {
        return this.a >= a(true);
    }

    public final boolean isUnconfinedQueueEmpty() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.c;
        if (arrayQueue != null) {
            return arrayQueue.isEmpty();
        }
        return true;
    }

    public long processNextEvent() {
        return !processUnconfinedEvent() ? Long.MAX_VALUE : 0;
    }

    public final boolean processUnconfinedEvent() {
        DispatchedTask<?> removeFirstOrNull;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.c;
        if (arrayQueue == null || (removeFirstOrNull = arrayQueue.removeFirstOrNull()) == null) {
            return false;
        }
        removeFirstOrNull.run();
        return true;
    }

    public boolean shouldBeProcessedFromContext() {
        return false;
    }

    public void shutdown() {
    }
}
