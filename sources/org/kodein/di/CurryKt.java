package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aF\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\b\u0004\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "Lkotlin/Function1;", "Lkotlin/Function0;", "arg", "toProvider", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Lkotlin/jvm/functions/Function0;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class CurryKt {
    @NotNull
    public static final <A, T> Function0<T> toProvider(@NotNull Function1<? super A, ? extends T> function1, @NotNull Function0<? extends A> function0) {
        Intrinsics.checkParameterIsNotNull(function1, "$this$toProvider");
        Intrinsics.checkParameterIsNotNull(function0, "arg");
        return new CurryKt$toProvider$1(function1, function0);
    }
}
