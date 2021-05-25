package t6.y;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class q {
    @JvmField
    @NotNull
    public static final String a;

    static {
        String property = System.getProperty("line.separator");
        Intrinsics.checkNotNull(property);
        a = property;
    }
}
