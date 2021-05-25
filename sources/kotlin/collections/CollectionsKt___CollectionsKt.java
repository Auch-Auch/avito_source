package kotlin.collections;

import com.avito.android.lib.design.input.FormatterType;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareBy$2;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt$compareByDescending$1;
import kotlin.internal.HidesMembers;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.g;
import t6.n.h;
import t6.n.j;
import t6.n.q;
import t6.n.x;
import t6.n.y;
import t6.v.e;
public class CollectionsKt___CollectionsKt extends j {

    public static final class a extends Lambda implements Function1<Integer, T> {
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(1);
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Integer num) {
            num.intValue();
            throw new IndexOutOfBoundsException(a2.b.a.a.a.i(a2.b.a.a.a.L("Collection doesn't contain element at index "), this.a, FormatterType.defaultDecimalSeparator));
        }
    }

    public static final class b extends Lambda implements Function0<Iterator<? extends T>> {
        public final /* synthetic */ Iterable a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Iterable iterable) {
            super(0);
            this.a = iterable;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return this.a.iterator();
        }
    }

    public static final <T> boolean all(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$any");
        if (iterable instanceof Collection) {
            return !((Collection) iterable).isEmpty();
        }
        return iterable.iterator().hasNext();
    }

    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$asSequence");
        return new Sequence<T>(iterable) { // from class: kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1
            public final /* synthetic */ Iterable a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return this.a.iterator();
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it.next());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            linkedHashMap.put(function1.invoke(obj), obj);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            m.put(function1.invoke(obj), obj);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) function1.invoke((Object) it.next());
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull Iterable<? extends K> iterable, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateWith");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends K> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            linkedHashMap.put(obj, function1.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull Iterable<? extends K> iterable, @NotNull M m, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        Iterator<? extends K> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            m.put(obj, function1.invoke(obj));
        }
        return m;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(@NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Byte b2 : iterable) {
            d += (double) b2.byteValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Double d2 : iterable) {
            d += d2.doubleValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Float f : iterable) {
            d += (double) f.floatValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Integer num : iterable) {
            d += (double) num.intValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(@NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Long l : iterable) {
            d += (double) l.longValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(@NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$average");
        double d = 0.0d;
        int i = 0;
        for (Short sh : iterable) {
            d += (double) sh.shortValue();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        if (i == 0) {
            return Double.NaN;
        }
        return d / ((double) i);
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<List<T>> chunked(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "$this$chunked");
        return windowed(iterable, i, i, true);
    }

    public static final <T> boolean contains(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return indexOf(iterable, t) >= 0;
    }

    public static final <T> int count(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$count");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        int i = 0;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i;
    }

    @NotNull
    public static final <T> List<T> distinct(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$distinct");
        return toList(toMutableSet(iterable));
    }

    @NotNull
    public static final <T, K> List<T> distinctBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (hashSet.add(function1.invoke(obj))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> drop(@NotNull Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(iterable, "$this$drop");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return toList(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                if (size == 1) {
                    return d.listOf(last(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object obj : iterable) {
                if (i2 >= i) {
                    arrayList.add(obj);
                } else {
                    i2++;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
    }

    @NotNull
    public static final <T> List<T> dropLast(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$dropLast");
        if (i >= 0) {
            return take(list, e.coerceAtLeast(list.size() - i, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> dropLastWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (!function1.invoke((Object) listIterator.previous()).booleanValue()) {
                    return take(list, listIterator.nextIndex() + 1);
                }
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <T> List<T> dropWhile(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (z) {
                arrayList.add(obj);
            } else if (!function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
                z = true;
            }
        }
        return arrayList;
    }

    public static final <T> T elementAt(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "$this$elementAt");
        return iterable instanceof List ? (T) ((List) iterable).get(i) : (T) elementAtOrElse(iterable, i, new a(i));
    }

    public static final <T> T elementAtOrElse(@NotNull Iterable<? extends T> iterable, int i, @NotNull Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$elementAtOrElse");
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(list)) ? (T) function1.invoke(Integer.valueOf(i)) : (T) list.get(i);
        } else if (i < 0) {
            return (T) function1.invoke(Integer.valueOf(i));
        } else {
            int i2 = 0;
            for (T t : iterable) {
                int i3 = i2 + 1;
                if (i == i2) {
                    return t;
                }
                i2 = i3;
            }
            return (T) function1.invoke(Integer.valueOf(i));
        }
    }

    @Nullable
    public static final <T> T elementAtOrNull(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "$this$elementAtOrNull");
        if (iterable instanceof List) {
            return (T) getOrNull((List) iterable, i);
        }
        if (i < 0) {
            return null;
        }
        int i2 = 0;
        for (T t : iterable) {
            int i3 = i2 + 1;
            if (i == i2) {
                return t;
            }
            i2 = i3;
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> filter(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function2.invoke(Integer.valueOf(i), obj).booleanValue()) {
                arrayList.add(obj);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function2.invoke(Integer.valueOf(i), obj).booleanValue()) {
                c.add(obj);
            }
            i = i2;
        }
        return c;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Iterable<?> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterIsInstance");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Iterable<?> iterable, C c) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterIsInstanceTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object obj : iterable) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static final <T> List<T> filterNot(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (!function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNotNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterNotNull");
        return (List) filterNotNullTo(iterable, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterNotNullTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (!function1.invoke(obj).booleanValue()) {
                c.add(obj);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (function1.invoke(obj).booleanValue()) {
                c.add(obj);
            }
        }
        return c;
    }

    public static final <T> T first(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) first((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$firstOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return (T) it.next();
    }

    @NotNull
    public static final <T, R> List<R> flatMap(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            h.addAll(arrayList, (Iterable) function1.invoke((Object) it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> List<R> flatMapSequence(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            h.addAll(arrayList, (Sequence) function1.invoke((Object) it.next()));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            h.addAll(c, (Sequence) function1.invoke((Object) it.next()));
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            h.addAll(c, (Iterable) function1.invoke((Object) it.next()));
        }
        return c;
    }

    public static final <T, R> R fold(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            r = (R) function2.invoke(r, (Object) it.next());
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            r = (R) function3.invoke(Integer.valueOf(i), r, obj);
            i = i2;
        }
        return r;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x0027 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: ? super R */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRight(@NotNull List<? extends T> list, R r, @NotNull Function2<? super T, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(list, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            r = r;
            while (listIterator.hasPrevious()) {
                r = (Object) function2.invoke((Object) listIterator.previous(), r);
            }
        }
        return r;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:7:0x002f */
    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: ? super R */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRightIndexed(@NotNull List<? extends T> list, R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(list, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        if (!list.isEmpty()) {
            ListIterator<? extends T> listIterator = list.listIterator(list.size());
            r = r;
            while (listIterator.hasPrevious()) {
                r = (Object) function3.invoke(Integer.valueOf(listIterator.previousIndex()), (Object) listIterator.previous(), r);
            }
        }
        return r;
    }

    @HidesMembers
    public static final <T> void forEach(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            function1.invoke((Object) it.next());
        }
    }

    public static final <T> void forEachIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            function2.invoke(Integer.valueOf(i), obj);
            i = i2;
        }
    }

    @Nullable
    public static final <T> T getOrNull(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$getOrNull");
        if (i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(list)) {
            return null;
        }
        return (T) list.get(i);
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = linkedHashMap.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj2).add(obj);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = m.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj2).add(obj);
        }
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$groupingBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        return new Grouping<T, K>(iterable, function1) { // from class: kotlin.collections.CollectionsKt___CollectionsKt$groupingBy$1
            public final /* synthetic */ Iterable a;
            public final /* synthetic */ Function1 b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // kotlin.collections.Grouping
            public K keyOf(T t) {
                return (K) this.b.invoke(t);
            }

            @Override // kotlin.collections.Grouping
            @NotNull
            public Iterator<T> sourceIterator() {
                return this.a.iterator();
            }
        };
    }

    public static final <T> int indexOf(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (Object obj : iterable) {
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function1.invoke(obj).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = iterable.iterator();
        int i = -1;
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            if (function1.invoke(obj).booleanValue()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @NotNull
    public static final <T> Set<T> intersect(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        h.retainAll(mutableSet, iterable2);
        return mutableSet;
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull Iterable<? extends T> iterable, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                a3.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            t6.y.e.appendElement(a3, obj, function1);
        }
        if (i >= 0 && i2 > i) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static /* synthetic */ Appendable joinTo$default(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        String str = (i2 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(iterable, appendable, str, charSequence6, charSequence5, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : charSequence4, (i2 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull Iterable<? extends T> iterable, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i2 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i2 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i2 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iterable, charSequence, charSequence6, charSequence5, i3, charSequence4, function1);
    }

    public static final <T> T last(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$last");
        if (iterable instanceof List) {
            return (T) last((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            while (it.hasNext()) {
                t = (T) it.next();
            }
            return t;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> int lastIndexOf(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "$this$lastIndexOf");
        if (iterable instanceof List) {
            return ((List) iterable).lastIndexOf(t);
        }
        int i = -1;
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(t, obj)) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$lastOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        while (it.hasNext()) {
            t = (T) it.next();
        }
        return t;
    }

    @NotNull
    public static final <T, R> List<R> map(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke((Object) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            arrayList.add(function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexedNotNull(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapIndexedNotNull");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object invoke = function2.invoke(Integer.valueOf(i), obj);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i = i2;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapIndexedNotNullTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            Object invoke = function2.invoke(Integer.valueOf(i), obj);
            if (invoke != null) {
                c.add(invoke);
            }
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            c.add(function2.invoke(Integer.valueOf(i), obj));
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T, R> List<R> mapNotNull(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object invoke = function1.invoke((Object) it.next());
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object invoke = function1.invoke((Object) it.next());
            if (invoke != null) {
                c.add(invoke);
            }
        }
        return c;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull Iterable<? extends T> iterable, @NotNull C c, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(function1.invoke((Object) it.next()));
        }
        return c;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max  reason: collision with other method in class */
    public static final Double m355max(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$max");
        return m357maxOrNull(iterable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (Object) it.next();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) function1.invoke(obj);
            do {
                Object obj2 = (Object) it.next();
                Comparable comparable2 = (Comparable) function1.invoke(obj2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo < 0) {
                    obj = (Object) obj2;
                    comparable3 = comparable2;
                }
                comparable = comparable3;
            } while (it.hasNext());
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R extends java.lang.Comparable<? super R>> T maxByOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends R> r6) {
        /*
            java.lang.String r0 = "$this$maxByOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Iterator r5 = r5.iterator()
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x0016
            r5 = 0
            return r5
        L_0x0016:
            java.lang.Object r0 = r5.next()
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.Object r1 = r6.invoke(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
        L_0x0027:
            java.lang.Object r2 = r5.next()
            java.lang.Object r3 = r6.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r4 = r1.compareTo(r3)
            if (r4 >= 0) goto L_0x0039
            r0 = r2
            r1 = r3
        L_0x0039:
            boolean r2 = r5.hasNext()
            if (r2 != 0) goto L_0x0027
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.maxByOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull  reason: collision with other method in class */
    public static final Double m357maxOrNull(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T> T maxWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) maxWithOrNull(iterable, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T maxWithOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r3, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> r4) {
        /*
            java.lang.String r0 = "$this$maxWithOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "comparator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0016
            r3 = 0
            return r3
        L_0x0016:
            java.lang.Object r0 = r3.next()
        L_0x001a:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r3.next()
            int r2 = r4.compare(r0, r1)
            if (r2 >= 0) goto L_0x001a
            r0 = r1
            goto L_0x001a
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.maxWithOrNull(java.lang.Iterable, java.util.Comparator):java.lang.Object");
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min  reason: collision with other method in class */
    public static final Double m359min(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$min");
        return m361minOrNull(iterable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T minBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (Object) it.next();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) function1.invoke(obj);
            do {
                Object obj2 = (Object) it.next();
                Comparable comparable2 = (Comparable) function1.invoke(obj2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo > 0) {
                    obj = (Object) obj2;
                    comparable3 = comparable2;
                }
                comparable = comparable3;
            } while (it.hasNext());
        }
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Comparable] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R extends java.lang.Comparable<? super R>> T minByOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends R> r6) {
        /*
            java.lang.String r0 = "$this$minByOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Iterator r5 = r5.iterator()
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x0016
            r5 = 0
            return r5
        L_0x0016:
            java.lang.Object r0 = r5.next()
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x0021
            return r0
        L_0x0021:
            java.lang.Object r1 = r6.invoke(r0)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
        L_0x0027:
            java.lang.Object r2 = r5.next()
            java.lang.Object r3 = r6.invoke(r2)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r4 = r1.compareTo(r3)
            if (r4 <= 0) goto L_0x0039
            r0 = r2
            r1 = r3
        L_0x0039:
            boolean r2 = r5.hasNext()
            if (r2 != 0) goto L_0x0027
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.minByOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull  reason: collision with other method in class */
    public static final Double m361minOrNull(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minOrNull");
        Iterator<Double> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = it.next().doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, it.next().doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T> T minWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) minWithOrNull(iterable, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T minWithOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r3, @org.jetbrains.annotations.NotNull java.util.Comparator<? super T> r4) {
        /*
            java.lang.String r0 = "$this$minWithOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "comparator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0016
            r3 = 0
            return r3
        L_0x0016:
            java.lang.Object r0 = r3.next()
        L_0x001a:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r3.next()
            int r2 = r4.compare(r0, r1)
            if (r2 <= 0) goto L_0x001a
            r0 = r1
            goto L_0x001a
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.minWithOrNull(java.lang.Iterable, java.util.Comparator):java.lang.Object");
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minus");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        boolean z = false;
        for (Object obj : iterable) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual(obj, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> boolean none(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$none");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, C extends Iterable<? extends T>> C onEach(@NotNull C c, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(c, "$this$onEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<T> it = c.iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
        return c;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, C extends Iterable<? extends T>> C onEachIndexed(@NotNull C c, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(c, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i = 0;
        for (T t : c) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            function2.invoke(Integer.valueOf(i), t);
            i = i2;
        }
        return c;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "$this$plus");
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object) t);
        }
        ArrayList arrayList = new ArrayList();
        h.addAll(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T random(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(collection, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!collection.isEmpty()) {
            return (T) elementAt(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T randomOrNull(@NotNull Collection<? extends T> collection, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(collection, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (collection.isEmpty()) {
            return null;
        }
        return (T) elementAt(collection, random.nextInt(collection.size()));
    }

    public static final <S, T extends S> S reduce(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            S s = (S) it.next();
            while (it.hasNext()) {
                s = (S) function2.invoke(s, (Object) it.next());
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            S s = (S) it.next();
            int i = 1;
            while (it.hasNext()) {
                int i2 = i + 1;
                if (i < 0) {
                    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    } else {
                        throw new ArithmeticException("Index overflow has happened.");
                    }
                }
                s = (S) function3.invoke(Integer.valueOf(i), s, (Object) it.next());
                i = i2;
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceIndexedOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S s = (S) it.next();
        int i = 1;
        while (it.hasNext()) {
            int i2 = i + 1;
            if (i < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                } else {
                    throw new ArithmeticException("Index overflow has happened.");
                }
            }
            s = (S) function3.invoke(Integer.valueOf(i), s, (Object) it.next());
            i = i2;
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceOrNull(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        S s = (S) it.next();
        while (it.hasNext()) {
            s = (S) function2.invoke(s, (Object) it.next());
        }
        return s;
    }

    public static final <S, T extends S> S reduceRight(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(list, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S s = (S) listIterator.previous();
            while (listIterator.hasPrevious()) {
                s = (S) function2.invoke((Object) listIterator.previous(), s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(list, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (listIterator.hasPrevious()) {
            S s = (S) listIterator.previous();
            while (listIterator.hasPrevious()) {
                s = (S) function3.invoke(Integer.valueOf(listIterator.previousIndex()), (Object) listIterator.previous(), s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty list can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceRightIndexedOrNull(@NotNull List<? extends T> list, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(list, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S s = (S) listIterator.previous();
        while (listIterator.hasPrevious()) {
            s = (S) function3.invoke(Integer.valueOf(listIterator.previousIndex()), (Object) listIterator.previous(), s);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceRightOrNull(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(list, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        if (!listIterator.hasPrevious()) {
            return null;
        }
        S s = (S) listIterator.previous();
        while (listIterator.hasPrevious()) {
            s = (S) function2.invoke((Object) listIterator.previous(), s);
        }
        return s;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Iterable<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Iterable<T> requireNoNulls(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$requireNoNulls");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + iterable + FormatterType.defaultDecimalSeparator);
            }
        }
        return iterable;
    }

    @NotNull
    public static final <T> List<T> reversed(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$reversed");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        j.reverse(mutableList);
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFold(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$runningFold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        Object obj = r;
        while (it.hasNext()) {
            Object obj2 = (Object) function2.invoke(obj, (Object) it.next());
            arrayList.add(obj2);
            obj = obj2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFoldIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        int i = 0;
        Iterator<? extends T> it = iterable.iterator();
        Object obj = r;
        while (it.hasNext()) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            Object obj2 = (Object) function3.invoke(valueOf, obj, (Object) it.next());
            arrayList.add(obj2);
            obj = obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> List<S> runningReduce(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Object obj = (Object) it.next();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        arrayList.add(obj);
        while (it.hasNext()) {
            obj = (Object) function2.invoke(obj, (Object) it.next());
            arrayList.add(obj);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S, T extends S> List<S> runningReduceIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Object obj = (Object) it.next();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        arrayList.add(obj);
        int i = 1;
        while (it.hasNext()) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            obj = (Object) function3.invoke(valueOf, obj, (Object) it.next());
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> List<R> scan(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$scan");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        Iterator<? extends T> it = iterable.iterator();
        Object obj = r;
        while (it.hasNext()) {
            Object obj2 = (Object) function2.invoke(obj, (Object) it.next());
            arrayList.add(obj2);
            obj = obj2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super T */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> List<R> scanIndexed(@NotNull Iterable<? extends T> iterable, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 9);
        if (collectionSizeOrDefault == 0) {
            return d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault + 1);
        arrayList.add(r);
        int i = 0;
        Iterator<? extends T> it = iterable.iterator();
        Object obj = r;
        while (it.hasNext()) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            Object obj2 = (Object) function3.invoke(valueOf, obj, (Object) it.next());
            arrayList.add(obj2);
            obj = obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduce instead.", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final <S, T extends S> List<S> scanReduce(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$scanReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Object obj = (Object) it.next();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        arrayList.add(obj);
        while (it.hasNext()) {
            obj = (Object) function2.invoke(obj, (Object) it.next());
            arrayList.add(obj);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduceIndexed instead.", replaceWith = @ReplaceWith(expression = "runningReduceIndexed(operation)", imports = {}))
    public static final <S, T extends S> List<S> scanReduceIndexed(@NotNull Iterable<? extends T> iterable, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(iterable, "$this$scanReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        Object obj = (Object) it.next();
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(iterable, 10));
        arrayList.add(obj);
        int i = 1;
        while (it.hasNext()) {
            Integer valueOf = Integer.valueOf(i);
            i++;
            obj = (Object) function3.invoke(valueOf, obj, (Object) it.next());
            arrayList.add(obj);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void shuffle(@NotNull List<T> list, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(list, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            list.set(nextInt, list.set(lastIndex, list.get(nextInt)));
        }
    }

    public static final <T> T single(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) single((List<? extends Object>) ((List) iterable));
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            if (!it.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$singleOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        if (it.hasNext()) {
            return null;
        }
        return t;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull List<? extends T> list, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(list, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return toList(list.subList(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$sortBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (list.size() > 1) {
            g.sortWith(list, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull List<T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$sortByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (list.size() > 1) {
            g.sortWith(list, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$sortDescending");
        g.sortWith(list, t6.o.a.reverseOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sorted");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Comparable[] comparableArr = (Comparable[]) array;
            ArraysKt___ArraysJvmKt.sort(comparableArr);
            return ArraysKt___ArraysJvmKt.asList(comparableArr);
        }
        List<T> mutableList = toMutableList(iterable);
        g.sort(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(iterable, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sortedDescending");
        return sortedWith(iterable, t6.o.a.reverseOrder());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.Collection */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> sortedWith(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            ArraysKt___ArraysJvmKt.sortWith(array, comparator);
            return ArraysKt___ArraysJvmKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        g.sortWith(mutableList, comparator);
        return mutableList;
    }

    @NotNull
    public static final <T> Set<T> subtract(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        h.removeAll(mutableSet, iterable2);
        return mutableSet;
    }

    public static final <T> int sumBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += function1.invoke((Object) it.next()).intValue();
        }
        return i;
    }

    public static final <T> double sumByDouble(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<? extends T> it = iterable.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += function1.invoke((Object) it.next()).doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(@NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        int i = 0;
        for (Byte b2 : iterable) {
            i += b2.byteValue();
        }
        return i;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(@NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        double d = 0.0d;
        for (Double d2 : iterable) {
            d += d2.doubleValue();
        }
        return d;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        float f = 0.0f;
        for (Float f2 : iterable) {
            f += f2.floatValue();
        }
        return f;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        int i = 0;
        for (Integer num : iterable) {
            i += num.intValue();
        }
        return i;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(@NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        long j = 0;
        for (Long l : iterable) {
            j += l.longValue();
        }
        return j;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(@NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        int i = 0;
        for (Short sh : iterable) {
            i += sh.shortValue();
        }
        return i;
    }

    @NotNull
    public static final <T> List<T> take(@NotNull Iterable<? extends T> iterable, int i) {
        Intrinsics.checkNotNullParameter(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return toList(iterable);
                }
                if (i == 1) {
                    return d.listOf(first(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
    }

    @NotNull
    public static final <T> List<T> takeLast(@NotNull List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int size = list.size();
            if (i >= size) {
                return toList(list);
            }
            if (i == 1) {
                return d.listOf(last((List<? extends Object>) list));
            }
            ArrayList arrayList = new ArrayList(i);
            if (list instanceof RandomAccess) {
                for (int i2 = size - i; i2 < size; i2++) {
                    arrayList.add(list.get(i2));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <T> List<T> takeLastWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (list.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (!function1.invoke((Object) listIterator.previous()).booleanValue()) {
                listIterator.next();
                int size = list.size() - listIterator.nextIndex();
                if (size == 0) {
                    return CollectionsKt__CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList(size);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
                return arrayList;
            }
        }
        return toList(list);
    }

    @NotNull
    public static final <T> List<T> takeWhile(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (!function1.invoke(obj).booleanValue()) {
                break;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    @NotNull
    public static final boolean[] toBooleanArray(@NotNull Collection<Boolean> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toBooleanArray");
        boolean[] zArr = new boolean[collection.size()];
        int i = 0;
        for (Boolean bool : collection) {
            zArr[i] = bool.booleanValue();
            i++;
        }
        return zArr;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toByteArray");
        byte[] bArr = new byte[collection.size()];
        int i = 0;
        for (Byte b2 : collection) {
            bArr[i] = b2.byteValue();
            i++;
        }
        return bArr;
    }

    @NotNull
    public static final char[] toCharArray(@NotNull Collection<Character> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toCharArray");
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character ch : collection) {
            cArr[i] = ch.charValue();
            i++;
        }
        return cArr;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull Iterable<? extends T> iterable, @NotNull C c) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    @NotNull
    public static final double[] toDoubleArray(@NotNull Collection<Double> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toDoubleArray");
        double[] dArr = new double[collection.size()];
        int i = 0;
        for (Double d : collection) {
            dArr[i] = d.doubleValue();
            i++;
        }
        return dArr;
    }

    @NotNull
    public static final float[] toFloatArray(@NotNull Collection<Float> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toFloatArray");
        float[] fArr = new float[collection.size()];
        int i = 0;
        for (Float f : collection) {
            fArr[i] = f.floatValue();
            i++;
        }
        return fArr;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toHashSet");
        return (HashSet) toCollection(iterable, new HashSet(q.mapCapacity(t6.n.e.collectionSizeOrDefault(iterable, 12))));
    }

    @NotNull
    public static final int[] toIntArray(@NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer num : collection) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }

    @NotNull
    public static final <T> List<T> toList(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (size != 1) {
            return toMutableList(collection);
        }
        return d.listOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final long[] toLongArray(@NotNull Collection<Long> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toLongArray");
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (Long l : collection) {
            jArr[i] = l.longValue();
            i++;
        }
        return jArr;
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return toMutableList((Collection) iterable);
        }
        return (List) toCollection(iterable, new ArrayList());
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toMutableSet");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) toCollection(iterable, new LinkedHashSet());
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$toSet");
        if (!(iterable instanceof Collection)) {
            return y.optimizeReadOnlySet((Set) toCollection(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return y.emptySet();
        }
        if (size != 1) {
            return (Set) toCollection(iterable, new LinkedHashSet(q.mapCapacity(collection.size())));
        }
        return x.setOf(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    @NotNull
    public static final short[] toShortArray(@NotNull Collection<Short> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toShortArray");
        short[] sArr = new short[collection.size()];
        int i = 0;
        for (Short sh : collection) {
            sArr[i] = sh.shortValue();
            i++;
        }
        return sArr;
    }

    @NotNull
    public static final <T> Set<T> union(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$union");
        Intrinsics.checkNotNullParameter(iterable2, "other");
        Set<T> mutableSet = toMutableSet(iterable);
        h.addAll(mutableSet, iterable2);
        return mutableSet;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<List<T>> windowed(@NotNull Iterable<? extends T> iterable, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(iterable, "$this$windowed");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i2, z, false);
            while (windowedIterator.hasNext()) {
                arrayList.add((List) windowedIterator.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i2) + (size % i2 == 0 ? 0 : 1));
        int i3 = 0;
        while (i3 >= 0 && size > i3) {
            int coerceAtMost = e.coerceAtMost(i, size - i3);
            if (coerceAtMost < i && !z) {
                break;
            }
            ArrayList arrayList3 = new ArrayList(coerceAtMost);
            for (int i4 = 0; i4 < coerceAtMost; i4++) {
                arrayList3.add(list.get(i4 + i3));
            }
            arrayList2.add(arrayList3);
            i3 += i2;
        }
        return arrayList2;
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i, i2, z);
    }

    @NotNull
    public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$withIndex");
        return new IndexingIterable(new b(iterable));
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> iterable, @NotNull R[] rArr, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i >= length) {
                break;
            }
            arrayList.add(function2.invoke(obj, rArr[i]));
            i++;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> zipWithNext(@NotNull Iterable<? extends T> iterable, @NotNull Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$zipWithNext");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Object obj = (Object) it.next();
        while (it.hasNext()) {
            Object obj2 = (Object) it.next();
            arrayList.add(function2.invoke(obj, obj2));
            obj = (Object) obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> chunked(@NotNull Iterable<? extends T> iterable, int i, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$chunked");
        Intrinsics.checkNotNullParameter(function1, "transform");
        return windowed(iterable, i, i, true, function1);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: max  reason: collision with other method in class */
    public static final Float m356max(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$max");
        return m358maxOrNull(iterable);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    /* renamed from: min  reason: collision with other method in class */
    public static final Float m360min(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$min");
        return m362minOrNull(iterable);
    }

    public static /* synthetic */ List windowed$default(Iterable iterable, int i, int i2, boolean z, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return windowed(iterable, i, i2, z, function1);
    }

    public static final <T> boolean any(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return false;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            m.put(function1.invoke(obj), function12.invoke(obj));
        }
        return m;
    }

    public static final <T> int count(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return 0;
        }
        Iterator<? extends T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue() && (i = i + 1) < 0) {
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                } else {
                    throw new ArithmeticException("Count overflow has happened.");
                }
            }
        }
        return i;
    }

    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T extends Comparable<? super T>> T max(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$max");
        return (T) maxOrNull(iterable);
    }

    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T extends Comparable<? super T>> T min(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$min");
        return (T) minOrNull(iterable);
    }

    public static final <T> boolean none(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> List<T> requireNoNulls(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$requireNoNulls");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("null element found in " + list + FormatterType.defaultDecimalSeparator);
            }
        }
        return list;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull List<? extends T> list, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(list, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(list.get(num.intValue()));
        }
        return arrayList;
    }

    public static final <T> int indexOfFirst(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Iterator<? extends T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ListIterator<? extends T> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (function1.invoke((Object) listIterator.previous()).booleanValue()) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length == 0) {
            return toList(iterable);
        }
        HashSet hashSet = ArraysKt___ArraysKt.toHashSet(tArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!hashSet.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iterable, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(iterable, 10)), 16));
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            linkedHashMap.put(function1.invoke(obj), function12.invoke(obj));
        }
        return linkedHashMap;
    }

    public static final <T> int indexOf(@NotNull List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "$this$indexOf");
        return list.indexOf(t);
    }

    public static final <T> int lastIndexOf(@NotNull List<? extends T> list, T t) {
        Intrinsics.checkNotNullParameter(list, "$this$lastIndexOf");
        return list.lastIndexOf(t);
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, T t) {
        Intrinsics.checkNotNullParameter(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> iterable2, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), t6.n.e.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(function2.invoke((Object) it.next(), (Object) it2.next()));
        }
        return arrayList;
    }

    public static final <T> T first(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$first");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull Iterable<? extends T> iterable, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iterable, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = m.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj2).add(function12.invoke(obj));
        }
        return m;
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$singleOrNull");
        if (list.size() == 1) {
            return (T) list.get(0);
        }
        return null;
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iterable, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            Object invoke = function1.invoke(obj);
            Object obj2 = linkedHashMap.get(invoke);
            if (obj2 == null) {
                obj2 = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj2).add(function12.invoke(obj));
        }
        return linkedHashMap;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(list.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T singleOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r6) {
        /*
            java.lang.String r0 = "$this$singleOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.Iterator r5 = r5.iterator()
            r0 = 0
            r1 = 0
            r2 = r0
        L_0x0011:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x002d
            java.lang.Object r3 = r5.next()
            java.lang.Object r4 = r6.invoke(r3)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0011
            if (r1 == 0) goto L_0x002a
            return r0
        L_0x002a:
            r1 = 1
            r2 = r3
            goto L_0x0011
        L_0x002d:
            if (r1 != 0) goto L_0x0030
            return r0
        L_0x0030:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.singleOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T firstOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r3) {
        /*
            java.lang.String r0 = "$this$firstOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()
            java.lang.Object r1 = r3.invoke(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x000e
            return r0
        L_0x0025:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    public static final <T> T last(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$last");
        if (!list.isEmpty()) {
            return (T) list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T lastOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r4) {
        /*
            java.lang.String r0 = "$this$lastOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.Iterator r3 = r3.iterator()
            r0 = 0
        L_0x000f:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x0027
            java.lang.Object r1 = r3.next()
            java.lang.Object r2 = r4.invoke(r1)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x000f
            r0 = r1
            goto L_0x000f
        L_0x0027:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: maxOrNull  reason: collision with other method in class */
    public static final Float m358maxOrNull(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$maxOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    /* renamed from: minOrNull  reason: collision with other method in class */
    public static final Float m362minOrNull(@NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minOrNull");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(iterable, "$this$plus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Object[]) tArr);
        }
        ArrayList arrayList = new ArrayList();
        h.addAll(arrayList, iterable);
        h.addAll(arrayList, tArr);
        return arrayList;
    }

    public static final <T> T single(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return (T) list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T> List<Pair<T, T>> zipWithNext(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$zipWithNext");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            arrayList.add(TuplesKt.to(next, next2));
            next = next2;
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T first(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r3) {
        /*
            java.lang.String r0 = "$this$first"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r2 = r2.iterator()
        L_0x000e:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()
            java.lang.Object r1 = r3.invoke(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x000e
            return r0
        L_0x0025:
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            java.lang.String r3 = "Collection contains no element matching the predicate."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.first(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minus");
        Intrinsics.checkNotNullParameter(iterable2, MessengerShareContentUtility.ELEMENTS);
        Collection convertToSetForSetOperationWith = t6.n.e.convertToSetForSetOperationWith(iterable2, iterable);
        if (convertToSetForSetOperationWith.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!convertToSetForSetOperationWith.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T lastOrNull(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r3) {
        /*
            java.lang.String r0 = "$this$lastOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r2.size()
            java.util.ListIterator r2 = r2.listIterator(r0)
        L_0x0012:
            boolean r0 = r2.hasPrevious()
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r2.previous()
            java.lang.Object r1 = r3.invoke(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0012
            return r0
        L_0x0029:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.lastOrNull(java.util.List, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> iterable, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(iterable, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int length = rArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i = 0;
        for (Object obj : iterable) {
            if (i >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(obj, rArr[i]));
            i++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T last(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "$this$last"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Iterator r4 = r4.iterator()
            r0 = 0
            r1 = 0
        L_0x0010:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x002a
            java.lang.Object r2 = r4.next()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0010
            r0 = 1
            r0 = r2
            r1 = 1
            goto L_0x0010
        L_0x002a:
            if (r1 == 0) goto L_0x002d
            return r0
        L_0x002d:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Collection contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.last(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "$this$plus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList(collection.size() + tArr.length);
        arrayList.addAll(collection);
        h.addAll(arrayList, tArr);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T single(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r5) {
        /*
            java.lang.String r0 = "$this$single"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Iterator r4 = r4.iterator()
            r0 = 0
            r1 = 0
        L_0x0010:
            boolean r2 = r4.hasNext()
            if (r2 == 0) goto L_0x0034
            java.lang.Object r2 = r4.next()
            java.lang.Object r3 = r5.invoke(r2)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x0010
            if (r1 != 0) goto L_0x002c
            r0 = 1
            r0 = r2
            r1 = 1
            goto L_0x0010
        L_0x002c:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Collection contains more than one matching element."
            r4.<init>(r5)
            throw r4
        L_0x0034:
            if (r1 == 0) goto L_0x0037
            return r0
        L_0x0037:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Collection contains no element matching the predicate."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.single(java.lang.Iterable, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    @SinceKotlin(version = "1.2")
    @NotNull
    public static final <T, R> List<R> windowed(@NotNull Iterable<? extends T> iterable, int i, int i2, boolean z, @NotNull Function1<? super List<? extends T>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$windowed");
        Intrinsics.checkNotNullParameter(function1, "transform");
        SlidingWindowKt.checkWindowSizeStep(i, i2);
        int i3 = 1;
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), i, i2, z, true);
            while (windowedIterator.hasNext()) {
                arrayList.add(function1.invoke((List) windowedIterator.next()));
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        int i4 = size / i2;
        int i5 = 0;
        if (size % i2 == 0) {
            i3 = 0;
        }
        ArrayList arrayList2 = new ArrayList(i4 + i3);
        MovingSubList movingSubList = new MovingSubList(list);
        while (i5 >= 0 && size > i5) {
            int coerceAtMost = e.coerceAtMost(i, size - i5);
            if (!z && coerceAtMost < i) {
                break;
            }
            movingSubList.move(i5, coerceAtMost + i5);
            arrayList2.add(function1.invoke(movingSubList));
            i5 += i2;
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T last(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> r3) {
        /*
            java.lang.String r0 = "$this$last"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r2.size()
            java.util.ListIterator r2 = r2.listIterator(r0)
        L_0x0012:
            boolean r0 = r2.hasPrevious()
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r2.previous()
            java.lang.Object r1 = r3.invoke(r0)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0012
            return r0
        L_0x0029:
            java.util.NoSuchElementException r2 = new java.util.NoSuchElementException
            java.lang.String r3 = "List contains no element matching the predicate."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.last(java.util.List, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.Comparable<? super T>> T maxOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r3) {
        /*
            java.lang.String r0 = "$this$maxOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0011
            r3 = 0
            return r3
        L_0x0011:
            java.lang.Object r0 = r3.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
        L_0x0017:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r3.next()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r2 = r0.compareTo(r1)
            if (r2 >= 0) goto L_0x0017
            r0 = r1
            goto L_0x0017
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.maxOrNull(java.lang.Iterable):java.lang.Comparable");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends java.lang.Comparable<? super T>> T minOrNull(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r3) {
        /*
            java.lang.String r0 = "$this$minOrNull"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Iterator r3 = r3.iterator()
            boolean r0 = r3.hasNext()
            if (r0 != 0) goto L_0x0011
            r3 = 0
            return r3
        L_0x0011:
            java.lang.Object r0 = r3.next()
            java.lang.Comparable r0 = (java.lang.Comparable) r0
        L_0x0017:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r3.next()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            int r2 = r0.compareTo(r1)
            if (r2 <= 0) goto L_0x0017
            r0 = r1
            goto L_0x0017
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt___CollectionsKt.minOrNull(java.lang.Iterable):java.lang.Comparable");
    }

    @NotNull
    public static final <T> List<T> minus(@NotNull Iterable<? extends T> iterable, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(iterable, "$this$minus");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(sequence);
        if (hashSet.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!hashSet.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$plus");
        Intrinsics.checkNotNullParameter(iterable2, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return plus((Collection) iterable, (Iterable) iterable2);
        }
        ArrayList arrayList = new ArrayList();
        h.addAll(arrayList, iterable);
        h.addAll(arrayList, iterable2);
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull Iterable<? extends T> iterable, @NotNull Iterable<? extends R> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), t6.n.e.collectionSizeOrDefault(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(TuplesKt.to(it.next(), it2.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$plus");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        h.addAll(arrayList2, iterable);
        return arrayList2;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Iterable<? extends T> iterable, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(iterable, "$this$plus");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList();
        h.addAll(arrayList, iterable);
        h.addAll(arrayList, sequence);
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> plus(@NotNull Collection<? extends T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "$this$plus");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList(collection.size() + 10);
        arrayList.addAll(collection);
        h.addAll(arrayList, sequence);
        return arrayList;
    }
}
