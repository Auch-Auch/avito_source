package t6;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SafePublicationLazyImpl;
import kotlin.UnsafeLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class c {
    @NotNull
    public static final <T> Lazy<T> lazy(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new m(function0, null);
    }

    @NotNull
    public static final <T> Lazy<T> lazy(@NotNull LazyThreadSafetyMode lazyThreadSafetyMode, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        int ordinal = lazyThreadSafetyMode.ordinal();
        if (ordinal == 0) {
            return new m(function0, null);
        }
        if (ordinal == 1) {
            return new SafePublicationLazyImpl(function0);
        }
        if (ordinal == 2) {
            return new UnsafeLazyImpl(function0);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final <T> Lazy<T> lazy(@Nullable Object obj, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new m(function0, obj);
    }
}
