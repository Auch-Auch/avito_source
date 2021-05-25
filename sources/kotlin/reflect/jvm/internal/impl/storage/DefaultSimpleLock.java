package kotlin.reflect.jvm.internal.impl.storage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public class DefaultSimpleLock implements SimpleLock {
    @NotNull
    public final Lock a;

    public DefaultSimpleLock() {
        this(null, 1, null);
    }

    public DefaultSimpleLock(@NotNull Lock lock) {
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.a = lock;
    }

    @NotNull
    public final Lock getLock() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
        this.a.lock();
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
        this.a.unlock();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultSimpleLock(Lock lock, int i, j jVar) {
        this((i & 1) != 0 ? new ReentrantLock() : lock);
    }
}
