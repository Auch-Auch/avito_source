package t6.n;

import a2.b.a.a.a;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
public class i extends h {
    public static final int access$reverseElementIndex(List list, int i) {
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return CollectionsKt__CollectionsKt.getLastIndex(list) - i;
        }
        StringBuilder M = a.M("Element index ", i, " must be in range [");
        M.append(new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)));
        M.append("].");
        throw new IndexOutOfBoundsException(M.toString());
    }

    public static final int access$reversePositionIndex(List list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder M = a.M("Position index ", i, " must be in range [");
        M.append(new IntRange(0, list.size()));
        M.append("].");
        throw new IndexOutOfBoundsException(M.toString());
    }

    @NotNull
    public static final <T> List<T> asReversed(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$asReversed");
        return new w(list);
    }

    @JvmName(name = "asReversedMutable")
    @NotNull
    public static final <T> List<T> asReversedMutable(@NotNull List<T> list) {
        Intrinsics.checkNotNullParameter(list, "$this$asReversed");
        return new v(list);
    }
}
