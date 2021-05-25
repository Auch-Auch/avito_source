package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public interface SimpleLock {
    @NotNull
    public static final Companion Companion = Companion.a;

    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final DefaultSimpleLock simpleLock(@Nullable Runnable runnable, @Nullable Function1<? super InterruptedException, Unit> function1) {
            if (runnable == null || function1 == null) {
                return new DefaultSimpleLock(null, 1, null);
            }
            return new CancellableSimpleLock(runnable, function1);
        }
    }

    void lock();

    void unlock();
}
