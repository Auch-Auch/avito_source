package kotlin.collections;

import com.avito.android.lib.design.input.FormatterType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.j;
import t6.n.q;
import t6.n.x;
import t6.n.y;
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {

    public static final class a extends Lambda implements Function0<Iterator<? extends T>> {
        public final /* synthetic */ Object[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Object[] objArr) {
            super(0);
            this.a = objArr;
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return ArrayIteratorKt.iterator(this.a);
        }
    }

    public static final class b extends Lambda implements Function0<Iterator<? extends Byte>> {
        public final /* synthetic */ byte[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(byte[] bArr) {
            super(0);
            this.a = bArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Byte> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class c extends Lambda implements Function0<Iterator<? extends Short>> {
        public final /* synthetic */ short[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(short[] sArr) {
            super(0);
            this.a = sArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Short> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class d extends Lambda implements Function0<Iterator<? extends Integer>> {
        public final /* synthetic */ int[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int[] iArr) {
            super(0);
            this.a = iArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Integer> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class e extends Lambda implements Function0<Iterator<? extends Long>> {
        public final /* synthetic */ long[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(long[] jArr) {
            super(0);
            this.a = jArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Long> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class f extends Lambda implements Function0<Iterator<? extends Float>> {
        public final /* synthetic */ float[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(float[] fArr) {
            super(0);
            this.a = fArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Float> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class g extends Lambda implements Function0<Iterator<? extends Double>> {
        public final /* synthetic */ double[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(double[] dArr) {
            super(0);
            this.a = dArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Double> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class h extends Lambda implements Function0<Iterator<? extends Boolean>> {
        public final /* synthetic */ boolean[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(boolean[] zArr) {
            super(0);
            this.a = zArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Boolean> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final class i extends Lambda implements Function0<Iterator<? extends Character>> {
        public final /* synthetic */ char[] a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(char[] cArr) {
            super(0);
            this.a = cArr;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Iterator<? extends Character> invoke() {
            return ArrayIteratorsKt.iterator(this.a);
        }
    }

    public static final <T> boolean all(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (!function1.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$any");
        return !(tArr.length == 0);
    }

    @NotNull
    public static final <T> Iterable<T> asIterable(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$asIterable");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(tArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1
            public final /* synthetic */ Object[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$asSequence");
        if (tArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<T>(tArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
            public final /* synthetic */ Object[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<T> iterator() {
                return ArrayIteratorKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associate(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            Pair pair = (Pair) function1.invoke(t);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K> Map<K, T> associateBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(function1.invoke(t), t);
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (T t : tArr) {
            m.put(function1.invoke(t), t);
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (T t : tArr) {
            Pair pair = (Pair) function1.invoke(t);
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V> Map<K, V> associateWith(@NotNull K[] kArr, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(kArr, "$this$associateWith");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(kArr.length), 16));
        for (K k : kArr) {
            linkedHashMap.put(k, function1.invoke(k));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(@NotNull K[] kArr, @NotNull M m, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(kArr, "$this$associateWithTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "valueSelector");
        for (K k : kArr) {
            m.put(k, function1.invoke(k));
        }
        return m;
    }

    public static final double average(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (byte b2 : bArr) {
            d2 += (double) b2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(@NotNull Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Byte b2 : bArr) {
            d2 += (double) b2.byteValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Double d3 : dArr) {
            d2 += d3.doubleValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Float f2 : fArr) {
            d2 += (double) f2.floatValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Integer num : numArr) {
            d2 += (double) num.intValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(@NotNull Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Long l : lArr) {
            d2 += (double) l.longValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(@NotNull Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (Short sh : shArr) {
            d2 += (double) sh.shortValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final <T> boolean contains(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "$this$contains");
        return indexOf(tArr, t) >= 0;
    }

    public static final <T> int count(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final <T> List<T> distinct(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(tArr));
    }

    @NotNull
    public static final <T, K> List<T> distinctBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (hashSet.add(function1.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> drop(@NotNull T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(tArr, t6.v.e.coerceAtLeast(tArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> dropLast(@NotNull T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(tArr, t6.v.e.coerceAtLeast(tArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final <T> List<T> dropLastWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(tArr[lastIndex]).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <T> List<T> dropWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : tArr) {
            if (z) {
                arrayList.add(t);
            } else if (!function1.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filter(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            T t = tArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), t).booleanValue()) {
                arrayList.add(t);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterIndexedTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            T t = tArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), t).booleanValue()) {
                c2.add(t);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "$this$filterIsInstance");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Object[] objArr, C c2) {
        Intrinsics.checkNotNullParameter(objArr, "$this$filterIsInstanceTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                c2.add(obj);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T> List<T> filterNot(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!function1.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> filterNotNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterNotNull");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    @NotNull
    public static final <C extends Collection<? super T>, T> C filterNotNullTo(@NotNull T[] tArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (T t : tArr) {
            if (t != null) {
                c2.add(t);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterNotTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (!function1.invoke(t).booleanValue()) {
                c2.add(t);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C filterTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                c2.add(t);
            }
        }
        return c2;
    }

    public static final <T> T first(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$first");
        if (!(tArr.length == 0)) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$firstOrNull");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    @NotNull
    public static final <T, R> List<R> flatMap(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(t));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R> List<R> flatMapSequence(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            t6.n.h.addAll(arrayList, (Sequence) function1.invoke(t));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function1<? super T, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (T t : tArr) {
            t6.n.h.addAll(c2, (Sequence) function1.invoke(t));
        }
        return c2;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C flatMapTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (T t : tArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(t));
        }
        return c2;
    }

    public static final <T, R> R fold(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (T t : tArr) {
            r = (R) function2.invoke(r, t);
        }
        return r;
    }

    public static final <T, R> R foldIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, t);
        }
        return r;
    }

    public static final <T, R> R foldRight(@NotNull T[] tArr, R r, @NotNull Function2<? super T, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(tArr[lastIndex], r);
        }
        return r;
    }

    public static final <T, R> R foldRightIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super T, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r);
        }
        return r;
    }

    public static final <T> void forEach(@NotNull T[] tArr, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (T t : tArr) {
            function1.invoke(t);
        }
    }

    public static final <T> void forEachIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, t);
        }
    }

    @NotNull
    public static final <T> IntRange getIndices(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$indices");
        return new IntRange(0, getLastIndex(tArr));
    }

    public static final <T> int getLastIndex(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$lastIndex");
        return tArr.length - 1;
    }

    @Nullable
    public static final <T> T getOrNull(@NotNull T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(tArr)) {
            return null;
        }
        return tArr[i2];
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> groupBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(t);
        }
        return m;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Grouping<T, K> groupingBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$groupingBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        return new Grouping<T, K>(tArr, function1) { // from class: kotlin.collections.ArraysKt___ArraysKt$groupingBy$1
            public final /* synthetic */ Object[] a;
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
                return ArrayIteratorKt.iterator(this.a);
            }
        };
    }

    public static final <T> int indexOf(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "$this$indexOf");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (Intrinsics.areEqual((Object) t, (Object) tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> int indexOfFirst(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(tArr[i2]).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = tArr.length - 1; length >= 0; length--) {
            if (function1.invoke(tArr[length]).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final <T> Set<T> intersect(@NotNull T[] tArr, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(tArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final <T, A extends Appendable> A joinTo(@NotNull T[] tArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (T t : tArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            t6.y.e.appendElement(a3, t, function1);
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static /* synthetic */ Appendable joinTo$default(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(objArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final <T> String joinToString(@NotNull T[] tArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(objArr, charSequence, charSequence6, charSequence5, i4, charSequence4, function1);
    }

    public static final <T> T last(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$last");
        if (!(tArr.length == 0)) {
            return tArr[getLastIndex(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final <T> int lastIndexOf(@NotNull T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "$this$lastIndexOf");
        if (t == null) {
            for (int length = tArr.length - 1; length >= 0; length--) {
                if (tArr[length] == null) {
                    return length;
                }
            }
        } else {
            for (int length2 = tArr.length - 1; length2 >= 0; length2--) {
                if (Intrinsics.areEqual((Object) t, (Object) tArr[length2])) {
                    return length2;
                }
            }
        }
        return -1;
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$lastOrNull");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @NotNull
    public static final <T, R> List<R> map(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(function1.invoke(t));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexed(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int i2 = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, t));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> mapIndexedNotNull(@NotNull T[] tArr, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapIndexedNotNull");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            Object invoke = function2.invoke(Integer.valueOf(i3), tArr[i2]);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapIndexedNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            Object invoke = function2.invoke(Integer.valueOf(i3), tArr[i2]);
            if (invoke != null) {
                c2.add(invoke);
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (T t : tArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, t));
        }
        return c2;
    }

    @NotNull
    public static final <T, R> List<R> mapNotNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            if (invoke != null) {
                c2.add(invoke);
            }
        }
        return c2;
    }

    @NotNull
    public static final <T, R, C extends Collection<? super R>> C mapTo(@NotNull T[] tArr, @NotNull C c2, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (T t : tArr) {
            c2.add(function1.invoke(t));
        }
        return c2;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Double max(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$max");
        return maxOrNull(dArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T maxBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(t);
            if (1 <= lastIndex) {
                while (true) {
                    T t2 = tArr[i2];
                    Comparable comparable2 = (Comparable) function1.invoke(t2);
                    int compareTo = comparable.compareTo(comparable2);
                    Comparable comparable3 = comparable;
                    if (compareTo < 0) {
                        t = t2;
                        comparable3 = comparable2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                    comparable = comparable3;
                }
            }
        }
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        Comparable comparable = (Comparable) function1.invoke(t);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(t2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo < 0) {
                    t = t2;
                    comparable3 = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
                comparable = comparable3;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double maxOrNull(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$maxOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, dArr[i2].doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T> T maxWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) maxWithOrNull(tArr, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T> T maxWithOrNull(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (comparator.compare(t, t2) < 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Double min(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$min");
        return minOrNull(dArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T, R extends Comparable<? super R>> T minBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex != 0) {
            Comparable comparable = (Comparable) function1.invoke(t);
            if (1 <= lastIndex) {
                while (true) {
                    T t2 = tArr[i2];
                    Comparable comparable2 = (Comparable) function1.invoke(t2);
                    int compareTo = comparable.compareTo(comparable2);
                    Comparable comparable3 = comparable;
                    if (compareTo > 0) {
                        t = t2;
                        comparable3 = comparable2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                    comparable = comparable3;
                }
            }
        }
        return t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.lang.Comparable */
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T, R extends Comparable<? super R>> T minByOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        Comparable comparable = (Comparable) function1.invoke(t);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(t2);
                int compareTo = comparable.compareTo(comparable2);
                Comparable comparable3 = comparable;
                if (compareTo > 0) {
                    t = t2;
                    comparable3 = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
                comparable = comparable3;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double minOrNull(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$minOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, dArr[i2].doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T> T minWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (T) minWithOrNull(tArr, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T> T minWithOrNull(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (comparator.compare(t, t2) > 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final <T> boolean none(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$none");
        return tArr.length == 0;
    }

    @NotNull
    public static final <T> Pair<List<T>, List<T>> partition(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> T random(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(tArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(tArr.length == 0)) {
            return tArr[random.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T randomOrNull(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(tArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.nextInt(tArr.length)];
    }

    public static final <S, T extends S> S reduce(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(tArr.length == 0)) {
            T t = tArr[0];
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    t = (S) function2.invoke(t, tArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (S) t;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(tArr.length == 0)) {
            T t = tArr[0];
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    t = (S) function3.invoke(Integer.valueOf(i2), t, tArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (S) t;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceIndexedOrNull(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                t = (S) function3.invoke(Integer.valueOf(i2), t, tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (S) t;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceOrNull(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                t = (S) function2.invoke(t, tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (S) t;
    }

    public static final <S, T extends S> S reduceRight(@NotNull T[] tArr, @NotNull Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            S s = (S) tArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                s = (S) function2.invoke(tArr[i2], s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final <S, T extends S> S reduceRightIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            S s = (S) tArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                s = (S) function3.invoke(Integer.valueOf(i2), tArr[i2], s);
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <S, T extends S> S reduceRightIndexedOrNull(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super T, ? super S, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s = (S) function3.invoke(Integer.valueOf(i2), tArr[i2], s);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceRightOrNull(@NotNull T[] tArr, @NotNull Function2<? super T, ? super S, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s = (S) function2.invoke(tArr[i2], s);
        }
        return s;
    }

    @NotNull
    public static final <T> T[] requireNoNulls(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$requireNoNulls");
        for (T t : tArr) {
            if (t == null) {
                throw new IllegalArgumentException("null element found in " + tArr + FormatterType.defaultDecimalSeparator);
            }
        }
        return tArr;
    }

    public static final <T> void reverse(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reverse");
        int length = (tArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(tArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    T t = tArr[i2];
                    tArr[i2] = tArr[lastIndex];
                    tArr[lastIndex] = t;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    public static final <T> List<T> reversed(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reversed");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T> T[] reversedArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reversedArray");
        int i2 = 0;
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) t6.n.b.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            while (true) {
                tArr2[lastIndex - i2] = tArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return tArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFold(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$runningFold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 0;
        if (tArr.length == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        Object obj = r;
        while (i2 < length) {
            Object obj2 = (Object) function2.invoke(obj, tArr[i2]);
            arrayList.add(obj2);
            i2++;
            obj = obj2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T, R> List<R> runningFoldIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$runningFoldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        if (tArr.length == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        Object obj = r;
        while (i2 < length) {
            Object obj2 = (Object) function3.invoke(Integer.valueOf(i2), obj, tArr[i2]);
            arrayList.add(obj2);
            i2++;
            obj = obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> List<S> runningReduce(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$runningReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T t = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            t = (Object) function2.invoke(t, tArr[i2]);
            arrayList.add(t);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <S, T extends S> List<S> runningReduceIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$runningReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T t = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            t = (Object) function3.invoke(Integer.valueOf(i2), t, tArr[i2]);
            arrayList.add(t);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r5v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> List<R> scan(@NotNull T[] tArr, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$scan");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 0;
        if (tArr.length == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        Object obj = r;
        while (i2 < length) {
            Object obj2 = (Object) function2.invoke(obj, tArr[i2]);
            arrayList.add(obj2);
            i2++;
            obj = obj2;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: ? super R */
    @SinceKotlin(version = "1.4")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> List<R> scanIndexed(@NotNull T[] tArr, R r, @NotNull Function3<? super Integer, ? super R, ? super T, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$scanIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        if (tArr.length == 0) {
            return t6.n.d.listOf(r);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r);
        int length = tArr.length;
        Object obj = r;
        while (i2 < length) {
            Object obj2 = (Object) function3.invoke(Integer.valueOf(i2), obj, tArr[i2]);
            arrayList.add(obj2);
            i2++;
            obj = obj2;
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduce instead.", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", imports = {}))
    public static final <S, T extends S> List<S> scanReduce(@NotNull T[] tArr, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$scanReduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T t = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            t = (Object) function2.invoke(t, tArr[i2]);
            arrayList.add(t);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use runningReduceIndexed instead.", replaceWith = @ReplaceWith(expression = "runningReduceIndexed(operation)", imports = {}))
    public static final <S, T extends S> List<S> scanReduceIndexed(@NotNull T[] tArr, @NotNull Function3<? super Integer, ? super S, ? super T, ? extends S> function3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$scanReduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        T t = tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(t);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            t = (Object) function3.invoke(Integer.valueOf(i2), t, tArr[i2]);
            arrayList.add(t);
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> void shuffle(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$shuffle");
        shuffle(tArr, Random.Default);
    }

    public static final <T> T single(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$single");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return tArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull T[] tArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(tArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(tArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final <T> T[] sliceArray(@NotNull T[] tArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        T[] tArr2 = (T[]) t6.n.b.arrayOfNulls(tArr, collection.size());
        int i2 = 0;
        for (Integer num : collection) {
            tArr2[i2] = tArr[num.intValue()];
            i2++;
        }
        return tArr2;
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sortWith(tArr, t6.o.a.reverseOrder());
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sorted(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sorted");
        return ArraysKt___ArraysJvmKt.asList(sortedArray(tArr));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] sortedArray(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedArray");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(tArr2);
        return tArr2;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedArrayDescending");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        ArraysKt___ArraysJvmKt.sortWith(tArr2, t6.o.a.reverseOrder());
        return tArr2;
    }

    @NotNull
    public static final <T> T[] sortedArrayWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedArrayWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final <T extends Comparable<? super T>> List<T> sortedDescending(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedDescending");
        return sortedWith(tArr, t6.o.a.reverseOrder());
    }

    @NotNull
    public static final <T> List<T> sortedWith(@NotNull T[] tArr, @NotNull Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysJvmKt.asList(sortedArrayWith(tArr, comparator));
    }

    @NotNull
    public static final <T> Set<T> subtract(@NotNull T[] tArr, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(tArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sum(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sum");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += b2;
        }
        return i2;
    }

    public static final <T> int sumBy(@NotNull T[] tArr, @NotNull Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (T t : tArr) {
            i2 += function1.invoke(t).intValue();
        }
        return i2;
    }

    public static final <T> double sumByDouble(@NotNull T[] tArr, @NotNull Function1<? super T, Double> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (T t : tArr) {
            d2 += function1.invoke(t).doubleValue();
        }
        return d2;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(@NotNull Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sum");
        int i2 = 0;
        for (Byte b2 : bArr) {
            i2 += b2.byteValue();
        }
        return i2;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sum");
        double d2 = 0.0d;
        for (Double d3 : dArr) {
            d2 += d3.doubleValue();
        }
        return d2;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sum");
        float f2 = 0.0f;
        for (Float f3 : fArr) {
            f2 += f3.floatValue();
        }
        return f2;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "$this$sum");
        int i2 = 0;
        for (Integer num : numArr) {
            i2 += num.intValue();
        }
        return i2;
    }

    @JvmName(name = "sumOfLong")
    public static final long sumOfLong(@NotNull Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "$this$sum");
        long j = 0;
        for (Long l : lArr) {
            j += l.longValue();
        }
        return j;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(@NotNull Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "$this$sum");
        int i2 = 0;
        for (Short sh : shArr) {
            i2 += sh.shortValue();
        }
        return i2;
    }

    @NotNull
    public static final <T> List<T> take(@NotNull T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= tArr.length) {
                return toList(tArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(tArr[0]);
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (T t : tArr) {
                arrayList.add(t);
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <T> List<T> takeLast(@NotNull T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = tArr.length;
            if (i2 >= length) {
                return toList(tArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(tArr[length - 1]);
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(tArr[i3]);
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <T> List<T> takeLastWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(tArr[lastIndex]).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    @NotNull
    public static final <T> List<T> takeWhile(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!function1.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    @NotNull
    public static final boolean[] toBooleanArray(@NotNull Boolean[] boolArr) {
        Intrinsics.checkNotNullParameter(boolArr, "$this$toBooleanArray");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = boolArr[i2].booleanValue();
        }
        return zArr;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toByteArray");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = bArr[i2].byteValue();
        }
        return bArr2;
    }

    @NotNull
    public static final char[] toCharArray(@NotNull Character[] chArr) {
        Intrinsics.checkNotNullParameter(chArr, "$this$toCharArray");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = chArr[i2].charValue();
        }
        return cArr;
    }

    @NotNull
    public static final <T, C extends Collection<? super T>> C toCollection(@NotNull T[] tArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (T t : tArr) {
            c2.add(t);
        }
        return c2;
    }

    @NotNull
    public static final double[] toDoubleArray(@NotNull Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toDoubleArray");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = dArr[i2].doubleValue();
        }
        return dArr2;
    }

    @NotNull
    public static final float[] toFloatArray(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toFloatArray");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = fArr[i2].floatValue();
        }
        return fArr2;
    }

    @NotNull
    public static final <T> HashSet<T> toHashSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toHashSet");
        return (HashSet) toCollection(tArr, new HashSet(q.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final int[] toIntArray(@NotNull Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "$this$toIntArray");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    @NotNull
    public static final <T> List<T> toList(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toList");
        int length = tArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(tArr);
        }
        return t6.n.d.listOf(tArr[0]);
    }

    @NotNull
    public static final long[] toLongArray(@NotNull Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "$this$toLongArray");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = lArr[i2].longValue();
        }
        return jArr;
    }

    @NotNull
    public static final <T> List<T> toMutableList(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toMutableList");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    @NotNull
    public static final <T> Set<T> toMutableSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toMutableSet");
        return (Set) toCollection(tArr, new LinkedHashSet(q.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final <T> Set<T> toSet(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$toSet");
        int length = tArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(tArr, new LinkedHashSet(q.mapCapacity(tArr.length)));
        }
        return x.setOf(tArr[0]);
    }

    @NotNull
    public static final short[] toShortArray(@NotNull Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "$this$toShortArray");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 < length; i2++) {
            sArr[i2] = shArr[i2].shortValue();
        }
        return sArr;
    }

    @NotNull
    public static final <T> Set<T> union(@NotNull T[] tArr, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(tArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final <T> Iterable<IndexedValue<T>> withIndex(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$withIndex");
        return new IndexingIterable(new a(tArr));
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull T[] tArr, @NotNull R[] rArr, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(tArr[i2], rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean all(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (!function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$any");
        return !(bArr.length == 0);
    }

    public static final double average(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (short s : sArr) {
            d2 += (double) s;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(@NotNull byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$contains");
        return indexOf(bArr, b2) >= 0;
    }

    public static final int count(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Byte> distinct(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(bArr));
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterNotTo(@NotNull byte[] bArr, @NotNull C c2, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (!function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                c2.add(Byte.valueOf(b2));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterTo(@NotNull byte[] bArr, @NotNull C c2, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                c2.add(Byte.valueOf(b2));
            }
        }
        return c2;
    }

    @Nullable
    public static final Byte firstOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$firstOrNull");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    public static final <R> R fold(@NotNull byte[] bArr, R r, @NotNull Function2<? super R, ? super Byte, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (byte b2 : bArr) {
            r = (R) function2.invoke(r, Byte.valueOf(b2));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull byte[] bArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Byte, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Byte.valueOf(b2));
        }
        return r;
    }

    public static final void forEach(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (byte b2 : bArr) {
            function1.invoke(Byte.valueOf(b2));
        }
    }

    public static final void forEachIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Unit> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Byte.valueOf(b2));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$indices");
        return new IntRange(0, getLastIndex(bArr));
    }

    public static final int getLastIndex(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$lastIndex");
        return bArr.length - 1;
    }

    @Nullable
    public static final Byte getOrNull(@NotNull byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i2]);
    }

    public static /* synthetic */ Appendable joinTo$default(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(bArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (Function1<? super Byte, ? extends CharSequence>) ((i3 & 64) != 0 ? null : function1));
    }

    @NotNull
    public static final String joinToString(@NotNull byte[] bArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(bArr, charSequence, charSequence6, charSequence5, i4, charSequence4, (Function1<? super Byte, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Byte lastOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$lastOrNull");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Float max(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$max");
        return maxOrNull(fArr);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Byte maxWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(bArr, comparator);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Float min(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$min");
        return minOrNull(fArr);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Byte minWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(bArr, comparator);
    }

    public static final boolean none(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$none");
        return bArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$shuffle");
        shuffle(bArr, (Random) Random.Default);
    }

    @Nullable
    public static final Byte singleOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$singleOrNull");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final void sortDescending(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortDescending");
        if (bArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(bArr);
            reverse(bArr);
        }
    }

    @NotNull
    public static final List<Byte> sorted(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sorted");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Byte> sortedDescending(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedDescending");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Byte> sortedWith(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final int sum(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sum");
        int i2 = 0;
        for (short s : sArr) {
            i2 += s;
        }
        return i2;
    }

    @NotNull
    public static final HashSet<Byte> toHashSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toHashSet");
        return (HashSet) toCollection(bArr, new HashSet(q.mapCapacity(bArr.length)));
    }

    @NotNull
    public static final List<Byte> toMutableList(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Byte> toMutableSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toMutableSet");
        return (Set) toCollection(bArr, new LinkedHashSet(q.mapCapacity(bArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Byte>> withIndex(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$withIndex");
        return new IndexingIterable(new b(bArr));
    }

    public static final boolean all(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (!function1.invoke(Short.valueOf(s)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$any");
        return !(sArr.length == 0);
    }

    @NotNull
    public static final Iterable<Byte> asIterable(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$asIterable");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(bArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$2
            public final /* synthetic */ byte[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Byte> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Byte> asSequence(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$asSequence");
        if (bArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Byte>(bArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$2
            public final /* synthetic */ byte[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Byte> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Byte> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (byte b2 : bArr) {
            m.put(function1.invoke(Byte.valueOf(b2)), Byte.valueOf(b2));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (byte b2 : bArr) {
            Pair pair = (Pair) function1.invoke(Byte.valueOf(b2));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    public static final double average(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (int i3 : iArr) {
            d2 += (double) i3;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "$this$contains");
        return indexOf(sArr, s) >= 0;
    }

    public static final int count(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Short> distinct(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(sArr));
    }

    @NotNull
    public static final List<Byte> drop(@NotNull byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(bArr, t6.v.e.coerceAtLeast(bArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Byte> dropLast(@NotNull byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(bArr, t6.v.e.coerceAtLeast(bArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Byte> filter(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C filterIndexedTo(@NotNull byte[] bArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Byte, Boolean> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Byte.valueOf(b2)).booleanValue()) {
                c2.add(Byte.valueOf(b2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Byte> filterNot(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (!function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterNotTo(@NotNull short[] sArr, @NotNull C c2, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (!function1.invoke(Short.valueOf(s)).booleanValue()) {
                c2.add(Short.valueOf(s));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterTo(@NotNull short[] sArr, @NotNull C c2, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                c2.add(Short.valueOf(s));
            }
        }
        return c2;
    }

    @Nullable
    public static final Short firstOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$firstOrNull");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R fold(@NotNull short[] sArr, R r, @NotNull Function2<? super R, ? super Short, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (short s : sArr) {
            r = (R) function2.invoke(r, Short.valueOf(s));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull short[] sArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Short, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Short.valueOf(s));
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull byte[] bArr, R r, @NotNull Function2<? super Byte, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Byte.valueOf(bArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull byte[] bArr, R r, @NotNull Function3<? super Integer, ? super Byte, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull short[] sArr, @NotNull Function1<? super Short, Unit> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (short s : sArr) {
            function1.invoke(Short.valueOf(s));
        }
    }

    public static final void forEachIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Unit> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Short.valueOf(s));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$indices");
        return new IntRange(0, getLastIndex(sArr));
    }

    public static final int getLastIndex(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$lastIndex");
        return sArr.length - 1;
    }

    @Nullable
    public static final Short getOrNull(@NotNull short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i2]);
    }

    public static final int indexOfFirst(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Byte.valueOf(bArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Byte> intersect(@NotNull byte[] bArr, @NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static /* synthetic */ Appendable joinTo$default(short[] sArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(sArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (Function1<? super Short, ? extends CharSequence>) ((i3 & 64) != 0 ? null : function1));
    }

    @NotNull
    public static final String joinToString(@NotNull short[] sArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(sArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sArr, charSequence, charSequence6, charSequence5, i4, charSequence4, (Function1<? super Short, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Short lastOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$lastOrNull");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull byte[] bArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Byte, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Byte.valueOf(b2)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull byte[] bArr, @NotNull C c2, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (byte b2 : bArr) {
            c2.add(function1.invoke(Byte.valueOf(b2)));
        }
        return c2;
    }

    @Nullable
    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T extends Comparable<? super T>> T max(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$max");
        return (T) maxOrNull(tArr);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Short maxWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(sArr, comparator);
    }

    @Nullable
    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <T extends Comparable<? super T>> T min(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$min");
        return (T) minOrNull(tArr);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Short minWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(sArr, comparator);
    }

    public static final boolean none(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$none");
        return sArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Byte randomOrNull(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[random.nextInt(bArr.length)]);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$shuffle");
        shuffle(sArr, (Random) Random.Default);
    }

    @Nullable
    public static final Short singleOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$singleOrNull");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Byte> slice(@NotNull byte[] bArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(bArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final List<Short> sorted(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sorted");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final byte[] sortedArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedArray");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final byte[] sortedArrayDescending(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortedArrayDescending");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> sortedBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Short> sortedDescending(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedDescending");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Short> sortedWith(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Byte> subtract(@NotNull byte[] bArr, @NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sum(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sum");
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    public static final int sumBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Integer> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += function1.invoke(Byte.valueOf(b2)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Double> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (byte b2 : bArr) {
            d2 += function1.invoke(Byte.valueOf(b2)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final <C extends Collection<? super Byte>> C toCollection(@NotNull byte[] bArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (byte b2 : bArr) {
            c2.add(Byte.valueOf(b2));
        }
        return c2;
    }

    @NotNull
    public static final HashSet<Short> toHashSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toHashSet");
        return (HashSet) toCollection(sArr, new HashSet(q.mapCapacity(sArr.length)));
    }

    @NotNull
    public static final Set<Short> toMutableSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toMutableSet");
        return (Set) toCollection(sArr, new LinkedHashSet(q.mapCapacity(sArr.length)));
    }

    @NotNull
    public static final Set<Byte> union(@NotNull byte[] bArr, @NotNull Iterable<Byte> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Short>> withIndex(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$withIndex");
        return new IndexingIterable(new c(sArr));
    }

    public static final boolean all(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$any");
        return !(iArr.length == 0);
    }

    public static final double average(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (long j : jArr) {
            d2 += (double) j;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$contains");
        return indexOf(iArr, i2) >= 0;
    }

    public static final int count(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (int i3 : iArr) {
            if (function1.invoke(Integer.valueOf(i3)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Integer> distinct(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(iArr));
    }

    @NotNull
    public static final List<Byte> filterIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, Boolean> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterNotTo(@NotNull int[] iArr, @NotNull C c2, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                c2.add(Integer.valueOf(i2));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterTo(@NotNull int[] iArr, @NotNull C c2, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                c2.add(Integer.valueOf(i2));
            }
        }
        return c2;
    }

    public static final byte first(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$first");
        if (!(bArr.length == 0)) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Integer firstOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$firstOrNull");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull byte[] bArr, @NotNull C c2, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (byte b2 : bArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Byte.valueOf(b2)));
        }
        return c2;
    }

    public static final <R> R fold(@NotNull int[] iArr, R r, @NotNull Function2<? super R, ? super Integer, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int i2 : iArr) {
            r = (R) function2.invoke(r, Integer.valueOf(i2));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull int[] iArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Integer, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (int i3 : iArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Integer.valueOf(i3));
        }
        return r;
    }

    public static final void forEach(@NotNull int[] iArr, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (int i2 : iArr) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    public static final void forEachIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (int i3 : iArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Integer.valueOf(i3));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$indices");
        return new IntRange(0, getLastIndex(iArr));
    }

    public static final int getLastIndex(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$lastIndex");
        return iArr.length - 1;
    }

    @Nullable
    public static final Integer getOrNull(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i2]);
    }

    public static /* synthetic */ Appendable joinTo$default(int[] iArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(iArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (Function1<? super Integer, ? extends CharSequence>) ((i3 & 64) != 0 ? null : function1));
    }

    @NotNull
    public static final String joinToString(@NotNull int[] iArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iArr, charSequence, charSequence6, charSequence5, i4, charSequence4, (Function1<? super Integer, ? extends CharSequence>) function1);
    }

    public static final byte last(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$last");
        if (!(bArr.length == 0)) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Integer lastOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$lastOrNull");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(function1.invoke(Byte.valueOf(b2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull byte[] bArr, @NotNull Function2<? super Integer, ? super Byte, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int i2 = 0;
        for (byte b2 : bArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Byte.valueOf(b2)));
        }
        return arrayList;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Byte max(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$max");
        return maxOrNull(bArr);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Integer maxWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(iArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Byte min(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$min");
        return minOrNull(bArr);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Integer minWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(iArr, comparator);
    }

    public static final boolean none(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$none");
        return iArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final byte random(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(bArr.length == 0)) {
            return bArr[random.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte reduceRightIndexedOrNull(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> function3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte b2 = bArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            b2 = function3.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
        }
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Byte reduceRightOrNull(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte b2 = bArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            b2 = function2.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
        }
        return Byte.valueOf(b2);
    }

    @NotNull
    public static final List<Byte> reversed(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reversed");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$shuffle");
        shuffle(iArr, (Random) Random.Default);
    }

    @Nullable
    public static final Integer singleOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$singleOrNull");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    @NotNull
    public static final byte[] sliceArray(@NotNull byte[] bArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        byte[] bArr2 = new byte[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            bArr2[i2] = bArr[num.intValue()];
            i2++;
        }
        return bArr2;
    }

    @NotNull
    public static final List<Integer> sorted(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sorted");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Integer> sortedDescending(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedDescending");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Integer> sortedWith(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final long sum(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sum");
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    @NotNull
    public static final HashSet<Integer> toHashSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toHashSet");
        return (HashSet) toCollection(iArr, new HashSet(q.mapCapacity(iArr.length)));
    }

    @NotNull
    public static final List<Short> toMutableList(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Integer> toMutableSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toMutableSet");
        return (Set) toCollection(iArr, new LinkedHashSet(q.mapCapacity(iArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Integer>> withIndex(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$withIndex");
        return new IndexingIterable(new d(iArr));
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull byte[] bArr, @NotNull R[] rArr, @NotNull Function2<? super Byte, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Byte.valueOf(bArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean all(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (!function1.invoke(Long.valueOf(j)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$any");
        return !(jArr.length == 0);
    }

    @NotNull
    public static final Iterable<Short> asIterable(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$asIterable");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(sArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$3
            public final /* synthetic */ short[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Short> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Short> asSequence(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$asSequence");
        if (sArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Short>(sArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$3
            public final /* synthetic */ short[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Short> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(bArr.length), 16));
        for (byte b2 : bArr) {
            Pair pair = (Pair) function1.invoke(Byte.valueOf(b2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Byte> associateBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(bArr.length), 16));
        for (byte b2 : bArr) {
            linkedHashMap.put(function1.invoke(Byte.valueOf(b2)), Byte.valueOf(b2));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Short> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (short s : sArr) {
            m.put(function1.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (short s : sArr) {
            Pair pair = (Pair) function1.invoke(Short.valueOf(s));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    public static final double average(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (float f2 : fArr) {
            d2 += (double) f2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    public static final boolean contains(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "$this$contains");
        return indexOf(jArr, j) >= 0;
    }

    public static final int count(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Long> distinct(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(jArr));
    }

    @NotNull
    public static final List<Short> drop(@NotNull short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(sArr, t6.v.e.coerceAtLeast(sArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Short> dropLast(@NotNull short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(sArr, t6.v.e.coerceAtLeast(sArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Byte> dropLastWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Short> filter(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C filterIndexedTo(@NotNull short[] sArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Short, Boolean> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            short s = sArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Short.valueOf(s)).booleanValue()) {
                c2.add(Short.valueOf(s));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Short> filterNot(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!function1.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterNotTo(@NotNull long[] jArr, @NotNull C c2, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (!function1.invoke(Long.valueOf(j)).booleanValue()) {
                c2.add(Long.valueOf(j));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterTo(@NotNull long[] jArr, @NotNull C c2, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                c2.add(Long.valueOf(j));
            }
        }
        return c2;
    }

    @Nullable
    public static final Long firstOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$firstOrNull");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Byte.valueOf(b2)));
        }
        return arrayList;
    }

    public static final <R> R fold(@NotNull long[] jArr, R r, @NotNull Function2<? super R, ? super Long, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (long j : jArr) {
            r = (R) function2.invoke(r, Long.valueOf(j));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull long[] jArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Long, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Long.valueOf(j));
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull short[] sArr, R r, @NotNull Function2<? super Short, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Short.valueOf(sArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull short[] sArr, R r, @NotNull Function3<? super Integer, ? super Short, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull long[] jArr, @NotNull Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (long j : jArr) {
            function1.invoke(Long.valueOf(j));
        }
    }

    public static final void forEachIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Long.valueOf(j));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$indices");
        return new IntRange(0, getLastIndex(jArr));
    }

    public static final int getLastIndex(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$lastIndex");
        return jArr.length - 1;
    }

    @Nullable
    public static final Long getOrNull(@NotNull long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i2]);
    }

    public static final int indexOf(@NotNull byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$indexOf");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b2 == bArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Short.valueOf(sArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = sArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Short> intersect(@NotNull short[] sArr, @NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static /* synthetic */ Appendable joinTo$default(long[] jArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(jArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (Function1<? super Long, ? extends CharSequence>) ((i3 & 64) != 0 ? null : function1));
    }

    @NotNull
    public static final String joinToString(@NotNull long[] jArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(jArr, charSequence, charSequence6, charSequence5, i4, charSequence4, (Function1<? super Long, ? extends CharSequence>) function1);
    }

    public static final int lastIndexOf(@NotNull byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$lastIndexOf");
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (b2 == bArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @Nullable
    public static final Long lastOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$lastOrNull");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull short[] sArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Short, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Short.valueOf(s)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull short[] sArr, @NotNull C c2, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (short s : sArr) {
            c2.add(function1.invoke(Short.valueOf(s)));
        }
        return c2;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Short max(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$max");
        return maxOrNull(sArr);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Long maxWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(jArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Short min(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$min");
        return minOrNull(sArr);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Long minWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(jArr, comparator);
    }

    public static final boolean none(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$none");
        return jArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Short randomOrNull(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.nextInt(sArr.length)]);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte reduceIndexedOrNull(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> function3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                b2 = function3.invoke(Integer.valueOf(i2), Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Byte reduceOrNull(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                b2 = function2.invoke(Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final byte reduceRight(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b2 = bArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                b2 = function2.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceRightIndexed(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> function3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b2 = bArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                b2 = function3.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final byte[] reversedArray(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reversedArray");
        int i2 = 0;
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            while (true) {
                bArr2[lastIndex - i2] = bArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return bArr2;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$shuffle");
        shuffle(jArr, (Random) Random.Default);
    }

    public static final byte single(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$single");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return bArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @Nullable
    public static final Long singleOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$singleOrNull");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Short> slice(@NotNull short[] sArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(sArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(sArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortDescending");
        if (sArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(sArr);
            reverse(sArr);
        }
    }

    @NotNull
    public static final List<Long> sorted(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sorted");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final short[] sortedArray(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedArray");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final short[] sortedArrayDescending(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortedArrayDescending");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> sortedBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Long> sortedDescending(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedDescending");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Long> sortedWith(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Short> subtract(@NotNull short[] sArr, @NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final float sum(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sum");
        float f2 = 0.0f;
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2;
    }

    public static final int sumBy(@NotNull short[] sArr, @NotNull Function1<? super Short, Integer> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (short s : sArr) {
            i2 += function1.invoke(Short.valueOf(s)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull short[] sArr, @NotNull Function1<? super Short, Double> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (short s : sArr) {
            d2 += function1.invoke(Short.valueOf(s)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final List<Byte> takeLastWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    @NotNull
    public static final List<Byte> takeWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (!function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Short>> C toCollection(@NotNull short[] sArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (short s : sArr) {
            c2.add(Short.valueOf(s));
        }
        return c2;
    }

    @NotNull
    public static final HashSet<Long> toHashSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toHashSet");
        return (HashSet) toCollection(jArr, new HashSet(q.mapCapacity(jArr.length)));
    }

    @NotNull
    public static final List<Byte> toList(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toList");
        int length = bArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(bArr);
        }
        return t6.n.d.listOf(Byte.valueOf(bArr[0]));
    }

    @NotNull
    public static final Set<Long> toMutableSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toMutableSet");
        return (Set) toCollection(jArr, new LinkedHashSet(q.mapCapacity(jArr.length)));
    }

    @NotNull
    public static final Set<Byte> toSet(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$toSet");
        int length = bArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(bArr, new LinkedHashSet(q.mapCapacity(bArr.length)));
        }
        return x.setOf(Byte.valueOf(bArr[0]));
    }

    @NotNull
    public static final Set<Short> union(@NotNull short[] sArr, @NotNull Iterable<Short> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Long>> withIndex(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$withIndex");
        return new IndexingIterable(new e(jArr));
    }

    public static final boolean all(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (!function1.invoke(Float.valueOf(f2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$any");
        return !(fArr.length == 0);
    }

    public static final double average(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$average");
        double d2 = 0.0d;
        int i2 = 0;
        for (double d3 : dArr) {
            d2 += d3;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / ((double) i2);
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "any { it == element }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final boolean contains(@NotNull float[] fArr, float f2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$contains");
        return indexOf(fArr, f2) >= 0;
    }

    public static final int count(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Float> distinct(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(fArr));
    }

    @NotNull
    public static final List<Byte> dropWhile(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (byte b2 : bArr) {
            if (z) {
                arrayList.add(Byte.valueOf(b2));
            } else if (!function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterNotTo(@NotNull float[] fArr, @NotNull C c2, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (!function1.invoke(Float.valueOf(f2)).booleanValue()) {
                c2.add(Float.valueOf(f2));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterTo(@NotNull float[] fArr, @NotNull C c2, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                c2.add(Float.valueOf(f2));
            }
        }
        return c2;
    }

    @Nullable
    public static final Float firstOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$firstOrNull");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R fold(@NotNull float[] fArr, R r, @NotNull Function2<? super R, ? super Float, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (float f2 : fArr) {
            r = (R) function2.invoke(r, Float.valueOf(f2));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull float[] fArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Float, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (float f2 : fArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Float.valueOf(f2));
        }
        return r;
    }

    public static final void forEach(@NotNull float[] fArr, @NotNull Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (float f2 : fArr) {
            function1.invoke(Float.valueOf(f2));
        }
    }

    public static final void forEachIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Unit> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (float f2 : fArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Float.valueOf(f2));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$indices");
        return new IntRange(0, getLastIndex(fArr));
    }

    public static final int getLastIndex(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$lastIndex");
        return fArr.length - 1;
    }

    @Nullable
    public static final Float getOrNull(@NotNull float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i2]);
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (byte b2 : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Byte.valueOf(b2));
        }
        return m;
    }

    public static /* synthetic */ Appendable joinTo$default(float[] fArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(fArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (Function1<? super Float, ? extends CharSequence>) ((i3 & 64) != 0 ? null : function1));
    }

    @NotNull
    public static final String joinToString(@NotNull float[] fArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(fArr, charSequence, charSequence6, charSequence5, i4, charSequence4, (Function1<? super Float, ? extends CharSequence>) function1);
    }

    @Nullable
    public static final Float lastOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$lastOrNull");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Integer max(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$max");
        return maxOrNull(iArr);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Float maxWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(fArr, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte maxWithOrNull(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) < 0) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Integer min(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$min");
        return minOrNull(iArr);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Float minWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(fArr, comparator);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte minWithOrNull(@NotNull byte[] bArr, @NotNull Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) > 0) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final boolean none(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$none");
        return fArr.length == 0;
    }

    public static final byte reduce(@NotNull byte[] bArr, @NotNull Function2<? super Byte, ? super Byte, Byte> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(bArr.length == 0)) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    b2 = function2.invoke(Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceIndexed(@NotNull byte[] bArr, @NotNull Function3<? super Integer, ? super Byte, ? super Byte, Byte> function3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(bArr.length == 0)) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    b2 = function3.invoke(Integer.valueOf(i2), Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reverse");
        int length = (bArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(bArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    byte b2 = bArr[i2];
                    bArr[i2] = bArr[lastIndex];
                    bArr[lastIndex] = b2;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$shuffle");
        shuffle(fArr, (Random) Random.Default);
    }

    @Nullable
    public static final Float singleOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$singleOrNull");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Float> sorted(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sorted");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> sortedBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Float> sortedDescending(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortedDescending");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Float> sortedWith(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final double sum(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sum");
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        return d2;
    }

    @NotNull
    public static final HashSet<Float> toHashSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toHashSet");
        return (HashSet) toCollection(fArr, new HashSet(q.mapCapacity(fArr.length)));
    }

    @NotNull
    public static final List<Integer> toMutableList(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Float> toMutableSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toMutableSet");
        return (Set) toCollection(fArr, new LinkedHashSet(q.mapCapacity(fArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Float>> withIndex(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$withIndex");
        return new IndexingIterable(new f(fArr));
    }

    public static final boolean all(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (!function1.invoke(Double.valueOf(d2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$any");
        return !(dArr.length == 0);
    }

    @NotNull
    public static final Iterable<Integer> asIterable(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$asIterable");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(iArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$4
            public final /* synthetic */ int[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Integer> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Integer> asSequence(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$asSequence");
        if (iArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Integer>(iArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$4
            public final /* synthetic */ int[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Integer> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Integer> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (int i2 : iArr) {
            m.put(function1.invoke(Integer.valueOf(i2)), Integer.valueOf(i2));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i2 : iArr) {
            Pair pair = (Pair) function1.invoke(Integer.valueOf(i2));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "any { it == element }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final boolean contains(@NotNull double[] dArr, double d2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$contains");
        return indexOf(dArr, d2) >= 0;
    }

    public static final int count(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Double> distinct(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(dArr));
    }

    @NotNull
    public static final <K> List<Byte> distinctBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (hashSet.add(function1.invoke(Byte.valueOf(b2)))) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Integer> drop(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(iArr, t6.v.e.coerceAtLeast(iArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Integer> dropLast(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(iArr, t6.v.e.coerceAtLeast(iArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Integer> filter(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Short> filterIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, Boolean> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            short s = sArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C filterIndexedTo(@NotNull int[] iArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Integer.valueOf(i4)).booleanValue()) {
                c2.add(Integer.valueOf(i4));
            }
            i2++;
            i3 = i5;
        }
        return c2;
    }

    @NotNull
    public static final List<Integer> filterNot(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterNotTo(@NotNull double[] dArr, @NotNull C c2, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (!function1.invoke(Double.valueOf(d2)).booleanValue()) {
                c2.add(Double.valueOf(d2));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterTo(@NotNull double[] dArr, @NotNull C c2, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                c2.add(Double.valueOf(d2));
            }
        }
        return c2;
    }

    public static final short first(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$first");
        if (!(sArr.length == 0)) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Double firstOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$firstOrNull");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull short[] sArr, @NotNull C c2, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (short s : sArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Short.valueOf(s)));
        }
        return c2;
    }

    public static final <R> R fold(@NotNull double[] dArr, R r, @NotNull Function2<? super R, ? super Double, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (double d2 : dArr) {
            r = (R) function2.invoke(r, Double.valueOf(d2));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull double[] dArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Double, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (double d2 : dArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Double.valueOf(d2));
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull int[] iArr, R r, @NotNull Function2<? super Integer, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Integer.valueOf(iArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull int[] iArr, R r, @NotNull Function3<? super Integer, ? super Integer, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull double[] dArr, @NotNull Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (double d2 : dArr) {
            function1.invoke(Double.valueOf(d2));
        }
    }

    public static final void forEachIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Unit> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (double d2 : dArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Double.valueOf(d2));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$indices");
        return new IntRange(0, getLastIndex(dArr));
    }

    public static final int getLastIndex(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$lastIndex");
        return dArr.length - 1;
    }

    @Nullable
    public static final Double getOrNull(@NotNull double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i2]);
    }

    @NotNull
    public static final <K> Map<K, List<Byte>> groupBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b2 : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Byte.valueOf(b2));
        }
        return linkedHashMap;
    }

    public static final int indexOf(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "$this$indexOf");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (s == sArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Integer> intersect(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull byte[] bArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (byte b2 : bArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Byte.valueOf(b2)));
            } else {
                a3.append(String.valueOf((int) b2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static /* synthetic */ Appendable joinTo$default(double[] dArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(dArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final String joinToString(@NotNull double[] dArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(dArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(dArr, charSequence, charSequence6, charSequence5, i4, charSequence4, function1);
    }

    public static final short last(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$last");
        if (!(sArr.length == 0)) {
            return sArr[getLastIndex(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(@NotNull short[] sArr, short s) {
        Intrinsics.checkNotNullParameter(sArr, "$this$lastIndexOf");
        for (int length = sArr.length - 1; length >= 0; length--) {
            if (s == sArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @Nullable
    public static final Double lastOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$lastOrNull");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s : sArr) {
            arrayList.add(function1.invoke(Short.valueOf(s)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull short[] sArr, @NotNull Function2<? super Integer, ? super Short, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int i2 = 0;
        for (short s : sArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Short.valueOf(s)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull int[] iArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Integer, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (int i3 : iArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Integer.valueOf(i3)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull int[] iArr, @NotNull C c2, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i2 : iArr) {
            c2.add(function1.invoke(Integer.valueOf(i2)));
        }
        return c2;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Long max(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$max");
        return maxOrNull(jArr);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float maxOrNull(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$maxOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, fArr[i2].floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Double maxWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(dArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Long min(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$min");
        return minOrNull(jArr);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float minOrNull(@NotNull Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$minOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, fArr[i2].floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Double minWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(dArr, comparator);
    }

    public static final boolean none(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$none");
        return dArr.length == 0;
    }

    @SinceKotlin(version = "1.3")
    public static final short random(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(sArr.length == 0)) {
            return sArr[random.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer randomOrNull(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.nextInt(iArr.length)]);
    }

    @NotNull
    public static final List<Short> reversed(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reversed");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$shuffle");
        shuffle(dArr, Random.Default);
    }

    @Nullable
    public static final Double singleOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$singleOrNull");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Integer> slice(@NotNull int[] iArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(iArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(iArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final short[] sliceArray(@NotNull short[] sArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        short[] sArr2 = new short[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            sArr2[i2] = sArr[num.intValue()];
            i2++;
        }
        return sArr2;
    }

    @NotNull
    public static final List<Double> sorted(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sorted");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final int[] sortedArray(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedArray");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final int[] sortedArrayDescending(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortedArrayDescending");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> sortedBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Double> sortedDescending(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortedDescending");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Double> sortedWith(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Integer> subtract(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += function1.invoke(Integer.valueOf(i3)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull int[] iArr, @NotNull Function1<? super Integer, Double> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (int i2 : iArr) {
            d2 += function1.invoke(Integer.valueOf(i2)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final <C extends Collection<? super Integer>> C toCollection(@NotNull int[] iArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (int i2 : iArr) {
            c2.add(Integer.valueOf(i2));
        }
        return c2;
    }

    @NotNull
    public static final HashSet<Double> toHashSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toHashSet");
        return (HashSet) toCollection(dArr, new HashSet(q.mapCapacity(dArr.length)));
    }

    @NotNull
    public static final Set<Double> toMutableSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toMutableSet");
        return (Set) toCollection(dArr, new LinkedHashSet(q.mapCapacity(dArr.length)));
    }

    @NotNull
    public static final Set<Integer> union(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Double>> withIndex(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$withIndex");
        return new IndexingIterable(new g(dArr));
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull short[] sArr, @NotNull R[] rArr, @NotNull Function2<? super Short, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Short.valueOf(sArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean all(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (!function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$any");
        return !(zArr.length == 0);
    }

    public static final boolean contains(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "$this$contains");
        return indexOf(zArr, z) >= 0;
    }

    public static final int count(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Boolean> distinct(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(zArr));
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterNotTo(@NotNull boolean[] zArr, @NotNull C c2, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (!function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                c2.add(Boolean.valueOf(z));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterTo(@NotNull boolean[] zArr, @NotNull C c2, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                c2.add(Boolean.valueOf(z));
            }
        }
        return c2;
    }

    @Nullable
    public static final Boolean firstOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$firstOrNull");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    public static final <R> R fold(@NotNull boolean[] zArr, R r, @NotNull Function2<? super R, ? super Boolean, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (boolean z : zArr) {
            r = (R) function2.invoke(r, Boolean.valueOf(z));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull boolean[] zArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Boolean, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Boolean.valueOf(z));
        }
        return r;
    }

    public static final void forEach(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (boolean z : zArr) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    public static final void forEachIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Boolean.valueOf(z));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$indices");
        return new IntRange(0, getLastIndex(zArr));
    }

    public static final int getLastIndex(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$lastIndex");
        return zArr.length - 1;
    }

    @Nullable
    public static final Boolean getOrNull(@NotNull boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i2]);
    }

    public static /* synthetic */ Appendable joinTo$default(boolean[] zArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(zArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (i3 & 64) != 0 ? null : function1);
    }

    @NotNull
    public static final String joinToString(@NotNull boolean[] zArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(zArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(zArr, charSequence, charSequence6, charSequence5, i4, charSequence4, function1);
    }

    @Nullable
    public static final Boolean lastOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$lastOrNull");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Float max(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$max");
        return maxOrNull(fArr);
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Byte maxBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        Comparable comparable = (Comparable) function1.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Byte.valueOf(b3));
                if (comparable.compareTo(comparable2) < 0) {
                    b2 = b3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Byte maxByOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        Comparable comparable = (Comparable) function1.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Byte.valueOf(b3));
                if (comparable.compareTo(comparable2) < 0) {
                    b2 = b3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Boolean maxWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(zArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Float min(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$min");
        return minOrNull(fArr);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Byte minBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        Comparable comparable = (Comparable) function1.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Byte.valueOf(b3));
                if (comparable.compareTo(comparable2) > 0) {
                    b2 = b3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Byte minByOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        Comparable comparable = (Comparable) function1.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Byte.valueOf(b3));
                if (comparable.compareTo(comparable2) > 0) {
                    b2 = b3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Boolean minWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(zArr, comparator);
    }

    public static final boolean none(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$none");
        return zArr.length == 0;
    }

    @NotNull
    public static final Pair<List<Byte>, List<Byte>> partition(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            } else {
                arrayList2.add(Byte.valueOf(b2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short reduceRightIndexedOrNull(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> function3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short s = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s = function3.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i2]), Short.valueOf(s)).shortValue();
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Short reduceRightOrNull(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short s = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s = function2.invoke(Short.valueOf(sArr[i2]), Short.valueOf(s)).shortValue();
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$shuffle");
        shuffle(zArr, Random.Default);
    }

    @Nullable
    public static final Boolean singleOrNull(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$singleOrNull");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    public static final void sortDescending(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortDescending");
        if (iArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(iArr);
            reverse(iArr);
        }
    }

    @NotNull
    public static final List<Character> sorted(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sorted");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        Objects.requireNonNull(typedArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt___ArraysJvmKt.sort(typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Character> sortedDescending(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortedDescending");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    @NotNull
    public static final List<Boolean> sortedWith(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Boolean[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(zArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final List<Byte> take(@NotNull byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= bArr.length) {
                return toList(bArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Byte.valueOf(bArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (byte b2 : bArr) {
                arrayList.add(Byte.valueOf(b2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Byte> takeLast(@NotNull byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = bArr.length;
            if (i2 >= length) {
                return toList(bArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Byte.valueOf(bArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Byte.valueOf(bArr[i3]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final HashSet<Boolean> toHashSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toHashSet");
        return (HashSet) toCollection(zArr, new HashSet(q.mapCapacity(zArr.length)));
    }

    @NotNull
    public static final List<Long> toMutableList(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @NotNull
    public static final Set<Boolean> toMutableSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toMutableSet");
        return (Set) toCollection(zArr, new LinkedHashSet(q.mapCapacity(zArr.length)));
    }

    @NotNull
    public static final Iterable<IndexedValue<Boolean>> withIndex(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$withIndex");
        return new IndexingIterable(new h(zArr));
    }

    public static final boolean all(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$all");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c2 : cArr) {
            if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$any");
        return !(cArr.length == 0);
    }

    @NotNull
    public static final Iterable<Long> asIterable(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$asIterable");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(jArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$5
            public final /* synthetic */ long[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Long> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Long> asSequence(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$asSequence");
        if (jArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Long>(jArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$5
            public final /* synthetic */ long[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Long> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            Pair pair = (Pair) function1.invoke(Short.valueOf(s));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Short> associateBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(function1.invoke(Short.valueOf(s)), Short.valueOf(s));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Long> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (long j : jArr) {
            m.put(function1.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (long j : jArr) {
            Pair pair = (Pair) function1.invoke(Long.valueOf(j));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    public static final boolean contains(@NotNull char[] cArr, char c2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$contains");
        return indexOf(cArr, c2) >= 0;
    }

    public static final int count(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$count");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i2 = 0;
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    @NotNull
    public static final List<Character> distinct(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$distinct");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(cArr));
    }

    @NotNull
    public static final List<Long> drop(@NotNull long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(jArr, t6.v.e.coerceAtLeast(jArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Long> dropLast(@NotNull long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(jArr, t6.v.e.coerceAtLeast(jArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Short> dropLastWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Long> filter(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C filterIndexedTo(@NotNull long[] jArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Long, Boolean> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            long j = jArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Long.valueOf(j)).booleanValue()) {
                c2.add(Long.valueOf(j));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Long> filterNot(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!function1.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterNotTo(@NotNull char[] cArr, @NotNull C c2, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$filterNotTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c3 : cArr) {
            if (!function1.invoke(Character.valueOf(c3)).booleanValue()) {
                c2.add(Character.valueOf(c3));
            }
        }
        return c2;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterTo(@NotNull char[] cArr, @NotNull C c2, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$filterTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c3 : cArr) {
            if (function1.invoke(Character.valueOf(c3)).booleanValue()) {
                c2.add(Character.valueOf(c3));
            }
        }
        return c2;
    }

    @Nullable
    public static final Character firstOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$firstOrNull");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Short.valueOf(s)));
        }
        return arrayList;
    }

    public static final <R> R fold(@NotNull char[] cArr, R r, @NotNull Function2<? super R, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$fold");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (char c2 : cArr) {
            r = (R) function2.invoke(r, Character.valueOf(c2));
        }
        return r;
    }

    public static final <R> R foldIndexed(@NotNull char[] cArr, R r, @NotNull Function3<? super Integer, ? super R, ? super Character, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$foldIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 0;
        for (char c2 : cArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            r = (R) function3.invoke(valueOf, r, Character.valueOf(c2));
        }
        return r;
    }

    public static final <R> R foldRight(@NotNull long[] jArr, R r, @NotNull Function2<? super Long, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Long.valueOf(jArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull long[] jArr, R r, @NotNull Function3<? super Integer, ? super Long, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r);
        }
        return r;
    }

    public static final void forEach(@NotNull char[] cArr, @NotNull Function1<? super Character, Unit> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$forEach");
        Intrinsics.checkNotNullParameter(function1, "action");
        for (char c2 : cArr) {
            function1.invoke(Character.valueOf(c2));
        }
    }

    public static final void forEachIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Unit> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$forEachIndexed");
        Intrinsics.checkNotNullParameter(function2, "action");
        int i2 = 0;
        for (char c2 : cArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            function2.invoke(valueOf, Character.valueOf(c2));
        }
    }

    @NotNull
    public static final IntRange getIndices(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$indices");
        return new IntRange(0, getLastIndex(cArr));
    }

    public static final int getLastIndex(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$lastIndex");
        return cArr.length - 1;
    }

    @Nullable
    public static final Character getOrNull(@NotNull char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$getOrNull");
        if (i2 < 0 || i2 > getLastIndex(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i2]);
    }

    public static final int indexOf(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 == iArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = jArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Long> intersect(@NotNull long[] jArr, @NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static /* synthetic */ Appendable joinTo$default(char[] cArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        String str = (i3 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return joinTo(cArr, appendable, str, charSequence6, charSequence5, (i3 & 16) != 0 ? -1 : i2, (i3 & 32) != 0 ? "..." : charSequence4, (Function1<? super Character, ? extends CharSequence>) ((i3 & 64) != 0 ? null : function1));
    }

    @NotNull
    public static final String joinToString(@NotNull char[] cArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$joinToString");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb = ((StringBuilder) joinTo(cArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String joinToString$default(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i3 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i3 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(cArr, charSequence, charSequence6, charSequence5, i4, charSequence4, (Function1<? super Character, ? extends CharSequence>) function1);
    }

    public static final int lastIndexOf(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$lastIndexOf");
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (i2 == iArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @Nullable
    public static final Character lastOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$lastOrNull");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull long[] jArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Long, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Long.valueOf(j)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull long[] jArr, @NotNull C c2, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (long j : jArr) {
            c2.add(function1.invoke(Long.valueOf(j)));
        }
        return c2;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Double max(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$max");
        return maxOrNull(dArr);
    }

    @Nullable
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Character maxWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "$this$maxWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return maxWithOrNull(cArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Double min(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$min");
        return minOrNull(dArr);
    }

    @Nullable
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final Character minWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return minWithOrNull(cArr, comparator);
    }

    public static final boolean none(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$none");
        return cArr.length == 0;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long randomOrNull(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.nextInt(jArr.length)]);
    }

    public static final short reduceRight(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short s = sArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                s = function2.invoke(Short.valueOf(sArr[i2]), Short.valueOf(s)).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceRightIndexed(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> function3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            short s = sArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                s = function3.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i2]), Short.valueOf(s)).shortValue();
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final short[] reversedArray(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reversedArray");
        int i2 = 0;
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            while (true) {
                sArr2[lastIndex - i2] = sArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sArr2;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$shuffle");
        shuffle(cArr, (Random) Random.Default);
    }

    public static final short single(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$single");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return sArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @Nullable
    public static final Character singleOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$singleOrNull");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    @NotNull
    public static final List<Long> slice(@NotNull long[] jArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(jArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(jArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final long[] sortedArray(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedArray");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final long[] sortedArrayDescending(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortedArrayDescending");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> sortedBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortedBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareBy$2(function1));
    }

    @NotNull
    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortedByDescending");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1));
    }

    @NotNull
    public static final List<Character> sortedWith(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortedWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    @NotNull
    public static final Set<Long> subtract(@NotNull long[] jArr, @NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(@NotNull long[] jArr, @NotNull Function1<? super Long, Integer> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (long j : jArr) {
            i2 += function1.invoke(Long.valueOf(j)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull long[] jArr, @NotNull Function1<? super Long, Double> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (long j : jArr) {
            d2 += function1.invoke(Long.valueOf(j)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final List<Short> takeLastWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    @NotNull
    public static final List<Short> takeWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (!function1.invoke(Short.valueOf(s)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Long>> C toCollection(@NotNull long[] jArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (long j : jArr) {
            c2.add(Long.valueOf(j));
        }
        return c2;
    }

    @NotNull
    public static final HashSet<Character> toHashSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toHashSet");
        return (HashSet) toCollection(cArr, new HashSet(q.mapCapacity(t6.v.e.coerceAtMost(cArr.length, 128))));
    }

    @NotNull
    public static final List<Short> toList(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toList");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(sArr);
        }
        return t6.n.d.listOf(Short.valueOf(sArr[0]));
    }

    @NotNull
    public static final Set<Character> toMutableSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toMutableSet");
        return (Set) toCollection(cArr, new LinkedHashSet(q.mapCapacity(t6.v.e.coerceAtMost(cArr.length, 128))));
    }

    @NotNull
    public static final Set<Short> toSet(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$toSet");
        int length = sArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(sArr, new LinkedHashSet(q.mapCapacity(sArr.length)));
        }
        return x.setOf(Short.valueOf(sArr[0]));
    }

    @NotNull
    public static final Set<Long> union(@NotNull long[] jArr, @NotNull Iterable<Long> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final Iterable<IndexedValue<Character>> withIndex(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$withIndex");
        return new IndexingIterable(new i(cArr));
    }

    public static final <T> boolean any(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<Integer> filterIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Integer.valueOf(i4)).booleanValue()) {
                arrayList.add(Integer.valueOf(i4));
            }
            i2++;
            i3 = i5;
        }
        return arrayList;
    }

    public static final int first(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$first");
        if (!(iArr.length == 0)) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final <T> T firstOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull int[] iArr, @NotNull C c2, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (int i2 : iArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Integer.valueOf(i2)));
        }
        return c2;
    }

    public static final int last(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$last");
        if (!(iArr.length == 0)) {
            return iArr[getLastIndex(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final <T> T lastOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        T t;
        Intrinsics.checkNotNullParameter(tArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = tArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            t = tArr[length];
        } while (!function1.invoke(t).booleanValue());
        return t;
    }

    @NotNull
    public static final <R> List<R> map(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(function1.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int i2 = 0;
        for (int i3 : iArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Integer.valueOf(i3)));
        }
        return arrayList;
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Character max(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$max");
        return maxOrNull(cArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    @Nullable
    public static final Character min(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$min");
        return minOrNull(cArr);
    }

    public static final <T> boolean none(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final int random(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(iArr.length == 0)) {
            return iArr[random.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short reduceIndexedOrNull(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> function3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                s = function3.invoke(Integer.valueOf(i2), Short.valueOf(s), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Short reduceOrNull(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                s = function2.invoke(Short.valueOf(s), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @NotNull
    public static final List<Integer> reversed(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reversed");
        if (iArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> void shuffle(@NotNull T[] tArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(tArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            T t = tArr[lastIndex];
            tArr[lastIndex] = tArr[nextInt];
            tArr[nextInt] = t;
        }
    }

    @Nullable
    public static final <T> T singleOrNull(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (function1.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (!z) {
            return null;
        }
        return t;
    }

    @NotNull
    public static final int[] sliceArray(@NotNull int[] iArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        int[] iArr2 = new int[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            iArr2[i2] = iArr[num.intValue()];
            i2++;
        }
        return iArr2;
    }

    @NotNull
    public static final List<Float> toMutableList(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull int[] iArr, @NotNull R[] rArr, @NotNull Function2<? super Integer, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Integer.valueOf(iArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Float> asIterable(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$asIterable");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(fArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$6
            public final /* synthetic */ float[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Float> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Float> asSequence(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$asSequence");
        if (fArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Float>(fArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$6
            public final /* synthetic */ float[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Float> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Float> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (float f2 : fArr) {
            m.put(function1.invoke(Float.valueOf(f2)), Float.valueOf(f2));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (float f2 : fArr) {
            Pair pair = (Pair) function1.invoke(Float.valueOf(f2));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final List<Float> drop(@NotNull float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(fArr, t6.v.e.coerceAtLeast(fArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Float> dropLast(@NotNull float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(fArr, t6.v.e.coerceAtLeast(fArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Short> dropWhile(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (short s : sArr) {
            if (z) {
                arrayList.add(Short.valueOf(s));
            } else if (!function1.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filter(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C filterIndexedTo(@NotNull float[] fArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Float, Boolean> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Float.valueOf(f2)).booleanValue()) {
                c2.add(Float.valueOf(f2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Float> filterNot(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (!function1.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Byte firstOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                return Byte.valueOf(b2);
            }
        }
        return null;
    }

    public static final <R> R foldRight(@NotNull float[] fArr, R r, @NotNull Function2<? super Float, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Float.valueOf(fArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull float[] fArr, R r, @NotNull Function3<? super Integer, ? super Float, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r);
        }
        return r;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return m;
    }

    public static final int indexOf(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "$this$indexOf");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (j == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Float.valueOf(fArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = fArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Float> intersect(@NotNull float[] fArr, @NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(fArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int lastIndexOf(@NotNull long[] jArr, long j) {
        Intrinsics.checkNotNullParameter(jArr, "$this$lastIndexOf");
        for (int length = jArr.length - 1; length >= 0; length--) {
            if (j == jArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull float[] fArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Float, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (float f2 : fArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Float.valueOf(f2)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull float[] fArr, @NotNull C c2, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (float f2 : fArr) {
            c2.add(function1.invoke(Float.valueOf(f2)));
        }
        return c2;
    }

    public static final boolean none(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Float randomOrNull(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(fArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.nextInt(fArr.length)]);
    }

    public static final short reduce(@NotNull short[] sArr, @NotNull Function2<? super Short, ? super Short, Short> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(sArr.length == 0)) {
            short s = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (1 <= lastIndex) {
                while (true) {
                    s = function2.invoke(Short.valueOf(s), Short.valueOf(sArr[i2])).shortValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final short reduceIndexed(@NotNull short[] sArr, @NotNull Function3<? super Integer, ? super Short, ? super Short, Short> function3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(sArr.length == 0)) {
            short s = sArr[0];
            int lastIndex = getLastIndex(sArr);
            if (1 <= lastIndex) {
                while (true) {
                    s = function3.invoke(Integer.valueOf(i2), Short.valueOf(s), Short.valueOf(sArr[i2])).shortValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return s;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reverse");
        int length = (sArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(sArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    short s = sArr[i2];
                    sArr[i2] = sArr[lastIndex];
                    sArr[lastIndex] = s;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    public static final List<Float> slice(@NotNull float[] fArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(fArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(fArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortDescending");
        if (jArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(jArr);
            reverse(jArr);
        }
    }

    @NotNull
    public static final float[] sortedArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortedArray");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final float[] sortedArrayDescending(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortedArrayDescending");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Float> subtract(@NotNull float[] fArr, @NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(fArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(@NotNull float[] fArr, @NotNull Function1<? super Float, Integer> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (float f2 : fArr) {
            i2 += function1.invoke(Float.valueOf(f2)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull float[] fArr, @NotNull Function1<? super Float, Double> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (float f2 : fArr) {
            d2 += function1.invoke(Float.valueOf(f2)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final <C extends Collection<? super Float>> C toCollection(@NotNull float[] fArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (float f2 : fArr) {
            c2.add(Float.valueOf(f2));
        }
        return c2;
    }

    @NotNull
    public static final Set<Float> union(@NotNull float[] fArr, @NotNull Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(fArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final boolean any(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final Short firstOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                return Short.valueOf(s);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short maxWithOrNull(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) < 0) {
                    s = s2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short minWithOrNull(@NotNull short[] sArr, @NotNull Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                if (comparator.compare(Short.valueOf(s), Short.valueOf(s2)) > 0) {
                    s = s2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    public static final boolean none(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer reduceRightIndexedOrNull(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int i2 = iArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            i2 = function3.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
        }
        return Integer.valueOf(i2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer reduceRightOrNull(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int i2 = iArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            i2 = function2.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    public static final Byte singleOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Byte b2 = null;
        boolean z = false;
        for (byte b3 : bArr) {
            if (function1.invoke(Byte.valueOf(b3)).booleanValue()) {
                if (z) {
                    return null;
                }
                b2 = Byte.valueOf(b3);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return b2;
    }

    @NotNull
    public static final List<Double> toMutableList(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d2 : dArr) {
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Double> asIterable(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$asIterable");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(dArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$7
            public final /* synthetic */ double[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Double> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Double> asSequence(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$asSequence");
        if (dArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Double>(dArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$7
            public final /* synthetic */ double[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Double> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(iArr.length), 16));
        for (int i2 : iArr) {
            Pair pair = (Pair) function1.invoke(Integer.valueOf(i2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Integer> associateBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(iArr.length), 16));
        for (int i2 : iArr) {
            linkedHashMap.put(function1.invoke(Integer.valueOf(i2)), Integer.valueOf(i2));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Double> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (double d2 : dArr) {
            m.put(function1.invoke(Double.valueOf(d2)), Double.valueOf(d2));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (double d2 : dArr) {
            Pair pair = (Pair) function1.invoke(Double.valueOf(d2));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final <K> List<Short> distinctBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s : sArr) {
            if (hashSet.add(function1.invoke(Short.valueOf(s)))) {
                arrayList.add(Short.valueOf(s));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> drop(@NotNull double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(dArr, t6.v.e.coerceAtLeast(dArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Double> dropLast(@NotNull double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(dArr, t6.v.e.coerceAtLeast(dArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Integer> dropLastWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Double> filter(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> filterIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, Boolean> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            long j = jArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C filterIndexedTo(@NotNull double[] dArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Double, Boolean> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            double d2 = dArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Double.valueOf(d2)).booleanValue()) {
                c2.add(Double.valueOf(d2));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Double> filterNot(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (!function1.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    public static final long first(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$first");
        if (!(jArr.length == 0)) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Integer firstOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return Integer.valueOf(i2);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull long[] jArr, @NotNull C c2, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (long j : jArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Long.valueOf(j)));
        }
        return c2;
    }

    public static final <R> R foldRight(@NotNull double[] dArr, R r, @NotNull Function2<? super Double, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Double.valueOf(dArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull double[] dArr, R r, @NotNull Function3<? super Integer, ? super Double, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r);
        }
        return r;
    }

    @NotNull
    public static final <K> Map<K, List<Short>> groupBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Short.valueOf(s));
        }
        return linkedHashMap;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfFirst { it == element }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final int indexOf(@NotNull float[] fArr, float f2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$indexOf");
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (f2 == fArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Double.valueOf(dArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = dArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Double> intersect(@NotNull double[] dArr, @NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(dArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final long last(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$last");
        if (!(jArr.length == 0)) {
            return jArr[getLastIndex(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfLast { it == element }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final int lastIndexOf(@NotNull float[] fArr, float f2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$lastIndexOf");
        for (int length = fArr.length - 1; length >= 0; length--) {
            if (f2 == fArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @Nullable
    public static final Byte lastOrNull(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        byte b2;
        Intrinsics.checkNotNullParameter(bArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = bArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            b2 = bArr[length];
        } while (!function1.invoke(Byte.valueOf(b2)).booleanValue());
        return Byte.valueOf(b2);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j : jArr) {
            arrayList.add(function1.invoke(Long.valueOf(j)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull long[] jArr, @NotNull Function2<? super Integer, ? super Long, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int i2 = 0;
        for (long j : jArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Long.valueOf(j)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull double[] dArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Double, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (double d2 : dArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Double.valueOf(d2)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull double[] dArr, @NotNull C c2, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (double d2 : dArr) {
            c2.add(function1.invoke(Double.valueOf(d2)));
        }
        return c2;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T extends Comparable<? super T>> T maxOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$maxOrNull");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (t.compareTo(t2) < 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <T extends Comparable<? super T>> T minOrNull(@NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$minOrNull");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final boolean none(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final long random(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(jArr.length == 0)) {
            return jArr[random.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Double randomOrNull(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(dArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[random.nextInt(dArr.length)]);
    }

    public static final int reduceRight(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i2 = iArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                i2 = function2.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i2 = iArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                i2 = function3.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final List<Long> reversed(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reversed");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final int[] reversedArray(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reversedArray");
        int i2 = 0;
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            while (true) {
                iArr2[lastIndex - i2] = iArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return iArr2;
    }

    public static final int single(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$single");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return iArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @NotNull
    public static final List<Double> slice(@NotNull double[] dArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(dArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(dArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final long[] sliceArray(@NotNull long[] jArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        long[] jArr2 = new long[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            jArr2[i2] = jArr[num.intValue()];
            i2++;
        }
        return jArr2;
    }

    @NotNull
    public static final double[] sortedArray(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortedArray");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final double[] sortedArrayDescending(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortedArrayDescending");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Double> subtract(@NotNull double[] dArr, @NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(dArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(@NotNull double[] dArr, @NotNull Function1<? super Double, Integer> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (double d2 : dArr) {
            i2 += function1.invoke(Double.valueOf(d2)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull double[] dArr, @NotNull Function1<? super Double, Double> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += function1.invoke(Double.valueOf(d3)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final List<Integer> takeLastWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    @NotNull
    public static final List<Integer> takeWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Double>> C toCollection(@NotNull double[] dArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (double d2 : dArr) {
            c2.add(Double.valueOf(d2));
        }
        return c2;
    }

    @NotNull
    public static final List<Integer> toList(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toList");
        int length = iArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(iArr);
        }
        return t6.n.d.listOf(Integer.valueOf(iArr[0]));
    }

    @NotNull
    public static final Set<Integer> toSet(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$toSet");
        int length = iArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(iArr, new LinkedHashSet(q.mapCapacity(iArr.length)));
        }
        return x.setOf(Integer.valueOf(iArr[0]));
    }

    @NotNull
    public static final Set<Double> union(@NotNull double[] dArr, @NotNull Iterable<Double> iterable) {
        Intrinsics.checkNotNullParameter(dArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull long[] jArr, @NotNull R[] rArr, @NotNull Function2<? super Long, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Long.valueOf(jArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final Long firstOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                return Long.valueOf(j);
            }
        }
        return null;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull short[] sArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (short s : sArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Short.valueOf(s)));
            } else {
                a3.append(String.valueOf((int) s));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static final boolean none(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final void sortDescending(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortDescending");
        if (fArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(fArr);
            reverse(fArr);
        }
    }

    @NotNull
    public static final List<Boolean> toMutableList(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Boolean> asIterable(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$asIterable");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(zArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$8
            public final /* synthetic */ boolean[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Boolean> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Boolean> asSequence(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$asSequence");
        if (zArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Boolean>(zArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$8
            public final /* synthetic */ boolean[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Boolean> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (boolean z : zArr) {
            m.put(function1.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (boolean z : zArr) {
            Pair pair = (Pair) function1.invoke(Boolean.valueOf(z));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final List<Boolean> drop(@NotNull boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(zArr, t6.v.e.coerceAtLeast(zArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Boolean> dropLast(@NotNull boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(zArr, t6.v.e.coerceAtLeast(zArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Boolean> filter(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(@NotNull boolean[] zArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            boolean z = zArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Boolean.valueOf(z)).booleanValue()) {
                c2.add(Boolean.valueOf(z));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Boolean> filterNot(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Float firstOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                return Float.valueOf(f2);
            }
        }
        return null;
    }

    public static final <R> R foldRight(@NotNull boolean[] zArr, R r, @NotNull Function2<? super Boolean, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Boolean.valueOf(zArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull boolean[] zArr, R r, @NotNull Function3<? super Integer, ? super Boolean, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r);
        }
        return r;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfFirst { it == element }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final int indexOf(@NotNull double[] dArr, double d2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$indexOf");
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (d2 == dArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Boolean.valueOf(zArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Boolean> intersect(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> iterable) {
        Intrinsics.checkNotNullParameter(zArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    @Deprecated(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @ReplaceWith(expression = "indexOfLast { it == element }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final int lastIndexOf(@NotNull double[] dArr, double d2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$lastIndexOf");
        for (int length = dArr.length - 1; length >= 0; length--) {
            if (d2 == dArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull boolean[] zArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Boolean.valueOf(z)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull boolean[] zArr, @NotNull C c2, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (boolean z : zArr) {
            c2.add(function1.invoke(Boolean.valueOf(z)));
        }
        return c2;
    }

    public static final boolean none(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final Pair<List<Short>, List<Short>> partition(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                arrayList.add(Short.valueOf(s));
            } else {
                arrayList2.add(Short.valueOf(s));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Boolean randomOrNull(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(zArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[random.nextInt(zArr.length)]);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer reduceIndexedOrNull(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                i3 = function3.invoke(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer reduceOrNull(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                i3 = function2.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull byte[] bArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(bArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            byte b2 = bArr[lastIndex];
            bArr[lastIndex] = bArr[nextInt];
            bArr[nextInt] = b2;
        }
    }

    @Nullable
    public static final Short singleOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                if (z) {
                    return null;
                }
                sh = Short.valueOf(s);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return sh;
    }

    @NotNull
    public static final List<Boolean> slice(@NotNull boolean[] zArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(zArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(zArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    @NotNull
    public static final char[] sortedArray(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortedArray");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    @NotNull
    public static final char[] sortedArrayDescending(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortedArrayDescending");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        sortDescending(copyOf);
        return copyOf;
    }

    @NotNull
    public static final Set<Boolean> subtract(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> iterable) {
        Intrinsics.checkNotNullParameter(zArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Integer> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (boolean z : zArr) {
            i2 += function1.invoke(Boolean.valueOf(z)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Double> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (boolean z : zArr) {
            d2 += function1.invoke(Boolean.valueOf(z)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final List<Short> take(@NotNull short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= sArr.length) {
                return toList(sArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Short.valueOf(sArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (short s : sArr) {
                arrayList.add(Short.valueOf(s));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Short> takeLast(@NotNull short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = sArr.length;
            if (i2 >= length) {
                return toList(sArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Short.valueOf(sArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Short.valueOf(sArr[i3]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <C extends Collection<? super Boolean>> C toCollection(@NotNull boolean[] zArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (boolean z : zArr) {
            c2.add(Boolean.valueOf(z));
        }
        return c2;
    }

    @NotNull
    public static final Set<Boolean> union(@NotNull boolean[] zArr, @NotNull Iterable<Boolean> iterable) {
        Intrinsics.checkNotNullParameter(zArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final boolean any(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final List<Integer> dropWhile(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i2 : iArr) {
            if (z) {
                arrayList.add(Integer.valueOf(i2));
            } else if (!function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> filterIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, Boolean> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final float first(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$first");
        if (!(fArr.length == 0)) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Double firstOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                return Double.valueOf(d2);
            }
        }
        return null;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull float[] fArr, @NotNull C c2, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (float f2 : fArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Float.valueOf(f2)));
        }
        return c2;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (int i2 : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Integer.valueOf(i2));
        }
        return m;
    }

    public static final float last(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$last");
        if (!(fArr.length == 0)) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Short lastOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        short s;
        Intrinsics.checkNotNullParameter(sArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = sArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            s = sArr[length];
        } while (!function1.invoke(Short.valueOf(s)).booleanValue());
        return Short.valueOf(s);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(function1.invoke(Float.valueOf(f2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull float[] fArr, @NotNull Function2<? super Integer, ? super Float, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int i2 = 0;
        for (float f2 : fArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Float.valueOf(f2)));
        }
        return arrayList;
    }

    public static final boolean none(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.3")
    public static final float random(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(fArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(fArr.length == 0)) {
            return fArr[random.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int reduce(@NotNull int[] iArr, @NotNull Function2<? super Integer, ? super Integer, Integer> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(iArr.length == 0)) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    i3 = function2.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceIndexed(@NotNull int[] iArr, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, Integer> function3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(iArr.length == 0)) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    i3 = function3.invoke(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long reduceRightIndexedOrNull(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> function3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long j = jArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            j = function3.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]), Long.valueOf(j)).longValue();
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Long reduceRightOrNull(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long j = jArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            j = function2.invoke(Long.valueOf(jArr[i2]), Long.valueOf(j)).longValue();
        }
        return Long.valueOf(j);
    }

    public static final void reverse(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reverse");
        int length = (iArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(iArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    int i3 = iArr[i2];
                    iArr[i2] = iArr[lastIndex];
                    iArr[lastIndex] = i3;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    public static final List<Float> reversed(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reversed");
        if (fArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final float[] sliceArray(@NotNull float[] fArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        float[] fArr2 = new float[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            fArr2[i2] = fArr[num.intValue()];
            i2++;
        }
        return fArr2;
    }

    @NotNull
    public static final List<Character> toMutableList(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toMutableList");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull float[] fArr, @NotNull R[] rArr, @NotNull Function2<? super Float, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Float.valueOf(fArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    public static final boolean any(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final Iterable<Character> asIterable(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$asIterable");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new Object(cArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$9
            public final /* synthetic */ char[] a;

            {
                this.a = r1;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<Character> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    @NotNull
    public static final Sequence<Character> asSequence(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$asSequence");
        if (cArr.length == 0) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new Sequence<Character>(cArr) { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$9
            public final /* synthetic */ char[] a;

            {
                this.a = r1;
            }

            @Override // kotlin.sequences.Sequence
            @NotNull
            public Iterator<Character> iterator() {
                return ArrayIteratorsKt.iterator(this.a);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            Pair pair = (Pair) function1.invoke(Long.valueOf(j));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Long> associateBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(function1.invoke(Long.valueOf(j)), Long.valueOf(j));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super java.lang.Character> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (char c2 : cArr) {
            m.put(function1.invoke(Character.valueOf(c2)), Character.valueOf(c2));
        }
        return m;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$associateTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (char c2 : cArr) {
            Pair pair = (Pair) function1.invoke(Character.valueOf(c2));
            m.put(pair.getFirst(), pair.getSecond());
        }
        return m;
    }

    @NotNull
    public static final List<Character> drop(@NotNull char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$drop");
        if (i2 >= 0) {
            return takeLast(cArr, t6.v.e.coerceAtLeast(cArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Character> dropLast(@NotNull char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$dropLast");
        if (i2 >= 0) {
            return take(cArr, t6.v.e.coerceAtLeast(cArr.length - i2, 0));
        }
        throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
    }

    @NotNull
    public static final List<Long> dropLastWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Character> filter(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$filter");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C filterIndexedTo(@NotNull char[] cArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$filterIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c3 = cArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Character.valueOf(c3)).booleanValue()) {
                c2.add(Character.valueOf(c3));
            }
            i2++;
            i3 = i4;
        }
        return c2;
    }

    @NotNull
    public static final List<Character> filterNot(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$filterNot");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    @Nullable
    public static final Boolean firstOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Long.valueOf(j)));
        }
        return arrayList;
    }

    public static final <R> R foldRight(@NotNull char[] cArr, R r, @NotNull Function2<? super Character, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$foldRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r = (R) function2.invoke(Character.valueOf(cArr[lastIndex]), r);
        }
        return r;
    }

    public static final <R> R foldRightIndexed(@NotNull char[] cArr, R r, @NotNull Function3<? super Integer, ? super Character, ? super R, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$foldRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r = (R) function3.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r);
        }
        return r;
    }

    public static final int indexOf(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "$this$indexOf");
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (z == zArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$indexOfFirst");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (function1.invoke(Character.valueOf(cArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$indexOfLast");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (function1.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final Set<Character> intersect(@NotNull char[] cArr, @NotNull Iterable<Character> iterable) {
        Intrinsics.checkNotNullParameter(cArr, "$this$intersect");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        t6.n.h.retainAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int lastIndexOf(@NotNull boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "$this$lastIndexOf");
        for (int length = zArr.length - 1; length >= 0; length--) {
            if (z == zArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapIndexedTo(@NotNull char[] cArr, @NotNull C c2, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$mapIndexedTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int i2 = 0;
        for (char c3 : cArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            c2.add(function2.invoke(valueOf, Character.valueOf(c3)));
        }
        return c2;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C mapTo(@NotNull char[] cArr, @NotNull C c2, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$mapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (char c3 : cArr) {
            c2.add(function1.invoke(Character.valueOf(c3)));
        }
        return c2;
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Short maxBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s);
        }
        Comparable comparable = (Comparable) function1.invoke(Short.valueOf(s));
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Short.valueOf(s2));
                if (comparable.compareTo(comparable2) < 0) {
                    s = s2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Short maxByOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s);
        }
        Comparable comparable = (Comparable) function1.invoke(Short.valueOf(s));
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Short.valueOf(s2));
                if (comparable.compareTo(comparable2) < 0) {
                    s = s2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Short minBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s);
        }
        Comparable comparable = (Comparable) function1.invoke(Short.valueOf(s));
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Short.valueOf(s2));
                if (comparable.compareTo(comparable2) > 0) {
                    s = s2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Short minByOrNull(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s);
        }
        Comparable comparable = (Comparable) function1.invoke(Short.valueOf(s));
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Short.valueOf(s2));
                if (comparable.compareTo(comparable2) > 0) {
                    s = s2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    public static final boolean none(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character randomOrNull(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(cArr, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[random.nextInt(cArr.length)]);
    }

    public static final long reduceRight(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j = jArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                j = function2.invoke(Long.valueOf(jArr[i2]), Long.valueOf(j)).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> function3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j = jArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                j = function3.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]), Long.valueOf(j)).longValue();
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final long[] reversedArray(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reversedArray");
        int i2 = 0;
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            while (true) {
                jArr2[lastIndex - i2] = jArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return jArr2;
    }

    public static final long single(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$single");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return jArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @NotNull
    public static final List<Character> slice(@NotNull char[] cArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(cArr, "$this$slice");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(cArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    public static final void sortDescending(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortDescending");
        if (dArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(dArr);
            reverse(dArr);
        }
    }

    @NotNull
    public static final Set<Character> subtract(@NotNull char[] cArr, @NotNull Iterable<Character> iterable) {
        Intrinsics.checkNotNullParameter(cArr, "$this$subtract");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        t6.n.h.removeAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final int sumBy(@NotNull char[] cArr, @NotNull Function1<? super Character, Integer> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sumBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 0;
        for (char c2 : cArr) {
            i2 += function1.invoke(Character.valueOf(c2)).intValue();
        }
        return i2;
    }

    public static final double sumByDouble(@NotNull char[] cArr, @NotNull Function1<? super Character, Double> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sumByDouble");
        Intrinsics.checkNotNullParameter(function1, "selector");
        double d2 = 0.0d;
        for (char c2 : cArr) {
            d2 += function1.invoke(Character.valueOf(c2)).doubleValue();
        }
        return d2;
    }

    @NotNull
    public static final List<Long> takeLastWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    @NotNull
    public static final List<Long> takeWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (!function1.invoke(Long.valueOf(j)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    @NotNull
    public static final <C extends Collection<? super Character>> C toCollection(@NotNull char[] cArr, @NotNull C c2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toCollection");
        Intrinsics.checkNotNullParameter(c2, "destination");
        for (char c3 : cArr) {
            c2.add(Character.valueOf(c3));
        }
        return c2;
    }

    @NotNull
    public static final List<Long> toList(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toList");
        int length = jArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(jArr);
        }
        return t6.n.d.listOf(Long.valueOf(jArr[0]));
    }

    @NotNull
    public static final Set<Long> toSet(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$toSet");
        int length = jArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(jArr, new LinkedHashSet(q.mapCapacity(jArr.length)));
        }
        return x.setOf(Long.valueOf(jArr[0]));
    }

    @NotNull
    public static final Set<Character> union(@NotNull char[] cArr, @NotNull Iterable<Character> iterable) {
        Intrinsics.checkNotNullParameter(cArr, "$this$union");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        t6.n.h.addAll(mutableSet, iterable);
        return mutableSet;
    }

    public static final boolean any(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$any");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final Character firstOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$firstOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                return Character.valueOf(c2);
            }
        }
        return null;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte maxOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$maxOrNull");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (b2 < b3) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer maxWithOrNull(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) < 0) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Byte minOrNull(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$minOrNull");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (b2 > b3) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer minWithOrNull(@NotNull int[] iArr, @NotNull Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) > 0) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final boolean none(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$none");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public static final Integer singleOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                if (z) {
                    return null;
                }
                num = Integer.valueOf(i2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return num;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(tArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (T t : tArr) {
            m.put(function1.invoke(t), function12.invoke(t));
        }
        return m;
    }

    @NotNull
    public static final <K> List<Integer> distinctBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (hashSet.add(function1.invoke(Integer.valueOf(i2)))) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> filterIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, Boolean> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            double d2 = dArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final double first(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$first");
        if (!(dArr.length == 0)) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull double[] dArr, @NotNull C c2, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (double d2 : dArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Double.valueOf(d2)));
        }
        return c2;
    }

    @NotNull
    public static final <K> Map<K, List<Integer>> groupBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Integer.valueOf(i2));
        }
        return linkedHashMap;
    }

    public static final int indexOf(@NotNull char[] cArr, char c2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$indexOf");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c2 == cArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final double last(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$last");
        if (!(dArr.length == 0)) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final int lastIndexOf(@NotNull char[] cArr, char c2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$lastIndexOf");
        for (int length = cArr.length - 1; length >= 0; length--) {
            if (c2 == cArr[length]) {
                return length;
            }
        }
        return -1;
    }

    @Nullable
    public static final Integer lastOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        int i2;
        Intrinsics.checkNotNullParameter(iArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = iArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            i2 = iArr[length];
        } while (!function1.invoke(Integer.valueOf(i2)).booleanValue());
        return Integer.valueOf(i2);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d2 : dArr) {
            arrayList.add(function1.invoke(Double.valueOf(d2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull double[] dArr, @NotNull Function2<? super Integer, ? super Double, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int i2 = 0;
        for (double d2 : dArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Double.valueOf(d2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static final double random(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(dArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(dArr.length == 0)) {
            return dArr[random.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final List<Double> reversed(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reversed");
        if (dArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final <T> List<T> slice(@NotNull T[] tArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(tArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(tArr[num.intValue()]);
        }
        return arrayList;
    }

    @NotNull
    public static final double[] sliceArray(@NotNull double[] dArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        double[] dArr2 = new double[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            dArr2[i2] = dArr[num.intValue()];
            i2++;
        }
        return dArr2;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull double[] dArr, @NotNull R[] rArr, @NotNull Function2<? super Double, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Double.valueOf(dArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long reduceIndexedOrNull(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> function3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                j = function3.invoke(Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Long reduceOrNull(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                j = function2.invoke(Long.valueOf(j), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float reduceRightIndexedOrNull(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float f2 = fArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            f2 = function3.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Float reduceRightOrNull(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float f2 = fArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            f2 = function2.invoke(Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull short[] sArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(sArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            short s = sArr[lastIndex];
            sArr[lastIndex] = sArr[nextInt];
            sArr[nextInt] = s;
        }
    }

    public static final void sortDescending(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortDescending");
        if (cArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(cArr);
            reverse(cArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(fArr.length), 16));
        for (float f2 : fArr) {
            Pair pair = (Pair) function1.invoke(Float.valueOf(f2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Float> associateBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(fArr.length), 16));
        for (float f2 : fArr) {
            linkedHashMap.put(function1.invoke(Float.valueOf(f2)), Float.valueOf(f2));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(bArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (byte b2 : bArr) {
            m.put(function1.invoke(Byte.valueOf(b2)), function12.invoke(Byte.valueOf(b2)));
        }
        return m;
    }

    @NotNull
    public static final List<Float> dropLastWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Long> dropWhile(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (long j : jArr) {
            if (z) {
                arrayList.add(Long.valueOf(j));
            } else if (!function1.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Float.valueOf(f2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return m;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull int[] iArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (int i4 : iArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Integer.valueOf(i4)));
            } else {
                a3.append(String.valueOf(i4));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static final long reduce(@NotNull long[] jArr, @NotNull Function2<? super Long, ? super Long, Long> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(jArr.length == 0)) {
            long j = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    j = function2.invoke(Long.valueOf(j), Long.valueOf(jArr[i2])).longValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceIndexed(@NotNull long[] jArr, @NotNull Function3<? super Integer, ? super Long, ? super Long, Long> function3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(jArr.length == 0)) {
            long j = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    j = function3.invoke(Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(jArr[i2])).longValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return j;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRight(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f2 = fArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                f2 = function2.invoke(Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f2 = fArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                f2 = function3.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reverse");
        int length = (jArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(jArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    long j = jArr[i2];
                    jArr[i2] = jArr[lastIndex];
                    jArr[lastIndex] = j;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    public static final float[] reversedArray(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reversedArray");
        int i2 = 0;
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            while (true) {
                fArr2[lastIndex - i2] = fArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return fArr2;
    }

    public static final float single(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$single");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return fArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @Nullable
    public static final Long singleOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                if (z) {
                    return null;
                }
                l = Long.valueOf(j);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return l;
    }

    @NotNull
    public static final List<Float> takeLastWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    @NotNull
    public static final List<Float> takeWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (!function1.invoke(Float.valueOf(f2)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> toList(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toList");
        int length = fArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(fArr);
        }
        return t6.n.d.listOf(Float.valueOf(fArr[0]));
    }

    @NotNull
    public static final Set<Float> toSet(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$toSet");
        int length = fArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(fArr, new LinkedHashSet(q.mapCapacity(fArr.length)));
        }
        return x.setOf(Float.valueOf(fArr[0]));
    }

    @NotNull
    public static final List<Boolean> filterIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            boolean z = zArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final boolean first(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$first");
        if (!(zArr.length == 0)) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull boolean[] zArr, @NotNull C c2, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (boolean z : zArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Boolean.valueOf(z)));
        }
        return c2;
    }

    public static final boolean last(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$last");
        if (!(zArr.length == 0)) {
            return zArr[getLastIndex(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Long lastOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        long j;
        Intrinsics.checkNotNullParameter(jArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = jArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            j = jArr[length];
        } while (!function1.invoke(Long.valueOf(j)).booleanValue());
        return Long.valueOf(j);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(function1.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull boolean[] zArr, @NotNull Function2<? super Integer, ? super Boolean, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int i2 = 0;
        for (boolean z : zArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Boolean.valueOf(z)));
        }
        return arrayList;
    }

    @NotNull
    public static final Pair<List<Integer>, List<Integer>> partition(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            } else {
                arrayList2.add(Integer.valueOf(i2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.3")
    public static final boolean random(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(zArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(zArr.length == 0)) {
            return zArr[random.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final List<Boolean> reversed(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reversed");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final boolean[] sliceArray(@NotNull boolean[] zArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        boolean[] zArr2 = new boolean[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            zArr2[i2] = zArr[num.intValue()];
            i2++;
        }
        return zArr2;
    }

    @NotNull
    public static final List<Integer> take(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= iArr.length) {
                return toList(iArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Integer.valueOf(iArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (int i4 : iArr) {
                arrayList.add(Integer.valueOf(i4));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Integer> takeLast(@NotNull int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = iArr.length;
            if (i2 >= length) {
                return toList(iArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Integer.valueOf(iArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Integer.valueOf(iArr[i3]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull boolean[] zArr, @NotNull R[] rArr, @NotNull Function2<? super Boolean, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Boolean.valueOf(zArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (short s : sArr) {
            m.put(function1.invoke(Short.valueOf(s)), function12.invoke(Short.valueOf(s)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short maxOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$maxOrNull");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                if (s < s2) {
                    s = s2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Short minOrNull(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$minOrNull");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s2 = sArr[i2];
                if (s > s2) {
                    s = s2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s);
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> void sortDescending(@NotNull T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sortWith(tArr, t6.o.a.reverseOrder(), i2, i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long maxWithOrNull(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) < 0) {
                    j = j2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long minWithOrNull(@NotNull long[] jArr, @NotNull Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                if (comparator.compare(Long.valueOf(j), Long.valueOf(j2)) > 0) {
                    j = j2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double reduceRightIndexedOrNull(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> function3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double d2 = dArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            d2 = function3.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
        }
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Double reduceRightOrNull(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double d2 = dArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            d2 = function2.invoke(Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
        }
        return Double.valueOf(d2);
    }

    @Nullable
    public static final Float singleOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Float f2 = null;
        boolean z = false;
        for (float f3 : fArr) {
            if (function1.invoke(Float.valueOf(f3)).booleanValue()) {
                if (z) {
                    return null;
                }
                f2 = Float.valueOf(f3);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return f2;
    }

    @NotNull
    public static final List<Byte> slice(@NotNull byte[] bArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Byte.valueOf(bArr[num.intValue()]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(bArr, i2, i3);
        reverse(bArr, i2, i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(dArr.length), 16));
        for (double d2 : dArr) {
            Pair pair = (Pair) function1.invoke(Double.valueOf(d2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Double> associateBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(dArr.length), 16));
        for (double d2 : dArr) {
            linkedHashMap.put(function1.invoke(Double.valueOf(d2)), Double.valueOf(d2));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (int i2 : iArr) {
            m.put(function1.invoke(Integer.valueOf(i2)), function12.invoke(Integer.valueOf(i2)));
        }
        return m;
    }

    @NotNull
    public static final <K> List<Long> distinctBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j : jArr) {
            if (hashSet.add(function1.invoke(Long.valueOf(j)))) {
                arrayList.add(Long.valueOf(j));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> dropLastWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final List<Character> filterIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, Boolean> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$filterIndexed");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = cArr[i2];
            int i4 = i3 + 1;
            if (function2.invoke(Integer.valueOf(i3), Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final char first(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$first");
        if (!(cArr.length == 0)) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Double.valueOf(d2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R, C extends Collection<? super R>> C flatMapTo(@NotNull char[] cArr, @NotNull C c2, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(c2, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        for (char c3 : cArr) {
            t6.n.h.addAll(c2, (Iterable) function1.invoke(Character.valueOf(c3)));
        }
        return c2;
    }

    @NotNull
    public static final <K> Map<K, List<Long>> groupBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Long.valueOf(j));
        }
        return linkedHashMap;
    }

    public static final char last(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$last");
        if (!(cArr.length == 0)) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @Nullable
    public static final Float lastOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        float f2;
        Intrinsics.checkNotNullParameter(fArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = fArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            f2 = fArr[length];
        } while (!function1.invoke(Float.valueOf(f2)).booleanValue());
        return Float.valueOf(f2);
    }

    @NotNull
    public static final <R> List<R> map(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(function1.invoke(Character.valueOf(c2)));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<R> mapIndexed(@NotNull char[] cArr, @NotNull Function2<? super Integer, ? super Character, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$mapIndexed");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int i2 = 0;
        for (char c2 : cArr) {
            Integer valueOf = Integer.valueOf(i2);
            i2++;
            arrayList.add(function2.invoke(valueOf, Character.valueOf(c2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(cArr, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        if (!(cArr.length == 0)) {
            return cArr[random.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float reduceIndexedOrNull(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = function3.invoke(Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Float reduceOrNull(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = function2.invoke(Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final double reduceRight(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d2 = dArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                d2 = function2.invoke(Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> function3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d2 = dArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                d2 = function3.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final List<Character> reversed(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reversed");
        if (cArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        j.reverse(mutableList);
        return mutableList;
    }

    @NotNull
    public static final double[] reversedArray(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reversedArray");
        int i2 = 0;
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            while (true) {
                dArr2[lastIndex - i2] = dArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return dArr2;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull int[] iArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(iArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            int i2 = iArr[lastIndex];
            iArr[lastIndex] = iArr[nextInt];
            iArr[nextInt] = i2;
        }
    }

    public static final double single(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$single");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return dArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @NotNull
    public static final char[] sliceArray(@NotNull char[] cArr, @NotNull Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(collection, "indices");
        char[] cArr2 = new char[collection.size()];
        int i2 = 0;
        for (Integer num : collection) {
            cArr2[i2] = cArr[num.intValue()];
            i2++;
        }
        return cArr2;
    }

    @NotNull
    public static final List<Double> takeLastWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    @NotNull
    public static final List<Double> takeWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (!function1.invoke(Double.valueOf(d2)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> toList(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toList");
        int length = dArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(dArr);
        }
        return t6.n.d.listOf(Double.valueOf(dArr[0]));
    }

    @NotNull
    public static final Set<Double> toSet(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$toSet");
        int length = dArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(dArr, new LinkedHashSet(q.mapCapacity(dArr.length)));
        }
        return x.setOf(Double.valueOf(dArr[0]));
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull char[] cArr, @NotNull R[] rArr, @NotNull Function2<? super Character, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Character.valueOf(cArr[i2]), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Float> dropWhile(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (float f2 : fArr) {
            if (z) {
                arrayList.add(Float.valueOf(f2));
            } else if (!function1.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (float f2 : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Float.valueOf(f2));
        }
        return m;
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Integer maxBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) function1.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Integer.valueOf(i4));
                if (comparable.compareTo(comparable2) < 0) {
                    i3 = i4;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Integer maxByOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) function1.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Integer.valueOf(i4));
                if (comparable.compareTo(comparable2) < 0) {
                    i3 = i4;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Integer minBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) function1.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Integer.valueOf(i4));
                if (comparable.compareTo(comparable2) > 0) {
                    i3 = i4;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Integer minByOrNull(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        Comparable comparable = (Comparable) function1.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Integer.valueOf(i4));
                if (comparable.compareTo(comparable2) > 0) {
                    i3 = i4;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final float reduce(@NotNull float[] fArr, @NotNull Function2<? super Float, ? super Float, Float> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(fArr.length == 0)) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f2 = function2.invoke(Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceIndexed(@NotNull float[] fArr, @NotNull Function3<? super Integer, ? super Float, ? super Float, Float> function3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(fArr.length == 0)) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f2 = function3.invoke(Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reverse");
        int length = (fArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(fArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    float f2 = fArr[i2];
                    fArr[i2] = fArr[lastIndex];
                    fArr[lastIndex] = f2;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(sArr, i2, i3);
        reverse(sArr, i2, i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(jArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (long j : jArr) {
            m.put(function1.invoke(Long.valueOf(j)), function12.invoke(Long.valueOf(j)));
        }
        return m;
    }

    @Nullable
    public static final Double singleOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Double d2 = null;
        boolean z = false;
        for (double d3 : dArr) {
            if (function1.invoke(Double.valueOf(d3)).booleanValue()) {
                if (z) {
                    return null;
                }
                d2 = Double.valueOf(d3);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return d2;
    }

    public static final <T> T first(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (T t : tArr) {
            if (function1.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull long[] jArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (long j : jArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Long.valueOf(j)));
            } else {
                a3.append(String.valueOf(j));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static final <T> T last(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        T t;
        Intrinsics.checkNotNullParameter(tArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = tArr.length;
        do {
            length--;
            if (length >= 0) {
                t = tArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(t).booleanValue());
        return t;
    }

    @Nullable
    public static final Double lastOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        double d2;
        Intrinsics.checkNotNullParameter(dArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = dArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            d2 = dArr[length];
        } while (!function1.invoke(Double.valueOf(d2)).booleanValue());
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer maxOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$maxOrNull");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 < i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Integer minOrNull(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$minOrNull");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean reduceRightIndexedOrNull(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> function3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean z = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            z = function3.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Boolean reduceRightOrNull(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean z = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            z = function2.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    @NotNull
    public static final <T> T[] sliceArray(@NotNull T[] tArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(tArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        return intRange.isEmpty() ? (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, 0, 0) : (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(iArr, i2, i3);
        reverse(iArr, i2, i3);
    }

    @NotNull
    public static final <T, R, V> List<V> zip(@NotNull T[] tArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(tArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(tArr[i2], obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            Pair pair = (Pair) function1.invoke(Boolean.valueOf(z));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Boolean> associateBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(function1.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(fArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (float f2 : fArr) {
            m.put(function1.invoke(Float.valueOf(f2)), function12.invoke(Float.valueOf(f2)));
        }
        return m;
    }

    @NotNull
    public static final List<Boolean> dropLastWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    @NotNull
    public static final Pair<List<Long>, List<Long>> partition(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                arrayList.add(Long.valueOf(j));
            } else {
                arrayList2.add(Long.valueOf(j));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean reduceRight(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean z = zArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                z = function2.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceRightIndexed(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> function3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            boolean z = zArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                z = function3.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final boolean[] reversedArray(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reversedArray");
        int i2 = 0;
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            while (true) {
                zArr2[lastIndex - i2] = zArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return zArr2;
    }

    public static final boolean single(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$single");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return zArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @NotNull
    public static final List<Short> slice(@NotNull short[] sArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Short.valueOf(sArr[num.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Long> take(@NotNull long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= jArr.length) {
                return toList(jArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Long.valueOf(jArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (long j : jArr) {
                arrayList.add(Long.valueOf(j));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Long> takeLast(@NotNull long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = jArr.length;
            if (i2 >= length) {
                return toList(jArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Long.valueOf(jArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Long.valueOf(jArr[i3]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Boolean> takeLastWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    @NotNull
    public static final List<Boolean> takeWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Boolean> toList(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toList");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(zArr);
        }
        return t6.n.d.listOf(Boolean.valueOf(zArr[0]));
    }

    @NotNull
    public static final Set<Boolean> toSet(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$toSet");
        int length = zArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(zArr, new LinkedHashSet(q.mapCapacity(zArr.length)));
        }
        return x.setOf(Boolean.valueOf(zArr[0]));
    }

    public static final byte first(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (byte b2 : bArr) {
            if (function1.invoke(Byte.valueOf(b2)).booleanValue()) {
                return b2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float maxWithOrNull(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) < 0) {
                    f2 = f3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float minWithOrNull(@NotNull float[] fArr, @NotNull Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) > 0) {
                    f2 = f3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double reduceIndexedOrNull(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> function3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = function3.invoke(Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Double reduceOrNull(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = function2.invoke(Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull long[] jArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(jArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            long j = jArr[lastIndex];
            jArr[lastIndex] = jArr[nextInt];
            jArr[nextInt] = j;
        }
    }

    @Nullable
    public static final Boolean singleOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (function1.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (z) {
                    return null;
                }
                bool = Boolean.valueOf(z2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return bool;
    }

    @NotNull
    public static final byte[] sliceArray(@NotNull byte[] bArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(bArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new byte[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(bArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(jArr, i2, i3);
        reverse(jArr, i2, i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(dArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (double d2 : dArr) {
            m.put(function1.invoke(Double.valueOf(d2)), function12.invoke(Double.valueOf(d2)));
        }
        return m;
    }

    @NotNull
    public static final <K> List<Float> distinctBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (hashSet.add(function1.invoke(Float.valueOf(f2)))) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final List<Double> dropWhile(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (double d2 : dArr) {
            if (z) {
                arrayList.add(Double.valueOf(d2));
            } else if (!function1.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Float>> groupBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Float.valueOf(f2));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (double d2 : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Double.valueOf(d2));
        }
        return m;
    }

    @Nullable
    public static final Boolean lastOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = zArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            z = zArr[length];
        } while (!function1.invoke(Boolean.valueOf(z)).booleanValue());
        return Boolean.valueOf(z);
    }

    public static final double reduce(@NotNull double[] dArr, @NotNull Function2<? super Double, ? super Double, Double> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(dArr.length == 0)) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d2 = function2.invoke(Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceIndexed(@NotNull double[] dArr, @NotNull Function3<? super Integer, ? super Double, ? super Double, Double> function3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(dArr.length == 0)) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d2 = function3.invoke(Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reverse");
        int length = (dArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(dArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    double d2 = dArr[i2];
                    dArr[i2] = dArr[lastIndex];
                    dArr[lastIndex] = d2;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static final short first(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                return s;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final byte last(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        byte b2;
        Intrinsics.checkNotNullParameter(bArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = bArr.length;
        do {
            length--;
            if (length >= 0) {
                b2 = bArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Byte.valueOf(b2)).booleanValue());
        return b2;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character reduceRightIndexedOrNull(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceRightIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char c2 = cArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            c2 = function3.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character reduceRightOrNull(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceRightOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char c2 = cArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            c2 = function2.invoke(Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
        }
        return Character.valueOf(c2);
    }

    @NotNull
    public static final short[] sliceArray(@NotNull short[] sArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(sArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new short[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(sArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(fArr, i2, i3);
        reverse(fArr, i2, i3);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull byte[] bArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Byte, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Byte.valueOf(bArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associate(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$associate");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(cArr.length), 16));
        for (char c2 : cArr) {
            Pair pair = (Pair) function1.invoke(Character.valueOf(c2));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K> Map<K, Character> associateBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(cArr.length), 16));
        for (char c2 : cArr) {
            linkedHashMap.put(function1.invoke(Character.valueOf(c2)), Character.valueOf(c2));
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(zArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (boolean z : zArr) {
            m.put(function1.invoke(Boolean.valueOf(z)), function12.invoke(Boolean.valueOf(z)));
        }
        return m;
    }

    @NotNull
    public static final List<Character> dropLastWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$dropLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public static final <R> List<R> flatMap(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$flatMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            t6.n.h.addAll(arrayList, (Iterable) function1.invoke(Character.valueOf(c2)));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long maxOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxOrNull");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                if (j < j2) {
                    j = j2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Long minOrNull(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minOrNull");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                if (j > j2) {
                    j = j2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    public static final char reduceRight(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceRight");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c2 = cArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                c2 = function2.invoke(Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceRightIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c2 = cArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                c2 = function3.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    @NotNull
    public static final char[] reversedArray(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reversedArray");
        int i2 = 0;
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            while (true) {
                cArr2[lastIndex - i2] = cArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return cArr2;
    }

    public static final char single(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    @Nullable
    public static final Character singleOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$singleOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(c2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    @NotNull
    public static final List<Character> takeLastWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$takeLastWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            if (!function1.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    @NotNull
    public static final List<Character> takeWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$takeWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Character> toList(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toList");
        int length = cArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length != 1) {
            return toMutableList(cArr);
        }
        return t6.n.d.listOf(Character.valueOf(cArr[0]));
    }

    @NotNull
    public static final Set<Character> toSet(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$toSet");
        int length = cArr.length;
        if (length == 0) {
            return y.emptySet();
        }
        if (length != 1) {
            return (Set) toCollection(cArr, new LinkedHashSet(q.mapCapacity(t6.v.e.coerceAtMost(cArr.length, 128))));
        }
        return x.setOf(Character.valueOf(cArr[0]));
    }

    public static final int first(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                return i2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @Nullable
    public static final Character lastOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        char c2;
        Intrinsics.checkNotNullParameter(cArr, "$this$lastOrNull");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = cArr.length;
        do {
            length--;
            if (length < 0) {
                return null;
            }
            c2 = cArr[length];
        } while (!function1.invoke(Character.valueOf(c2)).booleanValue());
        return Character.valueOf(c2);
    }

    @NotNull
    public static final List<Integer> slice(@NotNull int[] iArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Integer.valueOf(iArr[num.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final int[] sliceArray(@NotNull int[] iArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(iArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new int[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(iArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(dArr, i2, i3);
        reverse(dArr, i2, i3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: M extends java.util.Map<? super K, ? super V> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(cArr, "$this$associateByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (char c2 : cArr) {
            m.put(function1.invoke(Character.valueOf(c2)), function12.invoke(Character.valueOf(c2)));
        }
        return m;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull float[] fArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (float f2 : fArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Float.valueOf(f2)));
            } else {
                a3.append(String.valueOf(f2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Long maxBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j);
        }
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j));
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j2));
                if (comparable.compareTo(comparable2) < 0) {
                    j = j2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Long maxByOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j);
        }
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j));
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j2));
                if (comparable.compareTo(comparable2) < 0) {
                    j = j2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Long minBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j);
        }
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j));
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j2));
                if (comparable.compareTo(comparable2) > 0) {
                    j = j2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Long minByOrNull(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j);
        }
        Comparable comparable = (Comparable) function1.invoke(Long.valueOf(j));
        if (1 <= lastIndex) {
            while (true) {
                long j2 = jArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Long.valueOf(j2));
                if (comparable.compareTo(comparable2) > 0) {
                    j = j2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean reduceIndexedOrNull(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> function3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                z = function3.invoke(Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Boolean reduceOrNull(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                z = function2.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull float[] fArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(fArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            float f2 = fArr[lastIndex];
            fArr[lastIndex] = fArr[nextInt];
            fArr[nextInt] = f2;
        }
    }

    @NotNull
    public static final List<Boolean> dropWhile(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (boolean z2 : zArr) {
            if (z) {
                arrayList.add(Boolean.valueOf(z2));
            } else if (!function1.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
                z = true;
            }
        }
        return arrayList;
    }

    public static final long first(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return m;
    }

    public static final short last(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        short s;
        Intrinsics.checkNotNullParameter(sArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = sArr.length;
        do {
            length--;
            if (length >= 0) {
                s = sArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Short.valueOf(s)).booleanValue());
        return s;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double maxWithOrNull(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) < 0) {
                    d2 = d3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double minWithOrNull(@NotNull double[] dArr, @NotNull Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) > 0) {
                    d2 = d3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @NotNull
    public static final Pair<List<Float>, List<Float>> partition(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            } else {
                arrayList2.add(Float.valueOf(f2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final boolean reduce(@NotNull boolean[] zArr, @NotNull Function2<? super Boolean, ? super Boolean, Boolean> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(zArr.length == 0)) {
            boolean z = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (1 <= lastIndex) {
                while (true) {
                    z = function2.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final boolean reduceIndexed(@NotNull boolean[] zArr, @NotNull Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> function3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(zArr.length == 0)) {
            boolean z = zArr[0];
            int lastIndex = getLastIndex(zArr);
            if (1 <= lastIndex) {
                while (true) {
                    z = function3.invoke(Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return z;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reverse");
        int length = (zArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(zArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    boolean z = zArr[i2];
                    zArr[i2] = zArr[lastIndex];
                    zArr[lastIndex] = z;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @NotNull
    public static final long[] sliceArray(@NotNull long[] jArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(jArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new long[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(jArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @SinceKotlin(version = "1.4")
    public static final void sortDescending(@NotNull char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sortDescending");
        ArraysKt___ArraysJvmKt.sort(cArr, i2, i3);
        reverse(cArr, i2, i3);
    }

    @NotNull
    public static final List<Float> take(@NotNull float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= fArr.length) {
                return toList(fArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Float.valueOf(fArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (float f2 : fArr) {
                arrayList.add(Float.valueOf(f2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Float> takeLast(@NotNull float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = fArr.length;
            if (i2 >= length) {
                return toList(fArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Float.valueOf(fArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Float.valueOf(fArr[i3]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull short[] sArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Short, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Short.valueOf(sArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T, K, V> Map<K, V> associateBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(tArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(tArr.length), 16));
        for (T t : tArr) {
            linkedHashMap.put(function1.invoke(t), function12.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> List<Double> distinctBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (hashSet.add(function1.invoke(Double.valueOf(d2)))) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Double>> groupBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d2 : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Double.valueOf(d2));
        }
        return linkedHashMap;
    }

    public static final <T> T single(@NotNull T[] tArr, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(tArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (function1.invoke(t2).booleanValue()) {
                if (!z) {
                    z = true;
                    t = t2;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (float f2 : fArr) {
            if (function1.invoke(Float.valueOf(f2)).booleanValue()) {
                return f2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float maxOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$maxOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = Math.max(f2, fArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Float minOrNull(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$minOrNull");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = Math.min(f2, fArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @NotNull
    public static final float[] sliceArray(@NotNull float[] fArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(fArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new float[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(fArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final List<Long> slice(@NotNull long[] jArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Long.valueOf(jArr[num.intValue()]));
        }
        return arrayList;
    }

    public static final double first(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                return d2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        int i2;
        Intrinsics.checkNotNullParameter(iArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = iArr.length;
        do {
            length--;
            if (length >= 0) {
                i2 = iArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Integer.valueOf(i2)).booleanValue());
        return i2;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character reduceIndexedOrNull(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceIndexedOrNull");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                c2 = function3.invoke(Integer.valueOf(i2), Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Character reduceOrNull(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceOrNull");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                c2 = function2.invoke(Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull double[] dArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(dArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            double d2 = dArr[lastIndex];
            dArr[lastIndex] = dArr[nextInt];
            dArr[nextInt] = d2;
        }
    }

    @NotNull
    public static final double[] sliceArray(@NotNull double[] dArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(dArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new double[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(dArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull int[] iArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Integer, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Integer.valueOf(iArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(bArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(bArr.length), 16));
        for (byte b2 : bArr) {
            linkedHashMap.put(function1.invoke(Byte.valueOf(b2)), function12.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final List<Character> dropWhile(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$dropWhile");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (char c2 : cArr) {
            if (z) {
                arrayList.add(Character.valueOf(c2));
            } else if (!function1.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
                z = true;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        for (char c2 : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(Character.valueOf(c2));
        }
        return m;
    }

    public static final char reduce(@NotNull char[] cArr, @NotNull Function2<? super Character, ? super Character, Character> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduce");
        Intrinsics.checkNotNullParameter(function2, "operation");
        int i2 = 1;
        if (!(cArr.length == 0)) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    c2 = function2.invoke(Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceIndexed(@NotNull char[] cArr, @NotNull Function3<? super Integer, ? super Character, ? super Character, Character> function3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reduceIndexed");
        Intrinsics.checkNotNullParameter(function3, "operation");
        int i2 = 1;
        if (!(cArr.length == 0)) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    c2 = function3.invoke(Integer.valueOf(i2), Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final void reverse(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reverse");
        int length = (cArr.length / 2) - 1;
        if (length >= 0) {
            int lastIndex = getLastIndex(cArr);
            int i2 = 0;
            if (length >= 0) {
                while (true) {
                    char c2 = cArr[i2];
                    cArr[i2] = cArr[lastIndex];
                    cArr[lastIndex] = c2;
                    lastIndex--;
                    if (i2 != length) {
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static final byte single(@NotNull byte[] bArr, @NotNull Function1<? super Byte, Boolean> function1) {
        Intrinsics.checkNotNullParameter(bArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Byte b2 = null;
        boolean z = false;
        for (byte b3 : bArr) {
            if (function1.invoke(Byte.valueOf(b3)).booleanValue()) {
                if (!z) {
                    b2 = Byte.valueOf(b3);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(b2, "null cannot be cast to non-null type kotlin.Byte");
            return b2.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean first(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                return z;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull double[] dArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (double d2 : dArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Double.valueOf(d2)));
            } else {
                a3.append(String.valueOf(d2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean maxWithOrNull(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                    z = z2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Boolean minWithOrNull(@NotNull boolean[] zArr, @NotNull Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                    z = z2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @NotNull
    public static final boolean[] sliceArray(@NotNull boolean[] zArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(zArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new boolean[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(zArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <K> List<Boolean> distinctBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (hashSet.add(function1.invoke(Boolean.valueOf(z)))) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Boolean>> groupBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Pair<List<Double>, List<Double>> partition(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d2 : dArr) {
            if (function1.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            } else {
                arrayList2.add(Double.valueOf(d2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final List<Double> take(@NotNull double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= dArr.length) {
                return toList(dArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Double.valueOf(dArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (double d2 : dArr) {
                arrayList.add(Double.valueOf(d2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Double> takeLast(@NotNull double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = dArr.length;
            if (i2 >= length) {
                return toList(dArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Double.valueOf(dArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Double.valueOf(dArr[i3]));
            }
            return arrayList;
        }
    }

    public static final char first(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$first");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                return c2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        long j;
        Intrinsics.checkNotNullParameter(jArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = jArr.length;
        do {
            length--;
            if (length >= 0) {
                j = jArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Long.valueOf(j)).booleanValue());
        return j;
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Float maxBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        Comparable comparable = (Comparable) function1.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Float.valueOf(f3));
                if (comparable.compareTo(comparable2) < 0) {
                    f2 = f3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Float maxByOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        Comparable comparable = (Comparable) function1.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Float.valueOf(f3));
                if (comparable.compareTo(comparable2) < 0) {
                    f2 = f3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double maxOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$maxOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = Math.max(d2, dArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Float minBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        Comparable comparable = (Comparable) function1.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Float.valueOf(f3));
                if (comparable.compareTo(comparable2) > 0) {
                    f2 = f3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Float minByOrNull(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        Comparable comparable = (Comparable) function1.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Float.valueOf(f3));
                if (comparable.compareTo(comparable2) > 0) {
                    f2 = f3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Double minOrNull(@NotNull double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$minOrNull");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = Math.min(d2, dArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @NotNull
    public static final List<Float> slice(@NotNull float[] fArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(fArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Float.valueOf(fArr[num.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final char[] sliceArray(@NotNull char[] cArr, @NotNull IntRange intRange) {
        Intrinsics.checkNotNullParameter(cArr, "$this$sliceArray");
        Intrinsics.checkNotNullParameter(intRange, "indices");
        if (intRange.isEmpty()) {
            return new char[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(cArr, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull long[] jArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Long, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Long.valueOf(jArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(sArr.length), 16));
        for (short s : sArr) {
            linkedHashMap.put(function1.invoke(Short.valueOf(s)), function12.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull boolean[] zArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(zArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            boolean z = zArr[lastIndex];
            zArr[lastIndex] = zArr[nextInt];
            zArr[nextInt] = z;
        }
    }

    @NotNull
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull T[] tArr, @NotNull M m, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(tArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(t));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final <T> void reverse(@NotNull T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, tArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                T t = tArr[i2];
                tArr[i2] = tArr[i5];
                tArr[i5] = t;
                i5--;
                i2++;
            }
        }
    }

    public static final short single(@NotNull short[] sArr, @NotNull Function1<? super Short, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s : sArr) {
            if (function1.invoke(Short.valueOf(s)).booleanValue()) {
                if (!z) {
                    sh = Short.valueOf(s);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(sh, "null cannot be cast to non-null type kotlin.Short");
            return sh.shortValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        float f2;
        Intrinsics.checkNotNullParameter(fArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = fArr.length;
        do {
            length--;
            if (length >= 0) {
                f2 = fArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Float.valueOf(f2)).booleanValue());
        return f2;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character maxWithOrNull(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "$this$maxWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character minWithOrNull(@NotNull char[] cArr, @NotNull Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "$this$minWithOrNull");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull float[] fArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Float, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Float.valueOf(fArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(iArr.length), 16));
        for (int i2 : iArr) {
            linkedHashMap.put(function1.invoke(Integer.valueOf(i2)), function12.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K> List<Character> distinctBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$distinctBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (hashSet.add(function1.invoke(Character.valueOf(c2)))) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K> Map<K, List<Character>> groupBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c2 : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(Character.valueOf(c2));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull boolean[] zArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (boolean z : zArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Boolean.valueOf(z)));
            } else {
                a3.append(String.valueOf(z));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    @NotNull
    public static final List<Double> slice(@NotNull double[] dArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(dArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Double.valueOf(dArr[num.intValue()]));
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character maxOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$maxOrNull");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (Intrinsics.compare((int) c2, (int) c3) < 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final Character minOrNull(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$minOrNull");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (Intrinsics.compare((int) c2, (int) c3) > 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @NotNull
    public static final Pair<List<Boolean>, List<Boolean>> partition(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z : zArr) {
            if (function1.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            } else {
                arrayList2.add(Boolean.valueOf(z));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @SinceKotlin(version = "1.4")
    public static final void shuffle(@NotNull char[] cArr, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(cArr, "$this$shuffle");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 1; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            char c2 = cArr[lastIndex];
            cArr[lastIndex] = cArr[nextInt];
            cArr[nextInt] = c2;
        }
    }

    @NotNull
    public static final List<Boolean> take(@NotNull boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= zArr.length) {
                return toList(zArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Boolean.valueOf(zArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (boolean z : zArr) {
                arrayList.add(Boolean.valueOf(z));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Boolean> takeLast(@NotNull boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = zArr.length;
            if (i2 >= length) {
                return toList(zArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Boolean.valueOf(zArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Boolean.valueOf(zArr[i3]));
            }
            return arrayList;
        }
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull byte[] bArr, @NotNull M m, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(bArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (byte b2 : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Byte.valueOf(b2)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, bArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                byte b2 = bArr[i2];
                bArr[i2] = bArr[i5];
                bArr[i5] = b2;
                i5--;
                i2++;
            }
        }
    }

    public static final double last(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        double d2;
        Intrinsics.checkNotNullParameter(dArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = dArr.length;
        do {
            length--;
            if (length >= 0) {
                d2 = dArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Double.valueOf(d2)).booleanValue());
        return d2;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull double[] dArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Double, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Double.valueOf(dArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(jArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(jArr.length), 16));
        for (long j : jArr) {
            linkedHashMap.put(function1.invoke(Long.valueOf(j)), function12.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Double maxBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        Comparable comparable = (Comparable) function1.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Double.valueOf(d3));
                if (comparable.compareTo(comparable2) < 0) {
                    d2 = d3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Double maxByOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        Comparable comparable = (Comparable) function1.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Double.valueOf(d3));
                if (comparable.compareTo(comparable2) < 0) {
                    d2 = d3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Double minBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        Comparable comparable = (Comparable) function1.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Double.valueOf(d3));
                if (comparable.compareTo(comparable2) > 0) {
                    d2 = d3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Double minByOrNull(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        Comparable comparable = (Comparable) function1.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Double.valueOf(d3));
                if (comparable.compareTo(comparable2) > 0) {
                    d2 = d3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final int single(@NotNull int[] iArr, @NotNull Function1<? super Integer, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i2 : iArr) {
            if (function1.invoke(Integer.valueOf(i2)).booleanValue()) {
                if (!z) {
                    num = Integer.valueOf(i2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(num, "null cannot be cast to non-null type kotlin.Int");
            return num.intValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final List<Boolean> slice(@NotNull boolean[] zArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(zArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Boolean.valueOf(zArr[num.intValue()]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, K, V> Map<K, List<V>> groupBy(@NotNull T[] tArr, @NotNull Function1<? super T, ? extends K> function1, @NotNull Function1<? super T, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(tArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            Object invoke = function1.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(t));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull short[] sArr, @NotNull M m, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Short.valueOf(s)));
        }
        return m;
    }

    @NotNull
    public static final <A extends Appendable> A joinTo(@NotNull char[] cArr, @NotNull A a3, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i2, @NotNull CharSequence charSequence4, @Nullable Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$joinTo");
        Intrinsics.checkNotNullParameter(a3, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        a3.append(charSequence2);
        int i3 = 0;
        for (char c2 : cArr) {
            i3++;
            if (i3 > 1) {
                a3.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                a3.append((CharSequence) function1.invoke(Character.valueOf(c2)));
            } else {
                a3.append(c2);
            }
        }
        if (i2 >= 0 && i3 > i2) {
            a3.append(charSequence4);
        }
        a3.append(charSequence3);
        return a3;
    }

    public static final boolean last(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = zArr.length;
        do {
            length--;
            if (length >= 0) {
                z = zArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Boolean.valueOf(z)).booleanValue());
        return z;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, sArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                short s = sArr[i2];
                sArr[i2] = sArr[i5];
                sArr[i5] = s;
                i5--;
                i2++;
            }
        }
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Boolean, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Boolean.valueOf(zArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(fArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(fArr.length), 16));
        for (float f2 : fArr) {
            linkedHashMap.put(function1.invoke(Float.valueOf(f2)), function12.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final Pair<List<Character>, List<Character>> partition(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$partition");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            } else {
                arrayList2.add(Character.valueOf(c2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    @NotNull
    public static final List<Character> take(@NotNull char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$take");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            if (i2 >= cArr.length) {
                return toList(cArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Character.valueOf(cArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (char c2 : cArr) {
                arrayList.add(Character.valueOf(c2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
    }

    @NotNull
    public static final List<Character> takeLast(@NotNull char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$takeLast");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        } else {
            int length = cArr.length;
            if (i2 >= length) {
                return toList(cArr);
            }
            if (i2 == 1) {
                return t6.n.d.listOf(Character.valueOf(cArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Character.valueOf(cArr[i3]));
            }
            return arrayList;
        }
    }

    public static final long single(@NotNull long[] jArr, @NotNull Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(jArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Long l = null;
        boolean z = false;
        for (long j : jArr) {
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                if (!z) {
                    l = Long.valueOf(j);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(l, "null cannot be cast to non-null type kotlin.Long");
            return l.longValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final List<Character> slice(@NotNull char[] cArr, @NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(cArr, "$this$slice");
        Intrinsics.checkNotNullParameter(iterable, "indices");
        int collectionSizeOrDefault = t6.n.e.collectionSizeOrDefault(iterable, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Integer num : iterable) {
            arrayList.add(Character.valueOf(cArr[num.intValue()]));
        }
        return arrayList;
    }

    public static final char last(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        char c2;
        Intrinsics.checkNotNullParameter(cArr, "$this$last");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int length = cArr.length;
        do {
            length--;
            if (length >= 0) {
                c2 = cArr[length];
            } else {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
        } while (!function1.invoke(Character.valueOf(c2)).booleanValue());
        return c2;
    }

    @NotNull
    public static final <R, V> List<V> zip(@NotNull char[] cArr, @NotNull Iterable<? extends R> iterable, @NotNull Function2<? super Character, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        Iterator<? extends R> it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (i2 >= length) {
                break;
            }
            arrayList.add(function2.invoke(Character.valueOf(cArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(dArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(dArr.length), 16));
        for (double d2 : dArr) {
            linkedHashMap.put(function1.invoke(Double.valueOf(d2)), function12.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull byte[] bArr, @NotNull Function1<? super Byte, ? extends K> function1, @NotNull Function1<? super Byte, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(bArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b2 : bArr) {
            Object invoke = function1.invoke(Byte.valueOf(b2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull int[] iArr, @NotNull M m, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (int i2 : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Integer.valueOf(i2)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, iArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                int i6 = iArr[i2];
                iArr[i2] = iArr[i5];
                iArr[i5] = i6;
                i5--;
                i2++;
            }
        }
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Boolean maxBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z);
        }
        Comparable comparable = (Comparable) function1.invoke(Boolean.valueOf(z));
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Boolean.valueOf(z2));
                if (comparable.compareTo(comparable2) < 0) {
                    z = z2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Boolean maxByOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z);
        }
        Comparable comparable = (Comparable) function1.invoke(Boolean.valueOf(z));
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Boolean.valueOf(z2));
                if (comparable.compareTo(comparable2) < 0) {
                    z = z2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Boolean minBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z);
        }
        Comparable comparable = (Comparable) function1.invoke(Boolean.valueOf(z));
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Boolean.valueOf(z2));
                if (comparable.compareTo(comparable2) > 0) {
                    z = z2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Boolean minByOrNull(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z);
        }
        Comparable comparable = (Comparable) function1.invoke(Boolean.valueOf(z));
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Boolean.valueOf(z2));
                if (comparable.compareTo(comparable2) > 0) {
                    z = z2;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull byte[] bArr, @NotNull byte[] bArr2, @NotNull Function2<? super Byte, ? super Byte, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(bArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(bArr2[i2])));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(zArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(zArr.length), 16));
        for (boolean z : zArr) {
            linkedHashMap.put(function1.invoke(Boolean.valueOf(z)), function12.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    public static final float single(@NotNull float[] fArr, @NotNull Function1<? super Float, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Float f2 = null;
        boolean z = false;
        for (float f3 : fArr) {
            if (function1.invoke(Float.valueOf(f3)).booleanValue()) {
                if (!z) {
                    f2 = Float.valueOf(f3);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(f2, "null cannot be cast to non-null type kotlin.Float");
            return f2.floatValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull long[] jArr, @NotNull M m, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(jArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Long.valueOf(j)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, jArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                long j = jArr[i2];
                jArr[i2] = jArr[i5];
                jArr[i5] = j;
                i5--;
                i2++;
            }
        }
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull short[] sArr, @NotNull Function1<? super Short, ? extends K> function1, @NotNull Function1<? super Short, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(sArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s : sArr) {
            Object invoke = function1.invoke(Short.valueOf(s));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Short.valueOf(s)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull short[] sArr, @NotNull short[] sArr2, @NotNull Function2<? super Short, ? super Short, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(sArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Short.valueOf(sArr[i2]), Short.valueOf(sArr2[i2])));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> associateBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(cArr, "$this$associateBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(cArr.length), 16));
        for (char c2 : cArr) {
            linkedHashMap.put(function1.invoke(Character.valueOf(c2)), function12.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull int[] iArr, @NotNull int[] iArr2, @NotNull Function2<? super Integer, ? super Integer, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(iArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull float[] fArr, @NotNull M m, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(fArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (float f2 : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Float.valueOf(f2)));
        }
        return m;
    }

    @Nullable
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Character maxBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$maxBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(c3));
                if (comparable.compareTo(comparable2) < 0) {
                    c2 = c3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Character maxByOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$maxByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(c3));
                if (comparable.compareTo(comparable2) < 0) {
                    c2 = c3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @Nullable
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4")
    public static final <R extends Comparable<? super R>> Character minBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$minBy");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(c3));
                if (comparable.compareTo(comparable2) > 0) {
                    c2 = c3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    public static final <R extends Comparable<? super R>> Character minByOrNull(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$minByOrNull");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        Comparable comparable = (Comparable) function1.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                Comparable comparable2 = (Comparable) function1.invoke(Character.valueOf(c3));
                if (comparable.compareTo(comparable2) > 0) {
                    c2 = c3;
                    comparable = comparable2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, fArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                float f2 = fArr[i2];
                fArr[i2] = fArr[i5];
                fArr[i5] = f2;
                i5--;
                i2++;
            }
        }
    }

    public static final double single(@NotNull double[] dArr, @NotNull Function1<? super Double, Boolean> function1) {
        Intrinsics.checkNotNullParameter(dArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Double d2 = null;
        boolean z = false;
        for (double d3 : dArr) {
            if (function1.invoke(Double.valueOf(d3)).booleanValue()) {
                if (!z) {
                    d2 = Double.valueOf(d3);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(d2, "null cannot be cast to non-null type kotlin.Double");
            return d2.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull int[] iArr, @NotNull Function1<? super Integer, ? extends K> function1, @NotNull Function1<? super Integer, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(iArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 : iArr) {
            Object invoke = function1.invoke(Integer.valueOf(i2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull long[] jArr, @NotNull long[] jArr2, @NotNull Function2<? super Long, ? super Long, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(jArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Long.valueOf(jArr[i2]), Long.valueOf(jArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull double[] dArr, @NotNull M m, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(dArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (double d2 : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Double.valueOf(d2)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, dArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                double d2 = dArr[i2];
                dArr[i2] = dArr[i5];
                dArr[i5] = d2;
                i5--;
                i2++;
            }
        }
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull float[] fArr, @NotNull float[] fArr2, @NotNull Function2<? super Float, ? super Float, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$zip");
        Intrinsics.checkNotNullParameter(fArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Float.valueOf(fArr[i2]), Float.valueOf(fArr2[i2])));
        }
        return arrayList;
    }

    public static final boolean single(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, Boolean> function1) {
        Intrinsics.checkNotNullParameter(zArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (function1.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (!z) {
                    bool = Boolean.valueOf(z2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
            return bool.booleanValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull long[] jArr, @NotNull Function1<? super Long, ? extends K> function1, @NotNull Function1<? super Long, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(jArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j : jArr) {
            Object invoke = function1.invoke(Long.valueOf(j));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Long.valueOf(j)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull double[] dArr, @NotNull double[] dArr2, @NotNull Function2<? super Double, ? super Double, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$zip");
        Intrinsics.checkNotNullParameter(dArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Double.valueOf(dArr[i2]), Double.valueOf(dArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull boolean[] zArr, @NotNull M m, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(zArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Boolean.valueOf(z)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull boolean[] zArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, zArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                boolean z = zArr[i2];
                zArr[i2] = zArr[i5];
                zArr[i5] = z;
                i5--;
                i2++;
            }
        }
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull boolean[] zArr, @NotNull boolean[] zArr2, @NotNull Function2<? super Boolean, ? super Boolean, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$zip");
        Intrinsics.checkNotNullParameter(zArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(zArr2[i2])));
        }
        return arrayList;
    }

    public static final char single(@NotNull char[] cArr, @NotNull Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(cArr, "$this$single");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c2 : cArr) {
            if (function1.invoke(Character.valueOf(c2)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(c2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Objects.requireNonNull(ch, "null cannot be cast to non-null type kotlin.Char");
            return ch.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull float[] fArr, @NotNull Function1<? super Float, ? extends K> function1, @NotNull Function1<? super Float, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(fArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : fArr) {
            Object invoke = function1.invoke(Float.valueOf(f2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <V> List<V> zip(@NotNull char[] cArr, @NotNull char[] cArr2, @NotNull Function2<? super Character, ? super Character, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$zip");
        Intrinsics.checkNotNullParameter(cArr2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(function2.invoke(Character.valueOf(cArr[i2]), Character.valueOf(cArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(@NotNull char[] cArr, @NotNull M m, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(cArr, "$this$groupByTo");
        Intrinsics.checkNotNullParameter(m, "destination");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        for (char c2 : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c2));
            Object obj = m.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.j0(m, invoke);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(c2)));
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    public static final void reverse(@NotNull char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "$this$reverse");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, cArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 != i4) {
            int i5 = i3 - 1;
            while (i2 < i4) {
                char c2 = cArr[i2];
                cArr[i2] = cArr[i5];
                cArr[i5] = c2;
                i5--;
                i2++;
            }
        }
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] tArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(tArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(tArr[i2], rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull double[] dArr, @NotNull Function1<? super Double, ? extends K> function1, @NotNull Function1<? super Double, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(dArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d2 : dArr) {
            Object invoke = function1.invoke(Double.valueOf(d2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] bArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            byte b2 = bArr[i2];
            arrayList.add(TuplesKt.to(Byte.valueOf(b2), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> zip(@NotNull short[] sArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            short s = sArr[i2];
            arrayList.add(TuplesKt.to(Short.valueOf(s), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull boolean[] zArr, @NotNull Function1<? super Boolean, ? extends K> function1, @NotNull Function1<? super Boolean, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(zArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            Object invoke = function1.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] iArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = iArr[i2];
            arrayList.add(TuplesKt.to(Integer.valueOf(i3), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V> Map<K, List<V>> groupBy(@NotNull char[] cArr, @NotNull Function1<? super Character, ? extends K> function1, @NotNull Function1<? super Character, ? extends V> function12) {
        Intrinsics.checkNotNullParameter(cArr, "$this$groupBy");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        Intrinsics.checkNotNullParameter(function12, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c2 : cArr) {
            Object invoke = function1.invoke(Character.valueOf(c2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = a2.b.a.a.a.h0(linkedHashMap, invoke);
            }
            ((List) obj).add(function12.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> zip(@NotNull long[] jArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            long j = jArr[i2];
            arrayList.add(TuplesKt.to(Long.valueOf(j), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> zip(@NotNull float[] fArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(fArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            float f2 = fArr[i2];
            arrayList.add(TuplesKt.to(Float.valueOf(f2), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> zip(@NotNull double[] dArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(dArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            double d2 = dArr[i2];
            arrayList.add(TuplesKt.to(Double.valueOf(d2), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] zArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(zArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            boolean z = zArr[i2];
            arrayList.add(TuplesKt.to(Boolean.valueOf(z), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> zip(@NotNull char[] cArr, @NotNull R[] rArr) {
        Intrinsics.checkNotNullParameter(cArr, "$this$zip");
        Intrinsics.checkNotNullParameter(rArr, "other");
        int min = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            char c2 = cArr[i2];
            arrayList.add(TuplesKt.to(Character.valueOf(c2), rArr[i2]));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<Pair<T, R>> zip(@NotNull T[] tArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(tArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(tArr[i2], obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Byte, R>> zip(@NotNull byte[] bArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Byte.valueOf(bArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Short, R>> zip(@NotNull short[] sArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Short.valueOf(sArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Integer, R>> zip(@NotNull int[] iArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(iArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Long, R>> zip(@NotNull long[] jArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Long.valueOf(jArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Float, R>> zip(@NotNull float[] fArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(fArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Float.valueOf(fArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Double, R>> zip(@NotNull double[] dArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(dArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Double.valueOf(dArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Boolean, R>> zip(@NotNull boolean[] zArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(zArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Boolean.valueOf(zArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final <R> List<Pair<Character, R>> zip(@NotNull char[] cArr, @NotNull Iterable<? extends R> iterable) {
        Intrinsics.checkNotNullParameter(cArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iterable, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(t6.n.e.collectionSizeOrDefault(iterable, 10), length));
        int i2 = 0;
        for (Object obj : iterable) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Character.valueOf(cArr[i2]), obj));
            i2++;
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Byte, Byte>> zip(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$zip");
        Intrinsics.checkNotNullParameter(bArr2, "other");
        int min = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Byte.valueOf(bArr[i2]), Byte.valueOf(bArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Short, Short>> zip(@NotNull short[] sArr, @NotNull short[] sArr2) {
        Intrinsics.checkNotNullParameter(sArr, "$this$zip");
        Intrinsics.checkNotNullParameter(sArr2, "other");
        int min = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Short.valueOf(sArr[i2]), Short.valueOf(sArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Integer, Integer>> zip(@NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(iArr, "$this$zip");
        Intrinsics.checkNotNullParameter(iArr2, "other");
        int min = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Integer.valueOf(iArr[i2]), Integer.valueOf(iArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Long, Long>> zip(@NotNull long[] jArr, @NotNull long[] jArr2) {
        Intrinsics.checkNotNullParameter(jArr, "$this$zip");
        Intrinsics.checkNotNullParameter(jArr2, "other");
        int min = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Long.valueOf(jArr[i2]), Long.valueOf(jArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Float, Float>> zip(@NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "$this$zip");
        Intrinsics.checkNotNullParameter(fArr2, "other");
        int min = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Float.valueOf(fArr[i2]), Float.valueOf(fArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Double, Double>> zip(@NotNull double[] dArr, @NotNull double[] dArr2) {
        Intrinsics.checkNotNullParameter(dArr, "$this$zip");
        Intrinsics.checkNotNullParameter(dArr2, "other");
        int min = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Double.valueOf(dArr[i2]), Double.valueOf(dArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Boolean, Boolean>> zip(@NotNull boolean[] zArr, @NotNull boolean[] zArr2) {
        Intrinsics.checkNotNullParameter(zArr, "$this$zip");
        Intrinsics.checkNotNullParameter(zArr2, "other");
        int min = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Boolean.valueOf(zArr[i2]), Boolean.valueOf(zArr2[i2])));
        }
        return arrayList;
    }

    @NotNull
    public static final List<Pair<Character, Character>> zip(@NotNull char[] cArr, @NotNull char[] cArr2) {
        Intrinsics.checkNotNullParameter(cArr, "$this$zip");
        Intrinsics.checkNotNullParameter(cArr2, "other");
        int min = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Character.valueOf(cArr[i2]), Character.valueOf(cArr2[i2])));
        }
        return arrayList;
    }
}
