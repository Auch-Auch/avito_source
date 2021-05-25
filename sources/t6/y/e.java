package t6.y;

import java.util.Objects;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class e {
    @NotNull
    public static final <T extends Appendable> T append(@NotNull T t, @NotNull CharSequence... charSequenceArr) {
        Intrinsics.checkNotNullParameter(t, "$this$append");
        Intrinsics.checkNotNullParameter(charSequenceArr, "value");
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    public static final <T> void appendElement(@NotNull Appendable appendable, T t, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(appendable, "$this$appendElement");
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append(t);
        } else if (t instanceof Character) {
            appendable.append(t.charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Appendable> T appendRange(@NotNull T t, @NotNull CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "$this$appendRange");
        Intrinsics.checkNotNullParameter(charSequence, "value");
        T t2 = (T) t.append(charSequence, i, i2);
        Objects.requireNonNull(t2, "null cannot be cast to non-null type T");
        return t2;
    }
}
