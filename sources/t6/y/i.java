package t6.y;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class i extends h {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    public static final Appendable appendln(@NotNull Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "$this$appendln");
        Appendable append = appendable.append(q.a);
        Intrinsics.checkNotNullExpressionValue(append, "append(SystemProperties.LINE_SEPARATOR)");
        return append;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final StringBuilder clear(@NotNull StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "$this$clear");
        sb.setLength(0);
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @NotNull
    public static final StringBuilder appendln(@NotNull StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "$this$appendln");
        sb.append(q.a);
        Intrinsics.checkNotNullExpressionValue(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }
}
