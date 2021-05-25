package t6.n;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.ExperimentalStdlibApi;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class q extends p {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <K, V> Map<K, V> build(@NotNull Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "builder");
        return ((MapBuilder) map).build();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <K, V> Map<K, V> createMapBuilder() {
        return new MapBuilder();
    }

    public static final <K, V> V getOrPut(@NotNull ConcurrentMap<K, V> concurrentMap, K k, @NotNull Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(concurrentMap, "$this$getOrPut");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V v2 = (V) function0.invoke();
        V putIfAbsent = concurrentMap.putIfAbsent(k, v2);
        return putIfAbsent != null ? putIfAbsent : v2;
    }

    @PublishedApi
    public static final int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static final <K, V> Map<K, V> mapOf(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        TreeMap treeMap = new TreeMap();
        r.putAll(treeMap, pairArr);
        return treeMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> toSingletonMap(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <K, V> Map<K, V> createMapBuilder(int i) {
        return new MapBuilder(i);
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V> SortedMap<K, V> sortedMapOf(@NotNull Comparator<? super K> comparator, @NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        r.putAll(treeMap, pairArr);
        return treeMap;
    }

    @NotNull
    public static final <K, V> SortedMap<K, V> toSortedMap(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super K> comparator) {
        Intrinsics.checkNotNullParameter(map, "$this$toSortedMap");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
