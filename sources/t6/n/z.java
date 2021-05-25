package t6.n;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
public class z extends y {
    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(q.mapCapacity(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && Intrinsics.areEqual((Object) t2, (Object) t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, T t) {
        Intrinsics.checkNotNullParameter(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(q.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "$this$minus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        h.removeAll(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.checkNotNullParameter(set, "$this$plus");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(q.mapCapacity(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        h.addAll(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(set, "$this$minus");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        Collection<?> convertToSetForSetOperationWith = e.convertToSetForSetOperationWith(iterable, set);
        if (convertToSetForSetOperationWith.isEmpty()) {
            return CollectionsKt___CollectionsKt.toSet(set);
        }
        if (convertToSetForSetOperationWith instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!convertToSetForSetOperationWith.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(convertToSetForSetOperationWith);
        return linkedHashSet2;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        int i;
        Intrinsics.checkNotNullParameter(set, "$this$plus");
        Intrinsics.checkNotNullParameter(iterable, MessengerShareContentUtility.ELEMENTS);
        Integer collectionSizeOrNull = e.collectionSizeOrNull(iterable);
        if (collectionSizeOrNull != null) {
            i = set.size() + collectionSizeOrNull.intValue();
        } else {
            i = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(q.mapCapacity(i));
        linkedHashSet.addAll(set);
        h.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> plus(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "$this$plus");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(q.mapCapacity(set.size() * 2));
        linkedHashSet.addAll(set);
        h.addAll(linkedHashSet, sequence);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> minus(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(set, "$this$minus");
        Intrinsics.checkNotNullParameter(sequence, MessengerShareContentUtility.ELEMENTS);
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        h.removeAll(linkedHashSet, sequence);
        return linkedHashSet;
    }
}
