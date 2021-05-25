package s6.a.e.c;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.Future;
/* compiled from: Disposable */
public final /* synthetic */ class b {
    @NonNull
    public static Disposable a() {
        return c(Functions.EMPTY_RUNNABLE);
    }

    @NonNull
    public static Disposable b(@NonNull Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return new c(future, true);
    }

    @NonNull
    public static Disposable c(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new e(runnable);
    }
}
