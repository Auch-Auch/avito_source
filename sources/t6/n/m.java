package t6.n;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class m extends l {
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> aggregate(@NotNull Grouping<T, ? extends K> grouping, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(grouping, "$this$aggregate");
        Intrinsics.checkNotNullParameter(function4, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object obj = (Object) grouping.keyOf(next);
            Object obj2 = (Object) linkedHashMap.get(obj);
            linkedHashMap.put(obj, function4.invoke(obj, obj2, next, Boolean.valueOf(obj2 == 0 && !linkedHashMap.containsKey(obj))));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, R> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(grouping, "$this$aggregateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function4, "operation");
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object obj = (Object) grouping.keyOf(next);
            Object obj2 = (Object) m.get(obj);
            m.put(obj, function4.invoke(obj, obj2, next, Boolean.valueOf(obj2 == 0 && !m.containsKey(obj))));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: M extends java.util.Map<? super K, java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m) {
        Intrinsics.checkNotNullParameter(grouping, "$this$eachCountTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            Object keyOf = grouping.keyOf(sourceIterator.next());
            Object obj = m.get(keyOf);
            if (obj == null && !m.containsKey(keyOf)) {
                obj = 0;
            }
            m.put(keyOf, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> fold(@NotNull Grouping<T, ? extends K> grouping, @NotNull Function2<? super K, ? super T, ? extends R> function2, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(grouping, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "initialValueSelector");
        Intrinsics.checkNotNullParameter(function3, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object obj = (Object) grouping.keyOf(next);
            Object obj2 = (Object) linkedHashMap.get(obj);
            if (obj2 == null && !linkedHashMap.containsKey(obj)) {
                obj2 = (Object) function2.invoke(obj, next);
            }
            linkedHashMap.put(obj, function3.invoke(obj, obj2, next));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, R> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m, @NotNull Function2<? super K, ? super T, ? extends R> function2, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(grouping, "$this$foldTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function2, "initialValueSelector");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object obj = (Object) grouping.keyOf(next);
            Object obj2 = (Object) m.get(obj);
            if (obj2 == null && !m.containsKey(obj)) {
                obj2 = (Object) function2.invoke(obj, next);
            }
            m.put(obj, function3.invoke(obj, obj2, next));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.collections.Grouping<T extends S, ? extends K> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K> Map<K, S> reduce(@NotNull Grouping<T, ? extends K> grouping, @NotNull Function3<? super K, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(grouping, "$this$reduce");
        Intrinsics.checkNotNullParameter(function3, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            Object obj = (Object) sourceIterator.next();
            Object obj2 = (Object) grouping.keyOf(obj);
            Object obj3 = (Object) linkedHashMap.get(obj2);
            if (!(obj3 == 0 && !linkedHashMap.containsKey(obj2))) {
                obj = (Object) function3.invoke(obj2, obj3, obj);
            }
            linkedHashMap.put(obj2, obj);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.collections.Grouping<T extends S, ? extends K> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, S> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m, @NotNull Function3<? super K, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(grouping, "$this$reduceTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            Object obj = (Object) sourceIterator.next();
            Object obj2 = (Object) grouping.keyOf(obj);
            Object obj3 = (Object) m.get(obj2);
            if (!(obj3 == 0 && !m.containsKey(obj2))) {
                obj = (Object) function3.invoke(obj2, obj3, obj);
            }
            m.put(obj2, obj);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, R> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull Grouping<T, ? extends K> grouping, @NotNull M m, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(grouping, "$this$foldTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object keyOf = grouping.keyOf(next);
            R r2 = (Object) m.get(keyOf);
            if (r2 == null && !m.containsKey(keyOf)) {
                r2 = r;
            }
            m.put(keyOf, function2.invoke(r2, next));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K, R> Map<K, R> fold(@NotNull Grouping<T, ? extends K> grouping, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(grouping, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> sourceIterator = grouping.sourceIterator();
        while (sourceIterator.hasNext()) {
            T next = sourceIterator.next();
            Object keyOf = grouping.keyOf(next);
            R r2 = (Object) linkedHashMap.get(keyOf);
            if (r2 == null && !linkedHashMap.containsKey(keyOf)) {
                r2 = r;
            }
            linkedHashMap.put(keyOf, function2.invoke(r2, next));
        }
        return linkedHashMap;
    }
}
