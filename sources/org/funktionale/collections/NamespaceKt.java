package org.funktionale.collections;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "", "tail", "(Ljava/util/List;)Ljava/util/List;", "list", "prependTo", "(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;", "Lkotlin/Pair;", "destructured", "(Ljava/util/List;)Lkotlin/Pair;", "funktionale-collections"}, k = 2, mv = {1, 4, 0})
public final class NamespaceKt {
    @NotNull
    public static final <T> Pair<T, List<T>> destructured(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return TuplesKt.to(CollectionsKt___CollectionsKt.first((List<? extends Object>) list), tail(list));
    }

    @NotNull
    public static final <T> List<T> prependTo(T t, @NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        return CollectionsKt___CollectionsKt.plus((Collection) d.listOf(t), (Iterable) list);
    }

    @NotNull
    public static final <T> List<T> tail(@NotNull List<? extends T> list) {
        Intrinsics.checkParameterIsNotNull(list, "$receiver");
        return CollectionsKt___CollectionsKt.drop(list, 1);
    }
}
