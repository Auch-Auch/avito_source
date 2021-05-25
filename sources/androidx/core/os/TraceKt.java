package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "", "sectionName", "Lkotlin/Function0;", "block", "trace", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class TraceKt {
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(str, "sectionName");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        TraceCompat.beginSection(str);
        int i = 1;
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(i);
            TraceCompat.endSection();
            InlineMarker.finallyEnd(i);
        }
    }
}
