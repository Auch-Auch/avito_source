package a2.a.a.i.d;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class e {
    @NotNull
    public final Throwable a;
    @NotNull
    public final StackTraceElement b;

    public e(@NotNull Throwable th, @NotNull StackTraceElement stackTraceElement) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        Intrinsics.checkNotNullParameter(stackTraceElement, "topStackTraceElement");
        this.a = th;
        this.b = stackTraceElement;
    }
}
