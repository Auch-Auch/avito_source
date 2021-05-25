package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class Constant extends JavaDefaultValue {
    @NotNull
    public final Object a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Constant(@NotNull Object obj) {
        super(null);
        Intrinsics.checkNotNullParameter(obj, "value");
        this.a = obj;
    }
}
