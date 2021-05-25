package a2.a.a.v0;

import com.avito.android.fps.FpsAccumulator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a {
    @NotNull
    public final String a;
    @NotNull
    public final FpsAccumulator b;
    public final long c;

    public a(@NotNull String str, @NotNull FpsAccumulator fpsAccumulator, long j) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(fpsAccumulator, "fpsAccumulator");
        this.a = str;
        this.b = fpsAccumulator;
        this.c = j;
    }
}
