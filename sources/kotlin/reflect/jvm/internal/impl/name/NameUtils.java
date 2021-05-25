package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
public final class NameUtils {
    @NotNull
    public static final NameUtils INSTANCE = new NameUtils();
    @NotNull
    public static final Regex a = new Regex("[^\\p{L}\\p{Digit}]");

    @JvmStatic
    @NotNull
    public static final String sanitizeAsJavaIdentifier(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return a.replace(str, "_");
    }
}
