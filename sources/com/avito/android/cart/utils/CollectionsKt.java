package com.avito.android.cart.utils;

import androidx.collection.SimpleArrayMap;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aI\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001ac\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"T", "K", "", "Lkotlin/Function1;", "keySelector", "Landroidx/collection/SimpleArrayMap;", "associateBy", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Landroidx/collection/SimpleArrayMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "valueSelector", "associate", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/collection/SimpleArrayMap;", "cart_release"}, k = 2, mv = {1, 4, 2})
public final class CollectionsKt {
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.collection.SimpleArrayMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> SimpleArrayMap<K, V> associate(@NotNull Collection<? extends T> collection, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(collection, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueSelector");
        SimpleArrayMap<K, V> simpleArrayMap = (SimpleArrayMap<K, V>) new SimpleArrayMap(collection.size());
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            simpleArrayMap.put(function1.invoke(obj), function12.invoke(obj));
        }
        return simpleArrayMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: androidx.collection.SimpleArrayMap<K, T> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: ? super T */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K> SimpleArrayMap<K, T> associateBy(@NotNull Collection<? extends T> collection, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(collection, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        SimpleArrayMap<K, T> simpleArrayMap = (SimpleArrayMap<K, T>) new SimpleArrayMap(collection.size());
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            simpleArrayMap.put(function1.invoke(obj), obj);
        }
        return simpleArrayMap;
    }
}
