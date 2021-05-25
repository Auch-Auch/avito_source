package t6.n;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class h extends g {
    public static final <T> boolean addAll(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean b(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (function1.invoke((Object) it.next()).booleanValue() == z) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    public static final <T> boolean c(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        int i;
        if (!(list instanceof RandomAccess)) {
            Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T>");
            return b(TypeIntrinsics.asMutableIterable(list), function1, z);
        }
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex >= 0) {
            int i2 = 0;
            i = 0;
            while (true) {
                T t = list.get(i2);
                if (function1.invoke(t).booleanValue() != z) {
                    if (i != i2) {
                        list.set(i, t);
                    }
                    i++;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i >= list.size()) {
            return false;
        }
        int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (lastIndex2 < i) {
            return true;
        }
        while (true) {
            list.remove(lastIndex2);
            if (lastIndex2 == i) {
                return true;
            }
            lastIndex2--;
        }
    }

    public static final <T> boolean removeAll(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$removeAll");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        return TypeIntrinsics.asMutableCollection(collection).removeAll(e.convertToSetForSetOperationWith(iterable, collection));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeFirst(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$removeFirst");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeFirstOrNull(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$removeFirstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeLast(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$removeLast");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T removeLastOrNull(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$removeLastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
    }

    public static final <T> boolean retainAll(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(collection, "$this$retainAll");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        return TypeIntrinsics.asMutableCollection(collection).retainAll(e.convertToSetForSetOperationWith(iterable, collection));
    }

    public static final <T> boolean removeAll(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "$this$removeAll");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(sequence);
        return (hashSet.isEmpty() ^ true) && collection.removeAll(hashSet);
    }

    public static final <T> boolean retainAll(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "$this$retainAll");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        if (!(tArr.length == 0)) {
            return collection.retainAll(ArraysKt___ArraysKt.toHashSet(tArr));
        }
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> boolean addAll(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        Iterator<? extends T> it = sequence.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean removeAll(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "$this$removeAll");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return ((tArr.length == 0) ^ true) && collection.removeAll(ArraysKt___ArraysKt.toHashSet(tArr));
    }

    public static final <T> boolean removeAll(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$removeAll");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return b(iterable, function1, true);
    }

    public static final <T> boolean addAll(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(collection, "$this$addAll");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return collection.addAll(ArraysKt___ArraysJvmKt.asList(tArr));
    }

    public static final <T> boolean removeAll(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$removeAll");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return c(list, function1, true);
    }

    public static final <T> boolean retainAll(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(collection, "$this$retainAll");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        HashSet hashSet = SequencesKt___SequencesKt.toHashSet(sequence);
        if (!hashSet.isEmpty()) {
            return collection.retainAll(hashSet);
        }
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static final <T> boolean retainAll(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "$this$retainAll");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return b(iterable, function1, false);
    }

    public static final <T> boolean retainAll(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "$this$retainAll");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return c(list, function1, false);
    }
}
