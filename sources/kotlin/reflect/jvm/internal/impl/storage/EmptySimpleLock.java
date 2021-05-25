package kotlin.reflect.jvm.internal.impl.storage;

import org.jetbrains.annotations.NotNull;
public final class EmptySimpleLock implements SimpleLock {
    @NotNull
    public static final EmptySimpleLock INSTANCE = new EmptySimpleLock();

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void lock() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.SimpleLock
    public void unlock() {
    }
}
