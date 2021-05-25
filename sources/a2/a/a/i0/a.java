package a2.a.a.i0;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a extends RuntimeException {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "message");
    }
}
