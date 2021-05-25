package a2.a.a.k1.a.h;

import android.graphics.Path;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a {
    public final int a;
    @NotNull
    public final Path b;
    @NotNull
    public final Path c;

    public a(int i, @NotNull Path path, @NotNull Path path2) {
        Intrinsics.checkNotNullParameter(path, "leftPartPath");
        Intrinsics.checkNotNullParameter(path2, "rightPartPath");
        this.a = i;
        this.b = path;
        this.c = path2;
    }
}
