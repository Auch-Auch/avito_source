package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\b¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\bH\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000e\u001a\u00020\bH\b¢\u0006\u0004\b\u0011\u0010\u0010\u001aL\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\b\b\u0000\u0010\u0000*\u00020\u0012*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010\u0015\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0002\b\u0014H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"T", "", "second", "(Ljava/util/List;)Ljava/lang/Object;", "", "isNotNullAndNotEmpty", "(Ljava/util/List;)Z", "", "", "i", "j", "", "swap", "(Ljava/util/List;II)V", VKApiConst.POSITION, "previousTo", "(Ljava/util/List;I)Ljava/lang/Object;", "nextTo", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "changes", "change", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
@JvmName(name = "ListUtils")
public final class ListUtils {
    @NotNull
    public static final <T> List<T> change(@NotNull List<? extends T> list, @NotNull Function1<? super List<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$change");
        Intrinsics.checkNotNullParameter(function1, "changes");
        List<T> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        function1.invoke(mutableList);
        return mutableList;
    }

    public static final <T> boolean isNotNullAndNotEmpty(@Nullable List<? extends T> list) {
        return !Collections.isNullOrEmpty(list);
    }

    @Nullable
    public static final <T> T nextTo(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$nextTo");
        return (T) CollectionsKt___CollectionsKt.getOrNull(list, i + 1);
    }

    @Nullable
    public static final <T> T previousTo(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$previousTo");
        return (T) CollectionsKt___CollectionsKt.getOrNull(list, i - 1);
    }

    public static final <T> T second(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$second");
        return (T) list.get(1);
    }

    public static final <T> void swap(@NotNull List<T> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "$this$swap");
        Collections.swap(list, i, i2);
    }
}
