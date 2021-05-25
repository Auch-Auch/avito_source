package com.avito.android.util;

import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00028\u0002H\f¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lkotlin/Pair;", "c", "Lkotlin/Triple;", "tripleWith", "(Lkotlin/Pair;Ljava/lang/Object;)Lkotlin/Triple;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class TuplesKt {
    @NotNull
    public static final <A, B, C> Triple<A, B, C> tripleWith(@NotNull Pair<? extends A, ? extends B> pair, C c) {
        Intrinsics.checkNotNullParameter(pair, "$this$tripleWith");
        return new Triple<>(pair.getFirst(), pair.getSecond(), c);
    }
}
