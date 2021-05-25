package t6.y;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class j extends i {
    @NotNull
    public static final StringBuilder append(@NotNull StringBuilder sb, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(sb, "$this$append");
        Intrinsics.checkNotNullParameter(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    @NotNull
    public static final StringBuilder append(@NotNull StringBuilder sb, @NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(sb, "$this$append");
        Intrinsics.checkNotNullParameter(objArr, "value");
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }
}
