package a2.a.a.i.g;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends Exception {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(@NotNull Throwable th) {
        super(th);
        Intrinsics.checkNotNullParameter(th, "e");
    }
}
