package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\f¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0007\u0010\b\u001a>\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\n¢\u0006\u0004\b\u0007\u0010\n\u001a>\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\f¢\u0006\u0004\b\u000b\u0010\n\u001a/\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"", "T", "that", "Landroid/util/Range;", "rangeTo", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "value", "plus", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "other", "(Landroid/util/Range;Landroid/util/Range;)Landroid/util/Range;", "and", "Lkotlin/ranges/ClosedRange;", "toClosedRange", "(Landroid/util/Range;)Lkotlin/ranges/ClosedRange;", "toRange", "(Lkotlin/ranges/ClosedRange;)Landroid/util/Range;", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
public final class RangeKt {
    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> and(@NotNull Range<T> range, @NotNull Range<T> range2) {
        Intrinsics.checkParameterIsNotNull(range, "$this$and");
        Intrinsics.checkParameterIsNotNull(range2, "other");
        Range<T> intersect = range.intersect(range2);
        Intrinsics.checkExpressionValueIsNotNull(intersect, "intersect(other)");
        return intersect;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> range, @NotNull T t) {
        Intrinsics.checkParameterIsNotNull(range, "$this$plus");
        Intrinsics.checkParameterIsNotNull(t, "value");
        Range<T> extend = range.extend((Range<T>) t);
        Intrinsics.checkExpressionValueIsNotNull(extend, "extend(value)");
        return extend;
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkParameterIsNotNull(t, "$this$rangeTo");
        Intrinsics.checkParameterIsNotNull(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> toClosedRange(@NotNull Range<T> range) {
        Intrinsics.checkParameterIsNotNull(range, "$this$toClosedRange");
        return new ClosedRange<T>(range) { // from class: androidx.core.util.RangeKt$toClosedRange$1
            public final /* synthetic */ Range a;

            {
                this.a = r1;
            }

            @Override // kotlin.ranges.ClosedRange
            public boolean contains(@NotNull T t) {
                Intrinsics.checkParameterIsNotNull(t, "value");
                return ClosedRange.DefaultImpls.contains(this, t);
            }

            @Override // kotlin.ranges.ClosedRange
            public T getEndInclusive() {
                return (T) this.a.getUpper();
            }

            @Override // kotlin.ranges.ClosedRange
            public T getStart() {
                return (T) this.a.getLower();
            }

            @Override // kotlin.ranges.ClosedRange
            public boolean isEmpty() {
                return ClosedRange.DefaultImpls.isEmpty(this);
            }
        };
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> toRange(@NotNull ClosedRange<T> closedRange) {
        Intrinsics.checkParameterIsNotNull(closedRange, "$this$toRange");
        return new Range<>(closedRange.getStart(), closedRange.getEndInclusive());
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> plus(@NotNull Range<T> range, @NotNull Range<T> range2) {
        Intrinsics.checkParameterIsNotNull(range, "$this$plus");
        Intrinsics.checkParameterIsNotNull(range2, "other");
        Range<T> extend = range.extend(range2);
        Intrinsics.checkExpressionValueIsNotNull(extend, "extend(other)");
        return extend;
    }
}
