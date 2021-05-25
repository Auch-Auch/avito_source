package com.avito.android.util;

import androidx.exifinterface.media.ExifInterface;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a6\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\b¢\u0006\u0004\b\n\u0010\u000b\u001a1\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0010\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u000f\u001aM\u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a7\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a7\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001b\u001aI\u0010\u001f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u0013H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\b!\u0010\"\u001a\"\u0010#\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\b¢\u0006\u0004\b#\u0010\"\u001a=\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u0006\u0012\u0002\b\u00030$2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050%H\bø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, d2 = {"T", "", "Ljava/util/ArrayList;", "asArrayList", "(Ljava/util/Collection;)Ljava/util/ArrayList;", "", "isNullOrEmpty", "(Ljava/util/Collection;)Z", "", "fallback", "ifNullOrEmpty", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "item", "isCircular", "getNextItem", "(Ljava/util/Collection;Ljava/lang/Object;Z)Ljava/lang/Object;", "getPreviousItem", ExifInterface.LATITUDE_SOUTH, "collection", "Lkotlin/Function2;", "comparator", "containsEqualElements", "(Ljava/util/Collection;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Z", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "filterKeysNotNull", "(Ljava/util/Map;)Ljava/util/Map;", "filterValuesNotNull", "", "predicate", "removeAll", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Z", "findInstanceOf", "(Ljava/util/Collection;)Ljava/lang/Object;", "findLastInstanceOf", "", "Lkotlin/Function1;", "filterIsInstance", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Collections")
public final class Collections {
    @Nullable
    public static final <T> ArrayList<T> asArrayList(@Nullable Collection<? extends T> collection) {
        if (collection == null) {
            return null;
        }
        if (collection instanceof ArrayList) {
            return (ArrayList) collection;
        }
        return new ArrayList<>(collection);
    }

    public static final <T, S> boolean containsEqualElements(@NotNull Collection<? extends T> collection, @Nullable Collection<? extends S> collection2, @NotNull Function2<? super T, ? super S, Boolean> function2) {
        T t;
        Intrinsics.checkNotNullParameter(collection, "$this$containsEqualElements");
        Intrinsics.checkNotNullParameter(function2, "comparator");
        if (collection == collection2) {
            return true;
        }
        if (collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        for (T t2 : collection) {
            Iterator<T> it = collection2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    continue;
                    break;
                }
                t = it.next();
                if (function2.invoke(t2, t).booleanValue()) {
                    continue;
                    break;
                }
            }
            if (t == null) {
                return false;
            }
        }
        return true;
    }

    public static final /* synthetic */ <T> List<T> filterIsInstance(Iterable<?> iterable, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterIsInstance");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if ((obj instanceof Object) && function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> filterKeysNotNull(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$filterKeysNotNull");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> filterValuesNotNull(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$filterValuesNotNull");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            K key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }

    public static final /* synthetic */ <T> T findInstanceOf(Collection<?> collection) {
        T t;
        Intrinsics.checkNotNullParameter(collection, "$this$findInstanceOf");
        Iterator<T> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Intrinsics.reifiedOperationMarker(3, "T");
            if (t instanceof Object) {
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return t;
    }

    public static final /* synthetic */ <T> T findLastInstanceOf(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$findLastInstanceOf");
        T t = null;
        for (T t2 : collection) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (t2 instanceof Object) {
                t = t2;
            }
        }
        Intrinsics.reifiedOperationMarker(1, "T?");
        return t;
    }

    @Nullable
    public static final <T> T getNextItem(@NotNull Collection<? extends T> collection, T t, boolean z) {
        int indexOf;
        Intrinsics.checkNotNullParameter(collection, "$this$getNextItem");
        if (collection.isEmpty() || (indexOf = CollectionsKt___CollectionsKt.indexOf(collection, t)) < 0) {
            return null;
        }
        int i = indexOf + 1;
        if (i < collection.size()) {
            return (T) CollectionsKt___CollectionsKt.elementAt(collection, i);
        }
        if (z) {
            return (T) CollectionsKt___CollectionsKt.first(collection);
        }
        return null;
    }

    public static /* synthetic */ Object getNextItem$default(Collection collection, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = true;
        }
        return getNextItem(collection, obj, z);
    }

    @Nullable
    public static final <T> T getPreviousItem(@NotNull Collection<? extends T> collection, T t, boolean z) {
        int indexOf;
        Intrinsics.checkNotNullParameter(collection, "$this$getPreviousItem");
        if (collection.isEmpty() || (indexOf = CollectionsKt___CollectionsKt.indexOf(collection, t)) < 0) {
            return null;
        }
        int i = indexOf - 1;
        if (i >= 0) {
            return (T) CollectionsKt___CollectionsKt.elementAt(collection, i);
        }
        if (z) {
            return (T) CollectionsKt___CollectionsKt.last(collection);
        }
        return null;
    }

    public static /* synthetic */ Object getPreviousItem$default(Collection collection, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            z = true;
        }
        return getPreviousItem(collection, obj, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends T> */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> ifNullOrEmpty(@Nullable List<? extends T> list, @NotNull List<? extends T> list2) {
        Intrinsics.checkNotNullParameter(list2, "fallback");
        return (list == 0 || list.isEmpty()) ? list2 : list;
    }

    public static final <T> boolean isNullOrEmpty(@Nullable Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static final <K, V> boolean removeAll(@NotNull Map<K, V> map, @NotNull Function2<? super K, ? super V, Boolean> function2) {
        Intrinsics.checkNotNullParameter(map, "$this$removeAll");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (function2.invoke(next.getKey(), next.getValue()).booleanValue()) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
