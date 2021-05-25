package t6.v;

import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class b implements ClosedFloatingPointRange<Float> {
    public final float a;
    public final float b;

    public b(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean contains(Comparable comparable) {
        float floatValue = ((Number) comparable).floatValue();
        return floatValue >= this.a && floatValue <= this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (!(this.a == bVar.a && this.b == bVar.b)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public Comparable getEndInclusive() {
        return Float.valueOf(this.b);
    }

    @Override // kotlin.ranges.ClosedRange
    public Comparable getStart() {
        return Float.valueOf(this.a);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.valueOf(this.a).hashCode() * 31) + Float.valueOf(this.b).hashCode();
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return this.a > this.b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable, java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedFloatingPointRange
    public boolean lessThanOrEquals(Float f, Float f2) {
        return f.floatValue() <= f2.floatValue();
    }

    @NotNull
    public String toString() {
        return this.a + ".." + this.b;
    }
}
