package t6.n;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class y extends x {
    @NotNull
    public static final <T> Set<T> emptySet() {
        return EmptySet.INSTANCE;
    }

    @NotNull
    public static final <T> HashSet<T> hashSetOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return (HashSet) ArraysKt___ArraysKt.toCollection(tArr, new HashSet(q.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final <T> LinkedHashSet<T> linkedSetOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return (LinkedHashSet) ArraysKt___ArraysKt.toCollection(tArr, new LinkedHashSet(q.mapCapacity(tArr.length)));
    }

    @NotNull
    public static final <T> Set<T> mutableSetOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return (Set) ArraysKt___ArraysKt.toCollection(tArr, new LinkedHashSet(q.mapCapacity(tArr.length)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> Set<T> optimizeReadOnlySet(@NotNull Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "$this$optimizeReadOnlySet");
        int size = set.size();
        if (size == 0) {
            return emptySet();
        }
        if (size != 1) {
            return set;
        }
        return x.setOf(set.iterator().next());
    }

    @NotNull
    public static final <T> Set<T> setOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return tArr.length > 0 ? ArraysKt___ArraysKt.toSet(tArr) : emptySet();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@Nullable T t) {
        return t != null ? x.setOf(t) : emptySet();
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Set<T> setOfNotNull(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return (Set) ArraysKt___ArraysKt.filterNotNullTo(tArr, new LinkedHashSet());
    }
}
