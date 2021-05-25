package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a4\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0005\u001aH\u0010\b\u001a\u001e\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00008\u0000\u0012\f\u0012\n \u0003*\u0004\u0018\u00018\u00018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\b¢\u0006\u0004\b\b\u0010\t\u001a8\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"F", ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "kotlin.jvm.PlatformType", "component1", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "Lkotlin/Pair;", "toKotlinPair", "(Landroid/util/Pair;)Lkotlin/Pair;", "toAndroidPair", "(Lkotlin/Pair;)Landroid/util/Pair;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@NotNull Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$component1");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@NotNull Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$component2");
        return (S) pair.second;
    }

    @NotNull
    public static final <F, S> Pair<F, S> toAndroidPair(@NotNull kotlin.Pair<? extends F, ? extends S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$toAndroidPair");
        return new Pair<>(pair.getFirst(), pair.getSecond());
    }

    @NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@NotNull Pair<F, S> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "$this$toKotlinPair");
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
