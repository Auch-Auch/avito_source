package t6.v;

import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a implements ClosedFloatingPointRange<Double> {
    public final double a;
    public final double b;

    public a(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean contains(Comparable comparable) {
        double doubleValue = ((Number) comparable).doubleValue();
        return doubleValue >= this.a && doubleValue <= this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.a == aVar.a && this.b == aVar.b)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public Comparable getEndInclusive() {
        return Double.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange
    public Comparable getStart() {
        return Double.valueOf(this.a);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.a).hashCode() * 31) + Double.valueOf(this.b).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean lessThanOrEquals(Double d, Double d2) {
        return d.doubleValue() <= d2.doubleValue();
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
